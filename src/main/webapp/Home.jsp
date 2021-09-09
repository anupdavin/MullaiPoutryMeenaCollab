<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
</head>
<body>

<form action="IncubatorServlet" method="POST">
 <center><h2>Home Page</h2></center> 
 
 <div style="text-align: center">

 
 <button name="pageredirect" value="newBatch">Enter New Batch</button>
 <button name="pageredirect" value="upComingBatches">View Upcoming Batches</button>
 <button name="pageredirect" value="closedBatches">View Closed Batches</button>
 <button name="pageredirect" value="allBatches">View All Batches</button>
 
 <input type="hidden" name ="pageIdentifier" value="Home.jsp">
</form>
</body>
</html>

