package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepositoy extends JpaRepository<Board, Integer> {

    Optional<Board> findBoardsById(int id);

    List<Board> findAll();

    List<Board> findAllByParentBoardIsNullOrderBySortOrder();

    @Query("SELECT b FROM Board b WHERE 0 = (SELECT COUNT(bb.id) FROM Board bb WHERE b.id = bb.parentBoard.id)")
    List<Board> findLeafBoards();
}
