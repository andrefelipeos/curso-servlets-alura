<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, alura.servlets.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas cadastradas</title>
</head>
<body>

<h3>Lista de empresas:</h3>
<ul>
	<c:forEach items="${ listaEmpresas }" var="empresa">
		<li>${ empresa.nome }</li>
	</c:forEach>
</ul>

</body>
</html>