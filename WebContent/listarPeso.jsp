<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Peso</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Peso</h1>
		<table class="table table-striped">
			<tr>
				<th>Peso Registrado</th>
				<th>Data Registro</th>
			</tr>
			<c:forEach items="${peso}" var="p">
				<tr>
					<td>${p.valor}</td>
							
					<td>
						<fmt:formatDate value="${p.dataRegistro.time }" pattern="dd/MM/yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>