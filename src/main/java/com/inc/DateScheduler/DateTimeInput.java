package com.inc.DateScheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DateTimeInput {

	public ArrayList<String> dateTimeSchedule(HttpServletRequest request, String type_of_eggs) {

		System.out.println("Inside dateTimeInput");
		
		String dateTime = request.getParameter("timeStampofNewBatch");
		
		System.out.println("dateTime input from html = "+dateTime);
		
		String startDate = null;
		String candlingDate = null; 
		String changeToHatcherDate = null;
		String endDate = null;
		
		DateTimeFormatter dateTimeFormatter = 
				DateTimeFormatter.ofPattern("ddMMMyyyy, HH-mm-ss, E");  
		
		LocalDateTime startDate1= LocalDateTime.parse(dateTime);
		startDate = startDate1.format(dateTimeFormatter);
		System.out.println("startDate = "+startDate);

		LocalDateTime candlingDate1 = null;
		LocalDateTime changeToHatcherDate1 = null;
		LocalDateTime endDate1 = null;
		
		
		
		System.out.println("type of eggs = "+type_of_eggs);
		
		if(type_of_eggs.equalsIgnoreCase("chicken_eggs")||
				type_of_eggs.equalsIgnoreCase("guinea_eggs"))
		{
		candlingDate1= startDate1.plusDays(5);
		candlingDate = candlingDate1.format(dateTimeFormatter);
		System.out.println("candlingDate = "+candlingDate);
		
		changeToHatcherDate1= startDate1.plusDays(17);
		changeToHatcherDate = changeToHatcherDate1.format(dateTimeFormatter);
		System.out.println("changeToHatcherDate = "+changeToHatcherDate);
		
		endDate1= startDate1.plusDays(21);
		endDate = endDate1.format(dateTimeFormatter);
		System.out.println("endDate = "+endDate);
		}
		
		if(type_of_eggs.equals("duck_eggs"))
		{
		candlingDate1= startDate1.plusDays(7);
		candlingDate = candlingDate1.format(dateTimeFormatter);
		System.out.println("candlingDate = "+candlingDate);
		
		
		changeToHatcherDate1= startDate1.plusDays(26);
		changeToHatcherDate = changeToHatcherDate1.format(dateTimeFormatter);
		System.out.println("changeToHatcherDate = "+changeToHatcherDate);
		
		endDate1= startDate1.plusDays(28);
		endDate = endDate1.format(dateTimeFormatter);
		System.out.println("endDate = "+endDate);
		}
		
		
	    ArrayList<String> dateTimeSchedule = new ArrayList<String>();
	    
	    dateTimeSchedule.add(0, startDate);
	    dateTimeSchedule.add(1, candlingDate);
	    dateTimeSchedule.add(2, changeToHatcherDate);
	    dateTimeSchedule.add(3, endDate);
	    
	    //log(dateTimeSchedule);
	    
	    return dateTimeSchedule;

	}

}
