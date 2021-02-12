<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esercizio jdbc</title>
	</head>
	<body>
		<p>Username: ${nomeUser}</p>
		<a href="/esercizio-jdbc/pages/city.jsp">FindCity</a>
		<h3>Trova nazione</h3>
		<form action="/esercizio-jdbc/get-country">
			<label>Nome nazione</label> <br>
			<input type="text" name="nomeNazione"> <br>
			<label>Continente</label> <br>
			<input type="text" name="continente"> <br> 
			<button type="submit">Cerca</button>
		</form>
		<p>${ris}</p>
		
	</body>
</html>