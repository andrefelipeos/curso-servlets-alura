<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, alura.servlets.gerenciador.servlet.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas cadastradas</title>
</head>
<body>
<h3>Lista de empresas:</h3>
<ul>
<%
	List<Empresa> empresas = (List<Empresa>) request.getAttribute("listaEmpresas");
	for (Empresa empresa : empresas) {
		out.println("<li>" + empresa.getNome() + "</li>");
	}
%>
</ul>

</body>
</html>