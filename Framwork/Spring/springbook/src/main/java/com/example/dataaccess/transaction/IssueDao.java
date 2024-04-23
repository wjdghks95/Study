package com.example.dataaccess.transaction;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IssueDao {
    public void add(Issue i);

    public void add(List<Issue> members);

    public void deleteAll();

    @Transactional(readOnly = true)
    public Issue get(int id);

    @Transactional(readOnly = true)
    public Issue getAll();

    @Transactional(readOnly = true)
    public Issue findIssuesByName(String name);
}
