package com.mvc.authentication.repositories;

import com.mvc.authentication.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepositry extends CrudRepository<Message,Long> {
    List<Message> findAll();
}
