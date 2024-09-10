package com.example.coffeemachine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMachineController {

    private String scheduleTime = "";

    @GetMapping("/schedule")
    public String getSchedule() {
        return scheduleTime;
    }

    @PostMapping("/schedule")
    public void setSchedule(@RequestBody String time) {
        this.scheduleTime = time;
    }
}
