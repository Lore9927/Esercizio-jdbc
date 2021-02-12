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
		<a href="/esercizio-jdbc/pages/country.jsp">FindCountry</a>
		<h3>Trova città</h3>
		<form action="/esercizio-jdbc/get-city">
			<label>Nome Città</label> <br>
			<input type="text" name="nomeCitta"> <br>
			<button type="submit">Cerca</button>
		</form>
		<p>${ris}</p>
	</body>
</html>