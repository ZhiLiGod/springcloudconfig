package com.springcloud.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "api")
public class Config {

  private String apiKey;
  private String apiValue;

}
