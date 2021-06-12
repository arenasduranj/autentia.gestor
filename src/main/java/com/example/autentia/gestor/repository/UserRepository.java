package com.example.autentia.gestor.repository;

import com.example.autentia.gestor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT CASE WHEN COUNT(u.id) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.email = :email AND u.pass = :pass")
    boolean findByEmailAndPass(@Param("email") String email, @Param("pass") String pass);
}
