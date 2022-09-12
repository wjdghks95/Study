package com.example.demo.repository;

import com.example.demo.domain.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

    @Query("select c from BoardComment c join fetch c.board b where b.id = :id")
    List<BoardComment> findBoardComments(@Param("id") Long id);
}
