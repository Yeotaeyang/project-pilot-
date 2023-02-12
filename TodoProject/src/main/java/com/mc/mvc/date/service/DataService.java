package com.mc.mvc.date.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateService {
    @Autowired
    private DateRepository dateRepository;

    public void saveDate(java.util.Date date) {
        Date newDate = new Date();
        newDate.setDate(date);
        dateRepository.save(newDate);
    }
}