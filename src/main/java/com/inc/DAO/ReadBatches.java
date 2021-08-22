package com.inc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inc.Bean.NewBatchBean;

public class ReadBatches {
	
  
    private static final String readAllBatches = "select * from poultry.batches";
    		
/*
    "select (\r\n"
	+ "	batchID ,\r\n"
	+ "	batchName ,\r\n"
	+ "	type_of_eggs ,\r\n"
	+ "	type_of_loader ,\r\n"
	+ "	selected_row ,\r\n"
	+ "	no_of_eggs ,\r\n"
	+ "	startDate ,\r\n"
	+ "	candlingDate ,\r\n"
	+ "	changeToHatcherDate ,\r\n"
	+ "	endDate \r\n"
	+ "	from\r\n"
	+ " poultry.batches)";
*/
	private static String startDate;
    
    private static final String readBatchOnSelectedDate = 
    
    "select (\r\n"
	+ "	batchID ,\r\n"
	+ "	batchName ,\r\n"
	+ "	type_of_eggs ,\r\n"
	+ "	type_of_loader ,\r\n"
	+ "	selected_row ,\r\n"
	+ "	no_of_eggs ,\r\n"
	+ "	startDate ,\r\n"
	+ "	candlingDate ,\r\n"
	+ "	changeToHatcherDate ,\r\n"
	+ "	endDate \r\n"
	
	+ "	from\r\n"
	
	+ " poultry.batches\r\n"
	
	+ "	where\r\n"
	
	+ "	startDate\r\n"
	+ "	=\r\n"
	
	+ startDate 
	
	+ ")";
    
    
    
    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (
        	Connection connection = MySQLConnection.connectToMySQL();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement =
            		connection.prepareStatement(readAllBatches);) {
            //preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
           
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //list to store all bean objects
            ArrayList<NewBatchBean> displayAllBatches =
        			new ArrayList<NewBatchBean>() ;
            
            // Step 4: Process the ResultSet object.
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
            	
            	displayAllBatches.add(newBatchBean);
            	
            	System.out.println(batchID+batchName+
                		type_of_eggs+
                		type_of_loader+
                		selected_row+
                		no_of_eggs+
                		startDate+
                		candlingDate+
                		changeToHatcherDate+
                		endDate);
            	
            	System.out.println();
            
            	System.out.println(displayAllBatches.get(0).getStartDate());
                		
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
