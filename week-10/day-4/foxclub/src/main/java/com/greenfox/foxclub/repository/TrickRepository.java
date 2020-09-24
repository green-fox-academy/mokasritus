package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.Trick;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrickRepository extends CrudRepository<Trick, Long> {


  List<Trick> findAll();

  Trick findTrickByName(String trickToLearn);

}