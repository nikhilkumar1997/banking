<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

String name=(String)session.getAttribute("name");
String usn=(String)session.getAttribute("usn1");
int m1=(int)session.getAttribute("m1");
int m2=(int)session.getAttribute("m2");
int m3=(int)session.getAttribute("m3");
int avg=(int)session.getAttribute("avg");
PrintWriter pw=response.getWriter();
pw.println(name+" "+usn+" "+m1+" "+m2+" "+m3+" "+avg);




%>

</body>
</html>