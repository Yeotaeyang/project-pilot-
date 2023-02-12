package com.mc.mvc.calendar.service;


import com.mc.mvc.calendar.dto.Calendar;

public interface CalendarService {

    void insertNewTodo(Calendar calendar);

    void deleteTodo(Calendar calendar);
}
