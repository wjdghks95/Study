package com.example.springapplication;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class OxmSqlService implements SqlService{

    private final BaseSqlService baseSqlService = new BaseSqlService(); // SqlService의 실제 구현 부분을 위임할 대상인 BaseSqlService를 인스턴스 변수로 정의해둔다.
    private SqlRegistry sqlRegistry = new HashMapSqlRegistry();

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    // final이므로 변경 불가능하다.
    // OxmSqlService와 OxmSqlReader는 강하게 결합되서 하나의 빈으로 등록되고 한 번에 설정할 수 있다.
    private final OxmSqlReader oxmSqlReader = new OxmSqlReader();

    // OxmlSqlService의 공개된 프로퍼티를 통해 DI 받은 것을 그대로 멤버 클래스의 오브젝트에 전달한다. 이 setter들은 단일 빈 설정구조를 위한 창구 역할을 할 뿐이다.
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.oxmSqlReader.setUnmarshaller(unmarshaller);
    }
//    public void setSqlmapFile(String sqlmapFile) {
//        this.oxmSqlReader.sqlmapFile = sqlmapFile;
//    }

    public void setSqlmap(Resource sqlmap) {
        this.oxmSqlReader.setSqlmap(sqlmap);
    }

    @PostConstruct
    public void loadSql() {
//        this.oxmSqlReader.read(this.sqlRegistry);

        // OxmlSqlService의 프로퍼티를 통해서 초기화된 SqlReader와 SqlRegistry를 실제 작업을 위임할 대상인 baseSqlService에 주입한다.
        this.baseSqlService.setSqlReader(this.oxmSqlReader);
        this.baseSqlService.setSqlRegistry(this.sqlRegistry);

        this.baseSqlService.loadSql(); // SQL을 등록하는 초기화 작업을 baseSqlService에 위임한다.
    }

    @Override
    public String getSql(String key) {
        try {
//            return this.sqlRegistry.findSql(key);
            return this.baseSqlService.getSql(key); // SQL을 찾아오는 작업도 baseSqlService에 위임한다.
        } catch (SqlNotFoundException e) {
            throw new SqlRetrievalFailureException(e);
        }
    }

    // private 멤버 클래스로 정의한다. 톱레벨 클래스인 OxmSqlService만이 사용할 수 있다.
    private class OxmSqlReader implements SqlReader {

        private Unmarshaller unmarshaller;
//        private final static String DEFAULT_SQLMAP_FILE = "sqlmap.xml";
//        private String sqlmapFile = DEFAULT_SQLMAP_FILE;
        private Resource sqlmap = new ClassPathResource("sqlmap.xml", UserDao.class);

        public void setUnmarshaller(Unmarshaller unmarshaller) {
            this.unmarshaller = unmarshaller;
        }

//        public void setSqlmapFile(String sqlmapFile) {
//            this.sqlmapFile = sqlmapFile;
//        }


        public void setSqlmap(Resource sqlmap) {
            this.sqlmap = sqlmap;
        }

        @Override
        public void read(SqlRegistry sqlRegistry) {
            try {
//                StreamSource xmlSource = new StreamSource(this.getClass().getResourceAsStream(this.sqlmapFile));
                Source source = new StreamSource(sqlmap.getInputStream()); // 리소스의 종류에 상관없이 스트림으로 가져올 수 있다.
                Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(source); // OxmSqlService를 통해 전달받은 OXM 인터페이스 구현 오브젝트를 가지고 언마샬링 작업 수행

                for(SqlType sql : sqlmap.getSql()) {
                    sqlRegistry.registerSql(sql.getKey(), sql.getValue());
                }

            } catch (IOException e) {
                throw new IllegalArgumentException(this.sqlmap.getFilename() + "을 가져올 수 없습니다.", e);
            }
        }
    }
}
