package com.ram.projects.expmgr.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ram.projects.expmgr.db.repo"})
@EntityScan(basePackages = {"com.ram.projects.expmgr.db.entity"})
@ComponentScan(basePackages = {"com.ram.projects.expmgr"})
public class AppStarter {
  public static void main(String[] args) {
//    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    SpringApplication.run(AppStarter.class, args);
  }
}
