package com.inc.DAO;

import java.sql.*;
import java.util.ArrayList;

public class InsertNewBatchToMySQL { 

	public static int insertNewBatchToMySQL(ArrayList<String> batchDetails) {

		System.out.println("Inside insertNewBatchToMySQL()");
		
		Connection con = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		String insertNewBatch = null; 
		int batchID = 0;

		try {
			//Creating Connection object to MySQL
			con = MySQLConnection.connectToMySQL();

			insertNewBatch  = "INSERT INTO poultry.batches (\r\n"
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
					+ "    )"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

			// create the mysql insert preparedstatement
			preparedStmt =
					con.prepareStatement(insertNewBatch,Statement.RETURN_GENERATED_KEYS);
			
			for(int i=0;i<batchDetails.size();i++)
				preparedStmt.setString(i+1,batchDetails.get(i));

			int rowAffected = preparedStmt.executeUpdate();
			if(rowAffected == 1)
			{
				// get batch id
				rs = preparedStmt.getGeneratedKeys();
				if(rs.next())
					batchID = rs.getInt(1);
				System.out.println("batchID = "+batchID);
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if(rs != null)  rs.close();
				if(con != null)  con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return batchID;
	}
}
