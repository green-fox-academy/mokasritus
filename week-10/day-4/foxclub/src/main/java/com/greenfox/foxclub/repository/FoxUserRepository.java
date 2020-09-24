package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.models.FoxUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxUserRepository extends CrudRepository<FoxUser, Long> {
  List<FoxUser> findAll();

  boolean existsFoxUserByUsernameEqualsAndPasswordEquals(String userName, String Password);

  FoxUser findFoxUsersByUsernameAndPassword(String password, String username);

  FoxUser findById(long id);

  FoxUser findByUsername(String username);
}
