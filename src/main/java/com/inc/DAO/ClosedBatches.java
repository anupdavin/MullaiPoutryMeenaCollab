package com.inc.DAO;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.inc.Bean.NewBatchBean;

public class ClosedBatches {

	public static ArrayList<NewBatchBean> closedBatches(){ 
	System.out.println("Inside closedBatches()");
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyy");  

		   LocalDateTime now = LocalDateTime.now();  
		   
		   String date = dtf.format(now);
		   System.out.println("date =  "+date);
		   LocalDateTime currentDate = LocalDateTime.parse(date, dtf);
		   
		   ArrayList<NewBatchBean> displayAllBatches = new ArrayList<NewBatchBean>();
		   ArrayList<NewBatchBean> closedBatches = new ArrayList<NewBatchBean>();
		   ReadBatches readBatches = new ReadBatches();
		   
		   displayAllBatches = readBatches.allBatches();
		   
		   for(int i=0;i<displayAllBatches.size();i++) {
			   String endDate = displayAllBatches.get(i).getEndDate();

			   endDate = dtf.format(now);
			   LocalDateTime endDateFromSQL = LocalDateTime.parse(endDate, dtf);
			  
			   if (currentDate.isBefore(endDateFromSQL)) {
			          System.out.println("Date1 is before Date2");
			          
			          NewBatchBean newBatchBean = new NewBatchBean();
		            	
			          newBatchBean = displayAllBatches.get(i);
			          
			          try {
			        	  closedBatches.add(newBatchBean);
						  
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			      }   
		   }
		return closedBatches;
		   

	      
	      
		
		
		//return null;
	}
}
