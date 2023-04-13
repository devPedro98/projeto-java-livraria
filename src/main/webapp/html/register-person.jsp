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
<link rel="stylesheet" href="css/register-person.css">
<link rel="shortcut icon" href="img/favicon-livro.png"
	type="image/x-icon" />
</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<form action="ShowBooksRegisterPerson" method="post">
		<label for="nome">Nome:</label> <input type="text" pattern="^[a-zA-Z]+(?: [a-zA-Z]+)*$" id="nome"
			name="nome" title="Digite apenas letras e não deixe espaços em branco no início ou no final" required> <span id="span-validation-name" class="name-invisible error-span-person">O campo nome precisa ter no mínimo 4 caracteres.</span> <label for="sobrenome">Sobrenome:</label>
		<input type="text" pattern="^[a-zA-Z]+(?: [a-zA-Z]+)*$" id="sobrenome" name="sobrenome" required><span id="span-validation-surname" class="surname-invisible error-span-person">O campo sobrenome precisa ter no mínimo 4 caracteres.</span> <label
			for="livro">Livro que está lendo:</label> <select id="livro"
			name="livro" title="Digite apenas letras e não deixe espaços em branco no início ou no final" required>
			<option value="" disabled selected>Selecione um livro</option>
			<%
			for (Book book : books) {
			%>
			<option value="<%=book.getId()%>"><%=book.getName()%></option>
			<%
			}
			%>
		</select><input id="cadastrar-pessoa" type="submit" value="Cadastrar" disabled>
	</form>




	<%@ include file="../includes/footer.jsp"%>
	<script type="text/javascript" src="scripts/validatePerson.js" ></script>
</body>
</html>