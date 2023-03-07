<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.book.Book"%>
<%@page import="java.util.ArrayList"%>
<%
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
<link rel="stylesheet" href="css/setError.css">
<link rel="stylesheet" href="css/register-person.css">
</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<form action="ShowBooksRegisterPerson" method="post">
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" required> <label for="sobrenome">Sobrenome:</label>
		<input type="text" id="sobrenome" name="sobrenome" required> <label
			for="livro">Livro que está lendo:</label> <select id="livro"
			name="livro" required>
			<option value="" disabled selected>Selecione um livro</option>
			<%
			for (Book book : books) {
			%>
			<option value="<%=book.getId()%>"><%=book.getName()%></option>
			<%
			}
			%>
		</select><input type="submit" value="Cadastrar">
	</form>




	<%@ include file="../includes/footer.jsp"%>
</body>
</html>