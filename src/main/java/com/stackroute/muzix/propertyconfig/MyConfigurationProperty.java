package com.stackroute.muzix.propertyconfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties("my-values")
public class MyConfigurationProperty {
  private int id;
  private String name;
  private String comment;
}

