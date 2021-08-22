package com.inc.inputFromJSP;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class InputFromJSP {
	
	public ArrayList<String> inputFromNewBatchEntryJSP(HttpServletRequest request) {

		System.out.println("Inside inputFromNewBatchEntryJSP()");
		
		String pageName = request.getParameter("pageIdentifier");
		String timeStampofNewBatch = request.getParameter("timeStampofNewBatch");
		String type_of_eggs = request.getParameter("type_of_eggs");
		String type_of_loader = request.getParameter("type_of_loader");
		String selected_row = request.getParameter("selected_row");
		String no_of_eggs = request.getParameter("no_of_eggs");

	    ArrayList<String> inputFromNewBatchEntryJSP = new ArrayList<String>();
	    inputFromNewBatchEntryJSP.add(pageName);
	    inputFromNewBatchEntryJSP.add(timeStampofNewBatch);
	    inputFromNewBatchEntryJSP.add(type_of_eggs);
	    inputFromNewBatchEntryJSP.add(type_of_loader);
	    inputFromNewBatchEntryJSP.add(selected_row);
	    inputFromNewBatchEntryJSP.add(no_of_eggs);
	    
	    log(inputFromNewBatchEntryJSP);
	    
		return inputFromNewBatchEntryJSP;
	}

	  private static void log(ArrayList<String> inputFromNewBatchEntryJSP ){
	   for (int i=0;i<inputFromNewBatchEntryJSP.size();i++)
		  System.out.println( inputFromNewBatchEntryJSP.get(i));
	  }

}
