package com.inc.Bean;

import java.io.Serializable;

public class NewBatchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String batchID;
	private String batchName;
	private String type_of_eggs;
	private String type_of_loader;
	private String selected_row;
	private String no_of_eggs;
	private String startDate;
	private String candlingDate;
	private String changeToHatcherDate;
	private String endDate;

	private int  dbID;

	public String getType_of_eggs() {
		return type_of_eggs;
	}
	public void setType_of_eggs(String type_of_eggs) {
		this.type_of_eggs = type_of_eggs;
	}
	public String getType_of_loader() {
		return type_of_loader;
	}
	public void setType_of_loader(String type_of_loader) {
		this.type_of_loader = type_of_loader;
	}
	public String getSelected_row() {
		return selected_row;
	}
	public void setSelected_row(String selected_row) {
		this.selected_row = selected_row;
	}
	public String getNo_of_eggs() {
		return no_of_eggs;
	}
	public void setNo_of_eggs(String no_of_eggs) {
		this.no_of_eggs = no_of_eggs;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCandlingDate() {
		return candlingDate;
	}
	public void setCandlingDate(String candlingDate) {
		this.candlingDate = candlingDate;
	}
	public String getChangeToHatcherDate() {
		return changeToHatcherDate;
	}
	public void setChangeToHatcherDate(String changeToHatcherDate) {
		this.changeToHatcherDate = changeToHatcherDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBatchID() {
		return batchID;
	}
	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getDbID() {
		return dbID;
	}
	public void setDbID(int dbID) {
		this.dbID = dbID;
	}
	
	
}
