<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="link_entrada_servlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Empresa</title>
</head>
<body>

	<c:import url="login_logout.jsp" />

	<form action="${ link_entrada_servlet }" method="post">
		Nome: <input type="text" name="nome" />
		Data de abertura: <input type="text" name="data" />
		<input type="hidden" name="acao" value="CadastraEmpresa">
		<input type="submit">
	</form>

</body>
</html>