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
	<h1>Cadastrar Peso</h1>
	<form action="pressao" method="post">
		<div class="form-group">
			<label for="id-pressao">Peso</label>
			<input type="text" name="valor" id="id-pressao" class="form-control">
		</div>
				<div class="form-group">
			<label for="id-inclusao">Data de Inclusão</label>
			<input type="text" name="datainclusao" id="id-inclusao" class="form-control">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form>
</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>