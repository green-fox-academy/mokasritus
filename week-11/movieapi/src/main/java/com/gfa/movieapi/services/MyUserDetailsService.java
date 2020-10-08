package com.gfa.movieapi.services;

import com.gfa.movieapi.models.MyUserDetails;
import com.gfa.movieapi.models.User;
import com.gfa.movieapi.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);

    user.orElseThrow(()->new UsernameNotFoundException("Not found: " + username));

    return user.map(MyUserDetails::new).get();
  }
}
