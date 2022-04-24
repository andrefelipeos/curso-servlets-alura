<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,alura.servlets.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas cadastradas</title>
</head>
<body>

	<c:import url="login_logout.jsp" />
	
	<h3>Lista de empresas:</h3>
	<ul>
		<c:forEach items="${ listaEmpresas }" var="empresa">
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
				<a href="entrada?acao=EditaEmpresa&id=${ empresa.id }">editar</a>
				<a href="entrada?acao=RemoveEmpresa&id=${ empresa.id }">remover</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>