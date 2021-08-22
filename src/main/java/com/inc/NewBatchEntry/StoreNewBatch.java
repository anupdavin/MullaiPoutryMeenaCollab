package com.inc.NewBatchEntry;

import java.util.ArrayList;

import com.inc.DAO.InsertNewBatchToMySQL;
import com.inc.EmailOperations.Emailer;
import com.inc.ExcelEntry.ExcelEntry;

public class StoreNewBatch {

	public static void storeNewBatch(ArrayList<String> batchDetails) {
		
				//Excel entry part
				ExcelEntry.enterNewBatchDetailsToExcel(batchDetails);
				System.out.println("Excel entry part Completed");

				//Email alert for new Batch
				Emailer.newBatchEntryNotification(batchDetails.get(0));//batchID
				System.out.println("Email notification sent");
				
				//Store into DB	
				InsertNewBatchToMySQL.insertNewBatchToMySQL(batchDetails);
				System.out.println("DB entry part Completed");
				
				
				
	}
	
}
