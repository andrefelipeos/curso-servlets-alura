<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresa cadastrada com sucesso</title>
</head>
<body>

<c:if test="${ not empty nomeEmpresa }">
	<h3>Empresa ${ nomeEmpresa } cadastrada com sucesso.</h3>
</c:if>

<c:if test="${ empty nomeEmpresa }">
	<h3>Nenhuma empresa foi passada para cadastro.</h3>
</c:if>

</body>
</html>