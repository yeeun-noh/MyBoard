package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.UsersGrade;
import org.zerock.board.domain.UsersGradeLevel;

import java.util.Optional;

public interface UsersGradeRepository extends JpaRepository<UsersGrade, Integer> {

    Optional<UsersGrade> findByGrade(UsersGradeLevel grade);

    Optional<UsersGrade> findByCaption(String caption);
}
