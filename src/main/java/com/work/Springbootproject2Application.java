package com.work;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
//@PropertySource("classpath:my.properties")
public class Springbootproject2Application {

    public static void main(String[] args) {
        //SpringApplication application=new SpringApplication(Springbootproject2Application.class);
        //application.setBannerMode(Banner.Mode.OFF);
        SpringApplication.run(Springbootproject2Application.class, args);
    }

}
