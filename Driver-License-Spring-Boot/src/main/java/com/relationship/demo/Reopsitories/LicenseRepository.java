package com.relationship.demo.Reopsitories;

import com.relationship.demo.models.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository  extends CrudRepository<License,Long> {
    List<License> findAll();


    public License findTopByOrderByNumberDesc();



}
