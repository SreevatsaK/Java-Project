package com.example.elearning.repository;

import com.example.elearning.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    // for login
    User findByEmailIDAndPassword(String emailID, String password);
    @Query(value = "SELECT user_id FROM users WHERE user_id LIKE :prefix% ORDER BY user_id DESC LIMIT 1", 
    	       nativeQuery = true)
    	String findLastUserId(@Param("prefix") String prefix);
    @Query(value = "SELECT user_id FROM users ORDER BY user_id DESC LIMIT 1", nativeQuery = true)
    String findLastUserId();



}
