package org.zerock.board.respository.jpa;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.domain.Post;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PostRepository  extends JpaRepository<Post, Integer> {

    Optional<Post> findById(int postID);

    List<Post> findAllByBoardId(int boardID, Pageable pageable);

    List<Post> findAllByBoardId(int boardID);

    Page<Post> findAllByWriterId(String writerId, Pageable pageable);

    @Query("SELECT p FROM Post p " +
            "WHERE p.boardId = :boardId AND " +
            "      (:title IS NOT NULL AND p.title LIKE CONCAT('%', COALESCE(:title, ''), '%') OR " +
            "      :content IS NOT NULL AND p.content LIKE CONCAT('%', COALESCE(:content, ''), '%') OR " +
            "      p.writer.id = ALL (SELECT u.id " +
            "                        FROM Users u" +
            "                        WHERE u.nickname LIKE CONCAT('%', COALESCE(:nickname,''), '%'))) " +
            "ORDER BY p.createdDate DESC")
    Page<Post> findAllByCondition(@Param("boardId") int boardId, @Param("title") String title,
                                  @Param("content") String content, @Param("nickname") String nickname,
                                  Pageable pageable);

    @Query("SELECT p FROM Post p " +
            "WHERE (0 < (SELECT count(pa.id) " +
            "           FROM PostActivityHistory pa " +
            "           WHERE p.id = pa.postId AND pa.type = :likeType)) AND " +
            "      (:title IS NOT NULL AND p.title LIKE CONCAT('%', COALESCE(:title, ''), '%') OR " +
            "      :content IS NOT NULL AND p.content LIKE CONCAT('%', COALESCE(:content, ''), '%') OR " +
            "      p.writer.id = ALL (SELECT u.id " +
            "                        FROM Users u " +
            "                        WHERE u.nickname LIKE CONCAT('%', COALESCE(:nickname,''), '%'))) AND " +
            "      (0 < (SELECT count(type) " +
            "             FROM Board b " +
            "             WHERE p.boardId = b.id AND b.boardType.type = org.zerock.board.domain.BoardTypeDefiner.Common)) " +
            "ORDER BY p.createdDate DESC")
    Page<Post> findBestsByCondition(@Param("title") String title,
                                    @Param("content") String content,
                                    @Param("nickname") String nickname,
                                    @Param("likeType") int likeType,
                                    Pageable pageable);
}
