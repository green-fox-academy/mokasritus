package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Trick;
import com.greenfox.foxclub.repository.TrickRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class TrickService {
  private TrickRepository trickRepository;

  @Autowired
  public TrickService(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  public List<Trick> getAllTricks() {
    return trickRepository.getTrickList();
  }
}
