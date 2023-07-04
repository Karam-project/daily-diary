package com.example.diary_process.repository.user;

import com.example.diary_process.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.uuid = :userUuId")
    Optional<User> findByUserUuId(@Param("userUuId") String userUuId);
}
