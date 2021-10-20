<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
	System.out.println(nomeEmpresa + " (no JSP)");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresa cadastrada com sucesso</title>
</head>
<body>

<h3>Empresa <%= nomeEmpresa %> cadastrada com sucesso.</h3>

</body>
</html>