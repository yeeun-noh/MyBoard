package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.CommentActivityHistory;

import java.util.List;
import java.util.Optional;

public interface CommentActivityHistoryRepository extends JpaRepository<CommentActivityHistory, Integer> {
    Long countByTypeAndCommentIdAndUserId(int type, int commentId, String userId);
    List<CommentActivityHistory> findAllByTypeAndCommentId(int type, int commentId);
    Optional<CommentActivityHistory> findByTypeAndCommentIdAndUserId(int type, int commentId, String userId);
}