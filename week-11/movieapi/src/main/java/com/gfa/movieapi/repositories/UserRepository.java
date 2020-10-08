package com.gfa.movieapi.repositories;


import com.gfa.movieapi.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

Optional<User> findByUsername(String username);
}
