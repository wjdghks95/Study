package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao {
    @Override
    public void add(Member member) {

    }

    @Override
    public void addList(List<Member> members) {

    }

    @Override
    public void deleteAll() {

    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return 0;
    }
}
