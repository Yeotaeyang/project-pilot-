package com.mc.mvc.todo.dto;

import lombok.Data;

@Data
public class Todo {
    /*
     * SELECT `todo`.`USER_ID`, `todo`.`TODO`, `todo`.`DONE` FROM `todo`.`todo`;
     */

    private String userId;
    private String todo;
    private char done;


}
