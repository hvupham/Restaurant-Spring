package com.tananh.respository;

import com.tananh.modal.Token;
import com.tananh.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByUser(User user);

    Token findByToken(String token);

    Token findByRefreshToken(String token);
}
