<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
contentType="text/html; 
charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>

<style>

</style>
<%
ArrayList<String> availableRows = (ArrayList<String>)session.getAttribute("availableRows");
int i=0,j=1;String value =null;
for(i=0;i<availableRows.size();i++){
	out.println(availableRows.get(i));
}


%> 


<meta charset="ISO-8859-1">

<title>New Batch Entry</title>
</head>
<body>

<form action="IncubatorServlet" method="POST">

<label for="type_of_eggs">Choose Type of Eggs:</label>

<select name="type_of_eggs" id="type_of_eggs" >
  <option value="chicken_eggs">chicken Eggs</option>
  <option value="duck_eggs">Duck Eggs</option>
  <option value="guinea_eggs">Guinea Eggs</option>
</select>
<br><br>
<label for="type_of_loader">Choose Type of Loader:</label>

<select name="type_of_loader" id="type_of_loader" >
  <option value="Roller">Roller</option>
  <option value="Tilter">Tilter</option>
</select>
<br><br>
<label for="selected_row">Choose a row:</label>

<select name="selected_row" id="selected_row"  multiple>

<%
for( i=0;i<availableRows.size();i++){
%>

	  <option value="<%=availableRows.get(i)%>"><%=availableRows.get(i)%></option>

<%
}
%>
</select>
<br><br>

<label for="no_of_eggs">Choose Number of Eggs:</label>

<select name="no_of_eggs" id="no_of_eggs" >
  <option value="01">01</option>
  <option value="02">02</option>
  <option value="03">03</option>
  <option value="04">04</option>
  <option value="05">05</option>
  <option value="06">06</option>
  <option value="07">07</option>
  <option value="08">08</option>
  <option value="09">09</option>
  <option value="10">10</option>
</select>
<br><br>
 <label for="timeStampofNewBatch">Enter Date and Time</label>
  <input type="datetime-local" id="timeStampofNewBatch" 
  name="timeStampofNewBatch">
  
<br>
  <input type="submit" value="Submit"  >
  
  <input type="hidden" name ="pageIdentifier" value="NewBatchEntry.jsp">
  
</form>

</body>
</html>