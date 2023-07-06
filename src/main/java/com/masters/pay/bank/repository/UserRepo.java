package com.masters.pay.bank.repository;

import com.masters.pay.bank.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u from User u WHERE u.emailId= ?1")
    List<User> findByEmailId(String emailId);
}
