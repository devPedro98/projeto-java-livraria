<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.book.Book"%>
<%@page import="java.util.ArrayList"%>
<%
Book book = (Book) request.getAttribute("book");
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
<link rel="stylesheet" href="css/add-book.css">
<link rel="stylesheet" href="css/setError.css">
</head>
<body>
	<%@ include file="../includes/header.jsp"%>

	<section>
		<form id="add-book" action="updateBook">
			<label
				class="col-sm-2 col-form-label col-form-label-sm label-add-book">ID</label>
			<div class="col-sm-10">
				<input type="text" name="id" id="book-id" class="form-control"
					value="<%out.print(book.getId());%>" readonly>
			</div>
			<label for="book-name"
				class="col-sm-2 col-form-label col-form-label-sm label-add-book">Nome</label>
			<div class="col-sm-10">
				<input type="text" name="nome" id="book-name"
					class="form-add-book form-control" oninput="nameValidate()"
					value="<%out.print(book.getName());%>" required>
				<span class="span-off">Nome deve ter mais do que 8 caracteres</span>
			</div>

			<label for="book-author"
				class="col-sm-2 col-form-label label-add-book">Autor</label>
			<div class="col-sm-10">
				<input type="text" pattern="^[a-zA-ZÀ-ÿ]+(?: [a-zA-ZÀ-ÿ]+)*$"
					title="Este campo só aceita letras" oninvalid="" name="autor"
					id="book-author" class="form-add-book form-control"
					oninput="authorValidate()"
					value="<%out.print(book.getAuthor());%>" required><span
					class="span-off">Autor deve ter mais do que 8 caracteres</span>
			</div>

			<label for="book-category"
				class="col-sm-2 col-form-label col-form-label-lg label-add-book">Categoria</label>
			<div class="col-sm-10">
				<input type="text" pattern="^[a-zA-ZÀ-ÿ]+(?: [a-zA-ZÀ-ÿ]+)*$"
					title="Este campo só aceita letras" name="categoria"
					id="book-category" class="form-add-book form-control"
					oninput="categoryValidate()"
					value="<%out.print(book.getCategory());%>" required><span
					class="span-off">Nome deve ter mais do que 5 caracteres</span>
			</div>
			<input id="input-cadastrar" type="submit" value="Atualizar"
				class="btn btn-primary btn-atualizar-livro">
		</form>
	</section>

	<%@ include file="../includes/footer.jsp"%>
	<script type="text/javascript" src="scripts/formValidation.js"></script>
</body>
</html>