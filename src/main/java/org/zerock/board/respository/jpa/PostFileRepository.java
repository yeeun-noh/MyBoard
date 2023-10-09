package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.PostFile;

import java.util.List;

public interface PostFileRepository extends JpaRepository<PostFile, Integer> {

    List<PostFile> findAllByPostId(int postID);
}
