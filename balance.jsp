<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
<title>balance</title>
</head>

<body>
<%
session=request.getSession();
PrintWriter pw=response.getWriter();
pw.println("your balance is: "+(session.getAttribute("balance")));


%>

</body>
</html>