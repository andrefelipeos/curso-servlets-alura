<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="link_entrada_servlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Empresa</title>
</head>
<body>
	
	<c:import url="login_logout.jsp" />

	<form action="${ link_entrada_servlet }" method="post">
		Nome: <input type="text" name="nome" value="${ empresa.nome }" />
		Data de abertura: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />" />
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="hidden" name="id" value="${ empresa.id }">
		<input type="submit">
	</form>

</body>
</html>