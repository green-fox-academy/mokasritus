package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.Fox;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //tárol és hozzáférést biztosít
public interface FoxRepository extends CrudRepository<Fox, Long> {

  List<Fox> findAll();

  boolean existsFoxByName(String name);

  Fox findFoxByName(String name);

  Fox findFoxByNameIsNull();
}
