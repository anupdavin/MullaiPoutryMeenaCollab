package com.inc.NewBatchEntry;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class BatchNameAndIDGenerator {

	  public static final String batchIdGenerator(){
	    
		  System.out.println("Inside batchIdGenerator");		  
		  
		//generate random UUIDs
	    UUID idOne = UUID.randomUUID();
	    //log("Batch ID : "+batchName+"--" + idOne);
		
	    String batchID = idOne.toString();
	    System.out.println("batchID = "+batchID);
	    
	    return batchID;
	  }


	  public static final String batchNameGenerator(String type_of_eggs,String selected_row, String startDate){
	    
		  System.out.println("Inside batchNameGenerator");		  
		  
		//generate BatchName
		  if(type_of_eggs.equalsIgnoreCase("chicken_eggs"))
			  type_of_eggs="Ce";
		  else if(type_of_eggs.equalsIgnoreCase("guinea_eggs"))
			  type_of_eggs="Ge";
		  else if(type_of_eggs.equalsIgnoreCase("duck_eggs"))
			  type_of_eggs="De";
		  
//		  LocalDate currentdate = LocalDate.now(); 
//		  Month currentMonth = currentdate.getMonth();
//		  String month=currentMonth.toString();
//		  
		  
	    String batchName = selected_row+" "+type_of_eggs+" "+startDate;
	    System.out.println("batchName = "+batchName);
	    
	    return batchName;
	  }

	  
	  private static void log(Object object){
	    System.out.println( String.valueOf(object) );
	  }

}
