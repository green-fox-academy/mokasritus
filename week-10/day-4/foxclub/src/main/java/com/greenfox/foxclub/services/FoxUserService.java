package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.FoxUser;
import com.greenfox.foxclub.repository.FoxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxUserService {
  private FoxUserRepository foxUserRepository;

  @Autowired
  public FoxUserService(FoxUserRepository foxUserRepository) {
    this.foxUserRepository = foxUserRepository;
  }

  public void saveNewFoxUser(FoxUser foxUser) {
    if(!foxUserRepository.existsFoxUserByUsernameEqualsAndPasswordEquals(foxUser.getUsername(), foxUser.getPassword())){
      foxUserRepository.save(new FoxUser(foxUser.getUsername(), foxUser.getPassword(), new Fox()));
    }
  }

  public boolean checkPasswords(String password, String passwordAgain) {
    return password.equals(passwordAgain);
  }

  public FoxUser findByPasswordAndByUsername(String password, String username) {
    return foxUserRepository.findFoxUsersByUsernameAndPassword(password, username);
  }

  public FoxUser findById(long id) {
    return foxUserRepository.findById(id);
  }

  public void setFoxName(long id, String name) {
    findById(id).getFox().setName(name);
  }

  public FoxUser findByUsername(String username) {
    return foxUserRepository.findByUsername(username);
  }

  public void save(FoxUser foxuser) {
    foxUserRepository.save(foxuser);
  }
}
