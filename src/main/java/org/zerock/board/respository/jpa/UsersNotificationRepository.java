package org.zerock.board.respository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.domain.UsersNotification;

import java.awt.print.Pageable;
import java.util.List;

public interface UsersNotificationRepository extends JpaRepository<UsersNotification, Integer> {

    Page<UsersNotification> findAllByUserId(String userId, Pageable pageable);

    List<UsersNotification> findAllByUserId(String userId);

    Long countByUserIdAndReadFalse(String userId);
}
