package com.greenfoxacademy.frontend.repository;

import com.greenfoxacademy.frontend.models.Log;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
  List<Log> findAll();
}
