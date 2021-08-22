<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function callServlet(action)
{
	
	alert(action);
 //document.getElementById("").value="confirm";	
 document.getElementById("adminForm").action="IncubatorServlet";
 document.getElementById("adminForm").method = "post";
 document.getElementById("adminForm").submit();
}

</script>

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

  <%
  
  ArrayList<String> batchDetails =(ArrayList)request.getAttribute("batchDetails");
  session.setAttribute("batchDetails", batchDetails);
	
  %> 


<meta charset="ISO-8859-1">



<title>Verify Batch Entry</title>
</head>
<body>
<form action="IncubatorServlet" method="POST">

<h2>Verify your Entry</h2>

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
  
  <tr>
 <%int i=0;
 for (i=0;i<batchDetails.size();i++) {%>
  <td><%=batchDetails.get(i) %></td>
  <%} %>
  </tr>
  
  </table>
  <br><br>
  <input type="submit" name="action" value="Edit">
  <br><br>
  <input type="submit" name="action" value="Confirm">
  
  <input type="hidden" name ="pageIdentifier" id="pageIdentifier" value="DisplayCurrentlyEnteredBatch">
</form>
</body>
</html>
