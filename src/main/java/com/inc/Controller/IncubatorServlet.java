package com.inc.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.poi.util.SystemOutLogger;

import com.inc.Bean.NewBatchBean;
import com.inc.DAO.ClosedBatches;
import com.inc.DAO.InsertNewBatchToMySQL;
import com.inc.DAO.ReadBatches;
import com.inc.DateScheduler.DateCompare;
import com.inc.EmailOperations.Emailer;
import com.inc.ExcelEntry.ExcelEntry;
import com.inc.NewBatchEntry.BatchEntry;
import com.inc.NewBatchEntry.StoreNewBatch;
import com.mysql.cj.Session;

/**
 * Servlet implementation class IncubatorServlet
 */
public class IncubatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncubatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("Inside doPost ");
		
		//Variables declaration part
		HttpSession session = request.getSession();
		
		ArrayList<String> batchDetails = null;
		ArrayList<NewBatchBean> displayAllBatches =new ArrayList<NewBatchBean>();
		ArrayList<NewBatchBean> closedBatchesList =new ArrayList<NewBatchBean>();
		BatchEntry batchEntry = new BatchEntry();
		ReadBatches readBatches = new ReadBatches();
		ClosedBatches closedBatches = new ClosedBatches();
		ArrayList<NewBatchBean> allBatches =new ArrayList<NewBatchBean>();
		ArrayList<NewBatchBean> runningBatches =new ArrayList<NewBatchBean>();
		
		String page = null;		
		String action = null;
		String pageredirect = null; 
	
		
		//data collection using request object--request.getParameter()
		page = request.getParameter("pageIdentifier");
		System.out.println("page = "+page);
		
		action = request.getParameter("action");
		System.out.println("action = "+action);
		
		pageredirect = request.getParameter("pageredirect");
		System.out.println("pageredirect = "+pageredirect);
		
		
		//Home page and redirection part
		if (page.equalsIgnoreCase("Home.jsp")){
			System.out.println("Inside Home page and redirection part");

			if(pageredirect.equalsIgnoreCase("newBatch")) {
				System.out.println("Inside newBatch of home part");
				
				allBatches = readBatches.allBatches();
				
				/*
				try {
					runningBatches = closedBatches.runningBatches();
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
         */
         
				ArrayList<String> availableRows = new ArrayList<String>();
				availableRows.add("R1");
				availableRows.add("R2");
				availableRows.add("R3");
				availableRows.add("R4");
				availableRows.add("R5");
				availableRows.add("R6");
				availableRows.add("R7");
				availableRows.add("R8");
				availableRows.add("R9");
				availableRows.add("R10");
				availableRows.add("R11");
				availableRows.add("R12");
				
				NewBatchBean n1 = new NewBatchBean();
				/*
				if(runningBatches.size()>0) {
				for(int j=0;j<=runningBatches.size();j++) {
					n1=new NewBatchBean();
					n1=runningBatches.get(j);
				*/
				if(allBatches.size()>0) {
					for(int j=0;j<allBatches.size();j++) {
						n1=new NewBatchBean();
						n1=allBatches.get(j);
						
					Boolean dateFlag = null;
					try {
						dateFlag = DateCompare.getDatecheck(n1.getChangeToHatcherDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(dateFlag);
					if(dateFlag==false){
						availableRows.remove(n1.getSelected_row());
					}
				
					/*
					if(!n1.getSelected_row().equals("") &&
							n1.getSelected_row()!=null &&
							n1.getSelected_row().contains("R")) {
						availableRows.remove(n1.getSelected_row());
					}
					*/
				}
				}
				
				System.out.println();
				System.out.println("Checking available rows");
				//verify available rows in console
				for(int i=0;i<availableRows.size();i++) {
					System.out.println(availableRows.get(i));
				}
				
				session.setAttribute("availableRows", availableRows);
				
				request.getRequestDispatcher("NewBatchEntry.jsp").
				forward(request, response);
			
			}
			if(pageredirect.equalsIgnoreCase("upComingBatches"))
				
				request.getRequestDispatcher("upComingBatches.jsp").
				forward(request, response);

			if(pageredirect.equalsIgnoreCase("closedBatches")) {

				System.out.println("Inside pageredirect.equalsIgnoreCase(closedBatches");
			
				try {
					closedBatchesList = closedBatches.closedBatches();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("closedBatches size = "+closedBatchesList.size());
					
				session.setAttribute("closedBatchesList", closedBatchesList);
				request.getRequestDispatcher("closedBatches.jsp").
				forward(request, response);
			}
			
			if(pageredirect.equalsIgnoreCase("allBatches")) {
				
				displayAllBatches = readBatches.allBatches();
            	System.out.println("========================="+displayAllBatches.size());
				session.setAttribute("displayAllBatches", displayAllBatches);
				request.getRequestDispatcher("allBatches.jsp").
				forward(request, response);
			}
		}
		
		if (page.equalsIgnoreCase("NewBatchEntry.jsp")){
			System.out.println("Inside newBatchEntryPage if part");
			
			batchDetails=batchEntry.newBatchEntry(request);
			
			request.setAttribute("batchDetails", batchDetails);
			
			request.getRequestDispatcher("DisplayCurrentlyEnteredBatch.jsp").
			forward(request, response);
			
			System.out.println("if part of newBatchEntryPage ended");
			
		}
		else if(action!=null && action.equalsIgnoreCase("Confirm") 
				&& !page.equalsIgnoreCase("NewBatchEntry.jsp") ){
			
			System.out.println("Inside Else if confirm");
			System.out.println("action = "+action);
			
			batchDetails=(ArrayList<String>)session.getAttribute("batchDetails");
			
			System.out.println("batchDetails.size="+batchDetails.size());
			
			for(int i=0;i<batchDetails.size();i++)
				System.out.println("batchDetails.index"+i+batchDetails.get(i));
			
			StoreNewBatch.storeNewBatch(batchDetails);
			System.out.println("Stored data");
			
			request.getRequestDispatcher("Home.jsp").
			forward(request, response);
			
			System.out.println("End of Else if confirm");
		}
		else if(action!=null && action.equalsIgnoreCase("Edit")  && !page.equalsIgnoreCase("newBatchEntryPage") ){
			System.out.println("Inside Else if edit");
			System.out.println("action = "+action);
			
			request.getRequestDispatcher("NewBatchEntry.jsp").
			forward(request, response);
		}
		
		
/*		
		//Maintenance part
		
		
		//Batch completion entry
		

		//Vaccination schedule
		 
		
		//JSP reply part
		
*/	
		
		System.out.println("End of servlet");
		System.out.println();
	}

	private void log() {
		// TODO Auto-generated method stub
		
	}

	

}
