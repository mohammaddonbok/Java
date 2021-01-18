package com.codingdojo.java.spring.demo.repositories;

import java.util.List;

import com.codingdojo.java.spring.demo.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends CrudRepository <Question, Long>{
    List<Question> findAll();
}