package com.springcloud.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication
public class UserServiceApplication {

  @Value("${api.key}")
  private String apiKey;

  @Value("${common.name}")
  private String commonName;

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }

  @GetMapping
  public ResponseEntity<String> test() {

    return ResponseEntity.ok("user-service");
  }

  @GetMapping("/configs")
  public ResponseEntity<String> config() {

    return ResponseEntity.ok(apiKey + " " + commonName);
  }

}
