package com.travel.proj.app.login.repository;

import com.travel.proj.app.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email,String password);
}
