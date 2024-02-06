package com.task.api.controller;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CornJob {

   // @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    @Scheduled(cron = "0 * * * * ?") // Runs every minute
    public void myCronJob() {
        // Your task logic goes here
        System.out.println("Cron job executed!");
    }
}
