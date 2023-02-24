<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("asafelibrary");
%>
<!DOCTYPE html>
<html lang="pt-br">
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
<link rel="stylesheet" href="css/validationDelete.css">
</head>
<body>

	<%@ include file="../includes/header.jsp"%>
	<section class="search-container">
		<form action="http://localhost:8080/projeto-livraria/selectid">
			<input type="text" pattern="^[0-9]+$"
				title="O campo ID só aceita números maior do que 0" placeholder="ID"
				name="id">
			<button type="submit">
				<i class="fa fa-search">Buscar</i>
			</button>
		</form>
	</section>

	<section id="section-table-form">

		<table id=table-form>
			<caption></caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Autor</th>
					<th>Categoria</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getId()%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getAuthor()%></td>
					<td><%=list.get(i).getCategory()%></td>
					<td><a href="select?idbook=<%=list.get(i).getId()%>"
						class="btn btn-primary">Editar</a> <a
						href="javascript: validation(<%=list.get(i).getId()%>)"
						class="btn button-delete">Deletar</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</section>
	<div class="div-button-add-book">
		<a class="btn btn-primary button-add-book"
			href="http://localhost:8080/projeto-livraria/html/add-book.jsp">Novo
			Livro</a>
	</div>

	<footer> Copyright 2023 © - Livraria Asafe </footer>
	<script type="text/javascript" src="scripts/validationDelete.js"></script>
</body>
</html>