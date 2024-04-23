package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MemberJdbcDao extends JdbcDaoSupport {
    SimpleJdbcInsert insert;

    @Override
    protected void initTemplateConfig() {
        insert = new SimpleJdbcInsert(getDataSource()).withTableName("member");
    }

    public void add(Member member) {
        insert.execute(new BeanPropertySqlParameterSource(member));
    }

    public long count() {
        return getJdbcTemplate().queryForObject("select count(*) from member", Long.class).longValue();
    }
}
