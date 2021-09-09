package com.inc.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import com.inc.Bean.NewBatchBean;

public class ClosedBatches {

	public  ArrayList<NewBatchBean> closedBatches() throws ParseException{ 
	System.out.println("Inside closedBatches()");
	
	 ArrayList<NewBatchBean> displayAllBatches = new ArrayList<NewBatchBean>();
	 ArrayList<NewBatchBean> closedBatches = new ArrayList<NewBatchBean>();

     try (
     	Connection connection = MySQLConnection.connectToMySQL();

         
         PreparedStatement preparedStatement =connection.prepareStatement("select * from poultry.batches where changeToHatcherDate <CURRENT_TIMESTAMP() ");) {
        
         System.out.println(preparedStatement);
         ResultSet rs = preparedStatement.executeQuery();
     
         while (rs.next()) {

         	System.out.println("Inside resultset while()");
         	
         	String batchID = rs.getString("batchID");
         	String batchName = rs.getString("batchName");
         	String type_of_eggs = rs.getString("type_of_eggs");
         	String type_of_loader = rs.getString("type_of_loader");
         	String selected_row = rs.getString("selected_row");
         	String no_of_eggs = rs.getString("no_of_eggs");
         	String startDate = rs.getString("startDate");
         	String candlingDate = rs.getString("candlingDate");
         	String changeToHatcherDate = rs.getString("changeToHatcherDate");
         	String endDate = rs.getString("endDate");
         	int dbID = rs.getInt("dbID");
        	try {
         	NewBatchBean newBatchBean = new NewBatchBean();
         	
         	newBatchBean.setBatchID(batchID);
         	newBatchBean.setBatchName(batchName);
         	newBatchBean.setType_of_eggs(type_of_eggs);
         	newBatchBean.setType_of_loader(type_of_loader);
         	newBatchBean.setSelected_row(selected_row);
         	newBatchBean.setNo_of_eggs(no_of_eggs);
         	newBatchBean.setStartDate(startDate);
         	newBatchBean.setCandlingDate(candlingDate);
         	newBatchBean.setChangeToHatcherDate(changeToHatcherDate);
         	newBatchBean.setEndDate(endDate);
         	newBatchBean.setDbID(dbID);
            closedBatches.add(newBatchBean);
			} catch (Exception e) {
			  e.printStackTrace();
			}
    
         }
     	System.out.println("closedBatches.size() = "+closedBatches.size());

     } catch (SQLException e) {
     	e.printStackTrace();
     }
		// Step 4: try-with-resource statement will auto close the connection.
		try {
			return closedBatches;
		} catch (Exception e) {
			return null;
		}
 
		 
		   
	}
	private Boolean getDatecheck(String enddate) throws ParseException {
		
		
		  SimpleDateFormat formatter5=new SimpleDateFormat("ddMMMyyyy, HH-mm-ss, E");  
		 
		  Date endDate1=(Date) formatter5.parse(enddate); 
		  System.out.println("endDate1 = "+endDate1);    
		  
		  Date date = new Date();  
		  
		  String currentdate=formatter5.format(date);
		  Date currentdate1=(Date) formatter5.parse(currentdate); 
		  System.out.println("currentdate = "+currentdate1);    
		 
		  if(endDate1.before(currentdate1)) {
			 return true;
		  }
		  else
			 return false;
		 
	}
	
	public  ArrayList<NewBatchBean> runningBatches() throws ParseException{ 
		System.out.println("Inside closedBatches()");
		 ArrayList<NewBatchBean> runningBatches = new ArrayList<NewBatchBean>();

	     try (
	     	Connection connection = MySQLConnection.connectToMySQL();

	         
	         PreparedStatement preparedStatement =connection.prepareStatement("select * from poultry.batches where changeToHatcherDate >CURRENT_TIMESTAMP() ");) {
	        
	         System.out.println(preparedStatement);
	         ResultSet rs = preparedStatement.executeQuery();
	     
	         while (rs.next()) {

	         	System.out.println("Inside resultset while()");
	         	
	         	String batchID = rs.getString("batchID");
	         	String batchName = rs.getString("batchName");
	         	String type_of_eggs = rs.getString("type_of_eggs");
	         	String type_of_loader = rs.getString("type_of_loader");
	         	String selected_row = rs.getString("selected_row");
	         	String no_of_eggs = rs.getString("no_of_eggs");
	         	String startDate = rs.getString("startDate");
	         	String candlingDate = rs.getString("candlingDate");
	         	String changeToHatcherDate = rs.getString("changeToHatcherDate");
	         	String endDate = rs.getString("endDate");
	         	int dbID = rs.getInt("dbID");
	        	try {
	         	NewBatchBean newBatchBean = new NewBatchBean();
	         	
	         	newBatchBean.setBatchID(batchID);
	         	newBatchBean.setBatchName(batchName);
	         	newBatchBean.setType_of_eggs(type_of_eggs);
	         	newBatchBean.setType_of_loader(type_of_loader);
	         	newBatchBean.setSelected_row(selected_row);
	         	newBatchBean.setNo_of_eggs(no_of_eggs);
	         	newBatchBean.setStartDate(startDate);
	         	newBatchBean.setCandlingDate(candlingDate);
	         	newBatchBean.setChangeToHatcherDate(changeToHatcherDate);
	         	newBatchBean.setEndDate(endDate);
	         	newBatchBean.setDbID(dbID);
	         	runningBatches.add(newBatchBean);
				} catch (Exception e) {
				  e.printStackTrace();
				}
	    
	         }
	     	System.out.println("runningBatches.size() = "+runningBatches.size());

	     } catch (SQLException e) {
	     	e.printStackTrace();
	     }
			// Step 4: try-with-resource statement will auto close the connection.
			try {
				return runningBatches;
			} catch (Exception e) {
				return null;
			}
	 
			 
			   
		}
	
}
