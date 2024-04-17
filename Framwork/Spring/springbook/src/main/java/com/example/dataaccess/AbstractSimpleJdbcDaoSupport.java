package com.example.dataaccess;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

// 이 클래스를 상속해서 DAO를 만들고 initJdbcObjects() 메소드를 오버라이드해서 SimpleJdbcInsert 등을 생성하는 코드를 넣으면 된다.
public abstract class AbstractSimpleJdbcDaoSupport extends JdbcDaoSupport {
    protected SimpleJdbcTemplate simpleJdbcTemplate;

    // JdbcDaoSupport에서 제공하는 초기화용 메소드다. dataSource가 준비된 후에 호출된다.
    @Override
    protected void initTemplateConfig() {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        initJdbcObjects();
    }

    // SimpleJdbcDaoSupport를 상속받는 DAO에서 SimpleJdbcInsert 등을 생성할 때 오버라이드해서 사용할 수 있는 초기화 메소드다.
    protected void initJdbcObjects() {}
}
