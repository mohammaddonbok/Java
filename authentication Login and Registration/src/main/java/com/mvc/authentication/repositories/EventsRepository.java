package com.mvc.authentication.repositories;

import com.mvc.authentication.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends CrudRepository<Event,Long> {
    List<Event> findAll();
}
