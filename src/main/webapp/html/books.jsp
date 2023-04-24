<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.book.Book"%>
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
<link rel="stylesheet" href="css/validationDelete.css">
</head>
<body>

	<%@ include file="../includes/header.jsp"%>
	<section class="search-container">
		<form class="search-form-by-id"
			action="http://localhost:8080/projeto-livraria/selectid">
			<input class="search-input-by-id" type="text" pattern="^[0-9]+$"
				title="O campo ID só aceita números maior do que 0" placeholder="ID"
				name="id">
			<button class="search-button-by-id" type="submit">
				<i class="fa fa-search"></i>Buscar
			</button>
		</form>
	</section>



	<section id="section-table-form">
		<table class="table">
			<caption></caption>
			<thead class="table-header">
				<tr>
					<th class="table-cell">Id</th>
					<th class="table-cell">Nome</th>
					<th class="table-cell">Autor</th>
					<th class="table-cell">Categoria</th>
					<th class="table-cell">Opções</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="bookList" value="${asafelibrary}" />
				<c:choose>
					<c:when test="${not empty bookList}">
						<c:forEach items="${bookList}" var="b">
							<tr>
								<td class="table-cell"><c:out value="${b.id}" /></td>
								<td class="table-cell"><c:out value="${b.name}" /></td>
								<td class="table-cell"><c:out value="${b.author}" /></td>
								<td class="table-cell"><c:out value="${b.category}" /></td>
								<td class="table-cell"><a
									href="fillFormUpdate?idbook=${b.id}"
									class="btn btn-primary edit-book">Editar</a> <a
									href="javascript: validation(${b.id})"
									class="btn button-delete">Deletar</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>Nenhum livro foi cadastrado</td>
							<td>Nenhum livro foi cadastrado</td>
							<td>Nenhum livro foi cadastrado</td>
							<td>Nenhum livro foi cadastrado</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</section>

	<div class="div-button-add-book">
		<a id="button-add-book" class="btn btn-primary button-add-book"
			href="http://localhost:8080/projeto-livraria/html/add-book.jsp">Novo
			Livro</a>
	</div>

	<%@ include file="../includes/footer.jsp"%>
	<script type="text/javascript" src="scripts/validationDelete.js"></script>
</body>
</html>