<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.person.Person"%>
<%@page import="br.com.livrariaasafe.model.book.Book"%>
<%@page import="java.util.ArrayList"%>
<%
Person person = (Person) request.getAttribute("person");
ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastre um Livro</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="img/favicon-livro.png"
	type="image/x-icon" />
<link rel="stylesheet" href="css/books.css">
<link rel="stylesheet" href="css/add-book.css">
<link rel="stylesheet" href="css/add-book.css">
<link rel="stylesheet" href="css/edit-person.css">

</head>
<body>
	<%@ include file="../includes/header.jsp"%>


	<form action="UpdatePersonController" method="POST">
	<input type="hidden" name="id" value="<%out.print(person.getId());%>">
		<div class="form-group">
			<label for="nome">Nome:</label> <input type="text" id="nome"
				name="nome" class="form-control"
				value="<%out.print(person.getName());%>">
		</div>
		<div class="form-group">
			<label for="sobrenome">Sobrenome:</label> <input type="text"
				id="sobrenome" name="sobrenome" class="form-control"
				value="<%out.print(person.getSurname());%>">
		</div>
		<div class="form-group">
			<label for="livro">Livro que está lendo:</label> <select id="livro"
				name="livro" class="form-control">
				<%
				for (int i = 0; i < books.size(); i++) {
				%>
				<option value="<%out.print(books.get(i).getId());%>"><%out.print(books.get(i).getName());%></option>
				<%
				}
				%>

			</select>
		</div>
		<button type="submit" class="my-btn">Enviar</button>
	</form>



	<%@ include file="../includes/footer.jsp"%>
	<script type="text/javascript" src="scripts/validationDeletePerson.js"></script>
</body>
</html>