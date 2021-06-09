package com.example.autentia.gestor.repository;

import com.example.autentia.gestor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT COUNT(u) FROM UserEntity u WHERE u.email = :email AND u.pass = :pass")
    boolean findByEmailAndPass(String email, String pass);
}
