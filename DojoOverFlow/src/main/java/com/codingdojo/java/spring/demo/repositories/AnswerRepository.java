package com.codingdojo.java.spring.demo.repositories;

import java.util.List;

import com.codingdojo.java.spring.demo.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends CrudRepository <Answer, Long>{
    List<Answer> findAll();
}