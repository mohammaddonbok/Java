package com.codingdojo.java.spring.demo.repositories;

import java.util.List;

import com.codingdojo.java.spring.demo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends CrudRepository <Tag, Long>{
    List<Tag> findAll();
    Tag findBySubject(String subject);
}