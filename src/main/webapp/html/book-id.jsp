<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet" href="css/add-book.css">
<link rel="stylesheet" href="css/setError.css">
<link rel="stylesheet" href="css/validationDelete.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<a class="navbar-brand text-white"
				href="http://localhost:8080/projeto-livraria/index.html">Asafe
				Livraria</a>
			<button class="navbar-toggler bg-light" type="button"
				data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link text-white"
						href="http://localhost:8080/projeto-livraria/main">Livros<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link text-white" href="#">Categorias</a>
					</li>
					<li class="nav-item"><a class="nav-link text-white" href="#">Autores</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
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

				<tr>
					<c:if test="${ javabeans != null}">
						<td><c:out value="${ javabeans.id}" /></td>
						<td><c:out value="${ javabeans.name}" /></td>
						<td><c:out value="${ javabeans.author}" /></td>
						<td><c:out value="${ javabeans.category}" /></td>
						<td><a href="select?idbook=${ javabeans.id}"
						class="btn btn-primary">Editar</a> <a
						href="javascript: validation(${ javabeans.id})"
						class="btn btn-danger btn-book-id">Deletar</a></td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</section>


	<footer> Copyright 2023 © - Livraria Asafe</footer>
	<script type="text/javascript" src="scripts/validationDelete.js"></script>
</body>
</html>