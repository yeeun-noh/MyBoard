package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.PostActivityHistory;

import java.util.List;
import java.util.Optional;

public interface PostActivityHistoryRepository extends JpaRepository<PostActivityHistory, Integer> {

    Long countByTypeAndPostIdAndUserId(int type, int postId, String userId);

    List<PostActivityHistory> findAllByTypeAndPostId(int type, String postId);

    Optional<PostActivityHistory> findByTypeAndPostIdAndUserId(int type, int postId, String userId);
}
