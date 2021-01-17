package com.mvc.tvshows.repositories;

import com.mvc.tvshows.models.Show;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends CrudRepository<Show,Long> {
    @Query(value="SELECT * FROM shows ORDER BY avg_Rate ASC;", nativeQuery=true)
    List<Show> findAll();
}
