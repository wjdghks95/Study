package com.example.springapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EmbeddedDbTest {
    EmbeddedDatabase db;
    SimpleJdbcTemplate template;

    @Before
    public void setUp() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL) // HSQL, DERBY, H2 세 가지 중 하나를 선택할 수 있다.
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();

        template = new SimpleJdbcTemplate(db);  // EmbeddedDatabase는 DataSource의 서브 인터페이스이므로 DataSource를 필요로 하는 SimpleJdbcTemplate을 만들 때 사용할 수 있다.

    }

    // 매 테스트를 진행한 뒤에 DB를 종료한다. 내장형 메모리 DB는 따로 저장하지 않는 한 애플리케이션과 함께 매번 새롭게 DB가 만들어지고 제거되는 생명주기를 갖는다.
    @After
    public void tearDown() {
        db.shutdown();
    }

    @Test
    public void initData() {
        assertThat(template.queryForInt("select count(*) from sqlmap"), is(2));

        List<Map<String, Object>> list = template.queryForList("select * from sqlmap order by key_");
        assertThat((String) list.get(0).get("key_"), is("KEY1"));
        assertThat((String) list.get(0).get("sql_"), is("SQL1"));
        assertThat((String) list.get(1).get("key_"), is("KEY2"));
        assertThat((String) list.get(1).get("sql_"), is("SQL2"));
    }

    @Test
    public void insert() {
        template.update("insert into sqlmap(key_, sql_) values (?, ?)", "KEY3", "SQL3");
        assertThat(template.queryForInt("select count(*) from sqlmap"), is(3));
    }
}
