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

<select name="selected_row" id="selected_row" >
  <option value="01">Row - 01</option>
  <option value="02">Row - 02</option>
  <option value="03">Row - 03</option>
  <option value="04">Row - 04</option>
  <option value="05">Row - 05</option>
  <option value="06">Row - 06</option>
  <option value="07">Row - 07</option>
  <option value="08">Row - 08</option>
  <option value="09">Row - 09</option>
  <option value="10">Row - 10</option>
  <option value="11">Row - 11</option>
  <option value="12">Row - 12</option>
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
  
  <input type="hidden" name ="pageIdentifier" value="newBatchEntryPage">
  
</form>

</body>
</html>