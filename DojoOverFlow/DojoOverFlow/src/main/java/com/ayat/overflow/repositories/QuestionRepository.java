package com.ayat.overflow.repositories;

import com.ayat.overflow.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();
}
