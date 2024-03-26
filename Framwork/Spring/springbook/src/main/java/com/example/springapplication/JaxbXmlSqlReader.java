package com.example.springapplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class JaxbXmlSqlReader implements SqlReader{

    private static final String DEFAULT_SQLMAP_FILE = "/sqlmap.xml";

    private String sqlmapFile = DEFAULT_SQLMAP_FILE; // sqlmapFile 프로퍼티를 지정하면 지정된 파일이 사용되고, 아니라면 디폴트로 넣은 파일이 사용된다.

    public void setSqlmapFile(String sqlmapFile) {
        this.sqlmapFile = sqlmapFile;
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
                sqlRegistry.registerSql(sql.getKey(), sql.getValue()); // SQL 저장 로직 구현에 독립적인 인터페이스를 메소드를 통해 읽어들인 SQL과 키를 전달한다.
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
