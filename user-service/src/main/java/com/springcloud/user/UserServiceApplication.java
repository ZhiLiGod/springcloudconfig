package com.springcloud.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class UserServiceApplication {

  @Value("${user.name}")
  private String userName;

  @Value("${api.key}")
  private String apiKey;

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }

  @GetMapping
  public ResponseEntity<String> test() {

    return ResponseEntity.ok(String.format("%s, %s", userName, apiKey));
  }

}
