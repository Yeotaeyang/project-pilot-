package com.mc.mvc.calendar.service;

import com.mc.mvc.calendar.dto.Calendar;
import com.mc.mvc.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;

    @Override
    public void insertNewTodo(Calendar calendar) {
        calendarRepository.insertNewTodo(calendar);

    }

    @Override
    public void deleteTodo(Calendar calendar) {
        calendarRepository.deleteTodo(calendar);

    }
}
