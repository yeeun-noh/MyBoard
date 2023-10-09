package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.BoardType;
import org.zerock.board.domain.UsersGrade;

import java.util.Optional;

public interface BoardTypeRepository extends JpaRepository<BoardType, Integer> {

    Optional<UsersGrade> findByType(int type);

    Optional<UsersGrade> findByName(String name);
}
