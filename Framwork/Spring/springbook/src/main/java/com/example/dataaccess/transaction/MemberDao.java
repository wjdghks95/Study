package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
public interface MemberDao {
    public void add(Member member);

    public void addList(List<Member> members);

    public void deleteAll();

//    @Transactional(readOnly = true)
    public long count();

}
