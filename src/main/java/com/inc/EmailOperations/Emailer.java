package com.inc.EmailOperations;


public class Emailer {

		 public static void newBatchEntryNotification(String batchID) {    
		     //from,password,to,subject,message  
			 EmailAlert.send("incubatorcheck@gmail.com",
					 "checkincubator",
					 "incubatorcheck@gmail.com",
					 "hello anup new batch entered now",
					 batchID);  
		     //change from, password and to  
		 }    

	
}
