<%@page import="java.util.ArrayList"%>
<%@page import="com.inc.Bean.NewBatchBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
table, th, td {
  border: 1px solid black;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 30%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<meta charset="ISO-8859-1">
<title>All Batches</title>
</head>
<body>

  <%
  ArrayList<NewBatchBean> displayAllBatches =(ArrayList)session.getAttribute("displayAllBatches");
  int i=0;NewBatchBean newBatchBean = new NewBatchBean();
  %> 



<table>
  <tr>
    <th>Batch ID</th>  
    <th>Batch Name</th>
    <th>Type of Eggs</th>
    <th>Type of Loader</th>
    <th>Selected Row</th>
    <th>No of Eggs</th>
    <th>Start Date</th>
    <th>Candling Date</th>
    <th>Change To Hatcher Date</th>
    <th>End Date</th>
  </tr> 
  
  <%if(displayAllBatches.size()>0){
 
 for ( i=0;i<displayAllBatches.size();i++) {
	 newBatchBean=displayAllBatches.get(i);
     %>
  <tr>
  <td><%=newBatchBean.getBatchID()%></td>
  <td><%=newBatchBean.getBatchName()%></td>

 <td><%=newBatchBean.getType_of_eggs()%></td>
 <td><%=newBatchBean.getType_of_loader()%></td>
	
  <td><%=newBatchBean.getSelected_row()%></td>
  <td><%=newBatchBean.getNo_of_eggs()%></td>
	
  <td><%=newBatchBean.getStartDate()%></td>
  <td><%=newBatchBean.getCandlingDate()%></td>
  
  <td><%=newBatchBean.getChangeToHatcherDate()%></td>
  <td><%=newBatchBean.getEndDate()%></td>

  </tr>
  <%} }%>
  </table>
  <br><br>
  <input type="submit" name="Back" value="Back">
  
  <input type="hidden" name ="pageIdentifier" 
  id="pageIdentifier" value="allBatches">



</body>
</html>