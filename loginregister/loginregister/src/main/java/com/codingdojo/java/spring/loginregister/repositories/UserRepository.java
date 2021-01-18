package com.codingdojo.java.spring.loginregister.repositories;

import java.util.List;

import com.codingdojo.java.spring.loginregister.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    List <User> findAll();
    User findByEmail (String email);
}
