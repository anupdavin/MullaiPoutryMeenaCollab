<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Existing Batches</title>
</head>
<body>
<%-- <%ArrayList existingBatchDetails = --%>
<%--    request.getAttribute("existingBatchDetails"); %> --%>

<table>
<tr>
 for (int i = 0; i < ex.getExpenses().size(); i++) {
        if (i>0 && i%4==0) {
            out.println("</tr><tr>");
        }
        out.println("<td>" + ex.getExpenses().get(i) + "</td>");
    }

</table>
</body>
</html>