package com.mc.mvc.calendar.repository;

import com.mc.mvc.calendar.dto.Calendar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;


@Repository
public interface CalendarRepository {


    @Insert("insert into todo(user_Id,regDate,todo) values(#{userId},#{regDate},#{todo})")
    void insertNewTodo(Calendar calendar);


    @Delete("delete from todo where user_id=#{userId} and=#{regDate} and todo=#{todo}")
    void deleteTodo(Calendar calendar);




}
