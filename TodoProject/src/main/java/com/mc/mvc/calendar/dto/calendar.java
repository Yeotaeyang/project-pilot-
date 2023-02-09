package com.mc.mvc.calendar.dto;

import lombok.*;

import java.sql.Date;

@Data

public class calendar {
	private String userId;
	private Date pdate;
	private char done;
	
}
