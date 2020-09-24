package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Trick;
import com.greenfox.foxclub.repository.TrickRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrickService {
  private TrickRepository trickRepository;

  @Autowired
  public TrickService(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  public List<Trick> getAllTricks() {
    if(trickRepository.findAll().isEmpty()){
      fillTrickRepository();
    }
      return trickRepository.findAll();
  }

  public Trick searchTrickWithName(String trickToLearn) {
    return trickRepository.findTrickByName(trickToLearn);
  }

  public void fillTrickRepository() {
    trickRepository.save(new Trick("Write HTML"));
    trickRepository.save(new Trick("Eat cake"));
    trickRepository.save(new Trick("Watch TV"));
    trickRepository.save(new Trick("Play tetris"));
  }

  public void save(Trick trickToLearn) {
  }
}

