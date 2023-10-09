package org.zerock.board.respository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Long countByPostId(int postId);

    Optional<Comment> findById(int commentID);

    Page<Comment> findAllByPostIdAndParentCommentIsNull(int postId, Pageable pageable);

    List<Comment> findAllByPostIdAndParentCommentIsNull(int postId);

    Page<Comment> findAllByWriterId(String writerId, Pageable pageable);
}