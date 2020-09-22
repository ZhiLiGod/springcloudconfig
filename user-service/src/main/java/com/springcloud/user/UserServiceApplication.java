package com.springcloud.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RefreshScope // to refresh @Value
@Controller
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(value = Config.class)
public class UserServiceApplication {

  @Autowired
  private Config config;

  @Value("${api.apiKey}")
  private String apiKey;

  @Value("${myName}")
  private String myName;

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }

  @GetMapping
  public ResponseEntity<String> test() {

    return ResponseEntity.ok("user-service");
  }

  @GetMapping("/configs")
  public ResponseEntity<Config> testConfig() {

    log.info(apiKey);
    log.info(myName);

    return ResponseEntity.ok(config);
  }

}
