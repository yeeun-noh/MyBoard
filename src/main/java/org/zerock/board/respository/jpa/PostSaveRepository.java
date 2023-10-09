package org.zerock.board.respository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.PostSave;

public interface PostSaveRepository extends JpaRepository<PostSave, Integer> {

    Page<PostSave> findAllByUserId(String userId, Pageable pageRequest);

    Long countByPostIdAndUserId(int postId, String userId);
}
