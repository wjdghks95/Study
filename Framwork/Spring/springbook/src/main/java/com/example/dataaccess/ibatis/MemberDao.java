package com.example.dataaccess.ibatis;

import com.example.dataaccess.Member;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class MemberDao {
    private SqlMapClientTemplate sqlMapClientTemplate;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

    public void insert(Member member) {
        sqlMapClientTemplate.insert("insertMember", member);
    }

    public void deleteAll() {
        sqlMapClientTemplate.delete("deleteAll");
    }
}
