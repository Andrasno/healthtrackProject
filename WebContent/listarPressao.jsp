<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Peso</h1>
		<table class="table table-striped">
			<tr>
				<th>Pressão Registrada</th>
				<th>Data Registro</th>
			</tr>
			<c:forEach items="${pressao}" var="p">
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