package com.example.demo.repository;

import com.example.demo.domain.entity.Board;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static com.example.demo.domain.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepositoryImpl implements BoardQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Board> findSearchConditionBoard(String searchText, Pageable pageable) {
        List<Board> boards = queryFactory
                .selectFrom(board)
                .where(titleCon(searchText).or(contentCon(searchText)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = getCount(searchText);

        return PageableExecutionUtils.getPage(boards, pageable, () -> count.fetchOne());
    }

    private JPAQuery<Long> getCount(String searchText) {
        return queryFactory
                .select(board.count())
                .from(board)
                .where(titleCon(searchText).or(contentCon(searchText)));
    }

    private BooleanExpression titleCon(String searchText) {
        return searchText != null ? board.title.contains(searchText) : null;
    }

    private BooleanExpression contentCon(String searchText) {
        return searchText != null ? board.content.contains(searchText) : null;
    }
}
