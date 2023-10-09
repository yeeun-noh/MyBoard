package org.zerock.board.respository.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class FindUserRequestRepository {

    private final RedisTemplate redisTemplate; // JpaRepository 대신 RedisTemplate 사용

    public String findByUniqueLink(String uniqueLink){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String userId = operations.get(uniqueLink);
        if(userId == null)
            throw new NoSuchElementException("유저정보 찾기 요청 데이터 Repository find 실패, " + uniqueLink + " key가 존재하지 않음");
        return userId;
    }

    public void save(String uniqueLink, String userId, long timeToLive){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(uniqueLink, userId, timeToLive, TimeUnit.SECONDS);
    }

    public void remove(String uniqueLink){
        redisTemplate.delete(uniqueLink);
    }
}