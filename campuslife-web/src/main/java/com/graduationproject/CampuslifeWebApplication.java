package com.graduationproject;

import com.graduationproject.campuslifeservice.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@SpringBootApplication
public class CampuslifeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampuslifeWebApplication.class, args);
    }

}
