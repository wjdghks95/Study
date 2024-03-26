package com.example.springapplication;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSqlService implements SqlService, SqlRegistry, SqlReader {

    private String sqlmapFile;
    private Map<String, String> sqlMap = new HashMap<>(); // 읽어온 SQL을 저장해둘 맵, sqlmap은 SqlRegistry 구현의 일부가 된다. 따라서 외부에서 직접 접근할 수 없다.
    private SqlReader sqlReader;
    private SqlRegistry sqlRegistry;

    // 스프링이 오브젝트를 만드는 시점에서 SQL을 읽어오도록 생성자를 이용한다.
    /*
    public XmlSqlService() {
        // JAXB API를 이용해 XML 문서를 오브젝트 트리로 읽어온다.
        String contextPath = Sqlmap.class.getPackage().getName();
        try {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = UserDao.class.getResourceAsStream("/sqlmap.xml"); // UserDao와 같은 클래스패스의 sqlmap.xml 파일을 변환한다.
            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);

            // 읽어온 SQL을 맵으로 저장해둔다.
            for (SqlType sql : sqlmap.getSql()) {
                sqlMap.put(sql.getKey(), sql.getValue());
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e); // JAXBException은 복구 불가능한 예외다. 불필요한 throw를 피하도록 런타임 예외로 포장해서 던진다.
        }
    }
     */

    public void setSqlmapFile(String sqlmapFile) {
        this.sqlmapFile = sqlmapFile; // sqlmapFile은 SqlReader 구현의 일부가 된다. 따라서 SqlReader 구현 메소드를 통하지 않고는 접근하면 안된다.
    }

    public void setSqlReader(SqlReader sqlReader) {
        this.sqlReader = sqlReader;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    @PostConstruct
    public void loadSql() {
//        String contextPath = Sqlmap.class.getPackage().getName();
//        try {
//            JAXBContext context = JAXBContext.newInstance(contextPath);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            InputStream is = UserDao.class.getResourceAsStream(this.sqlmapFile); // 프로퍼티로 설정을 통해 제공받은 파일 이름을 사용한다.
//            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);
//
//            // 읽어온 SQL을 맵으로 저장해둔다.
//            for (SqlType sql : sqlmap.getSql()) {
//                sqlMap.put(sql.getKey(), sql.getValue());
//            }
//
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }

        this.sqlReader.read(this.sqlRegistry);
    }

    @Override
    public String getSql(String key) {
//        String sql = sqlMap.get(key);
//        if (sql == null) {
//            throw new SqlRetrievalFailureException(key + "를 이용해서 SQL을 찾을 수 없습니다.");
//        } else {
//            return sql;
//        }
        try {
            return this.sqlRegistry.findSql(key);
        } catch (SqlNotFoundException e) {
            throw new SqlRetrievalFailureException(e);
        }
    }

    @Override
    public void registerSql(String key, String sql) {
        sqlMap.put(key, sql);
    }

    @Override
    public String findSql(String key) throws SqlNotFoundException {
        String sql = sqlMap.get(key);
        if (sql == null) {
            throw new SqlNotFoundException(key + "에 대한 SQL을 찾을 수 없습니다.");
        } else {
            return sql;
        }
    }

    @Override
    public void read(SqlRegistry sqlRegistry) {
        String contextPath = Sqlmap.class.getPackage().getName();
        try {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = UserDao.class.getResourceAsStream(sqlmapFile); // 프로퍼티로 설정을 통해 제공받은 파일 이름을 사용한다.
            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);

            // 읽어온 SQL을 맵으로 저장해둔다.
            for (SqlType sql : sqlmap.getSql()) {
//                sqlMap.put(sql.getKey(), sql.getValue());
                sqlRegistry.registerSql(sql.getKey(), sql.getValue()); // SQL 저장 로직 구현에 독립적인 인터페이스를 메소드를 통해 읽어들인 SQL과 키를 전달한다.
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
