package org.zuel.course.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("org.zuel.course.frame.mapper")
public class CourseFrameApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CourseFrameApplication.class, args);
    }

    protected SpringApplicationBuilder config(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(CourseFrameApplication.class);
    }

}

