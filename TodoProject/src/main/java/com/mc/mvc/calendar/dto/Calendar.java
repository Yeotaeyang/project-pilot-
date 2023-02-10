package com.mc.mvc.calendar.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data

public class Calendar {

    private String userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime regDate;

    private String todo;

    public String getRegDateAsDate() {
        return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // timestamp

}
