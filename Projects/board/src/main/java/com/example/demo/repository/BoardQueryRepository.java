package com.example.demo.repository;

import com.example.demo.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQueryRepository {
    Page<Board> findSearchConditionBoard(String searchText, Pageable pageable);
}
