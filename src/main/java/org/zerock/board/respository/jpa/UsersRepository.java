package org.zerock.board.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);

    Long countById(String id);

    Long countByEmail(String email);

    Long countByNickname(String nickname);

    Long countByEmailAndIdNot(String email, String id);

    Long countByNicknameAndIdNot(String nickname, String id);
}
