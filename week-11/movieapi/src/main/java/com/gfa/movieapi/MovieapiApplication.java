package com.gfa.movieapi;

import com.gfa.movieapi.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MovieapiApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieapiApplication.class, args);
  }

}
