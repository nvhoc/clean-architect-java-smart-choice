package dev.hocnguyen.smartchoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"dev.hocnguyen.smartchoice.config"})
public class SmartChoiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmartChoiceApplication.class, args);
  }

}