<%@page import="com.alg.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	Mensaje mensaje = new Mensaje(Integer.valueOf(id));
	MensajeDao mensajeDao = new MensajeDao();
	mensajeDao.eliminar(mensaje);
	request.getRequestDispatcher("index.jsp").forward(request,response);
	%>
</body>
</html>