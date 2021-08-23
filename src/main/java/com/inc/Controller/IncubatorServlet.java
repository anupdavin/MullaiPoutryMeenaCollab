package com.inc.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.inc.Bean.NewBatchBean;
import com.inc.DAO.InsertNewBatchToMySQL;
import com.inc.DAO.ReadBatches;
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
		
		HttpSession session = request.getSession();
		   
		String page = null;
		ArrayList<String> batchDetails = null;
		BatchEntry batchEntry = new BatchEntry();
		
		page = request.getParameter("pageIdentifier");
		System.out.println("page = "+page);
		
		String action = request.getParameter("action");
		System.out.println("action = "+action);
		
		String pageredirect = request.getParameter("pageredirect");
		System.out.println("pageredirect = "+pageredirect);
		
		if (page.equalsIgnoreCase("Home")){
			System.out.println("Inside page name part");
			
			if(pageredirect.equalsIgnoreCase("newBatch"))
			request.getRequestDispatcher("NewBatchEntry.jsp").
			forward(request, response);
			
			if(pageredirect.equalsIgnoreCase("upComingBatches"))
				request.getRequestDispatcher("upComingBatches.jsp").
				forward(request, response);

			if(pageredirect.equalsIgnoreCase("closedBatches"))
				request.getRequestDispatcher("closedBatches.jsp").
				forward(request, response);
			
			if(pageredirect.equalsIgnoreCase("allBatches")) {
				ArrayList<NewBatchBean> displayAllBatches =
		        			new ArrayList<NewBatchBean>();
				ReadBatches readBatches = new ReadBatches();
				displayAllBatches = readBatches.allBatches();
            	System.out.println("========================="+displayAllBatches.size());
				session.setAttribute("displayAllBatches", displayAllBatches);
				request.getRequestDispatcher("allBatches.jsp").
				forward(request, response);
			}
		}
		
		if (page.equalsIgnoreCase("newBatchEntryPage")){
			System.out.println("Inside newBatchEntryPage if part");
			batchDetails=batchEntry.newBatchEntry(request);
			request.setAttribute("batchDetails", batchDetails);
			
			request.getRequestDispatcher("DisplayCurrentlyEnteredBatch.jsp").
			forward(request, response);
			System.out.println("if part of newBatchEntryPage ended");
			/*
			for(int i=0;i<batchDetails.size();i++)
			System.out.println("batchDetails.index"+i+batchDetails.get(i));
		*/
		}
		else if(action!=null && action.equalsIgnoreCase("Confirm") && !page.equalsIgnoreCase("newBatchEntryPage") ){
			System.out.println("Inside Else if confirm");
			System.out.println("action = "+action);
			batchDetails=(ArrayList<String>)session.getAttribute("batchDetails");
			//batchDetails=(ArrayList<String>)request.getAttribute("batchDetails");
			System.out.println("batchDetails.size="+batchDetails.size());
			
			for(int i=0;i<batchDetails.size();i++)
				System.out.println("batchDetails.index"+i+batchDetails.get(i));

			StoreNewBatch.storeNewBatch(batchDetails);
			System.out.println("Stored data");
		}
		else if(action!=null && action.equalsIgnoreCase("Edit")  && !page.equalsIgnoreCase("newBatchEntryPage") ){
			System.out.println("Inside Else if edit");
			System.out.println("action = "+action);
			request.getRequestDispatcher("NewBatchEntry.jsp").
			forward(request, response);
		}
		
		
/*		
		
		//Batch entry part
		BatchEntry batchEntry = new BatchEntry();
		ArrayList<String> batchDetails = 
				batchEntry.newBatchEntry(request,dateTimeSchedule);
		System.out.println("batch entry part completed");

		//Excel entry part
		ExcelEntry.enterNewBatchDetailsToExcel(batchDetails);
		System.out.println("Excel entry part Completed");
		
		//Maintenance part
		
		
		//Batch completion entry
		
		
		
		//JSP reply part
		
*/	
		
		System.out.println("End of servlet");
		
	}

	

}
