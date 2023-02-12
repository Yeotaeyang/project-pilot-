package com.mc.mvc.date.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DateController {
    @Autowired
    private DateService dateService;

    @PostMapping("/dates")
    public void saveDate(@RequestBody Date date) {
        dateService.saveDate(date);
    }
}