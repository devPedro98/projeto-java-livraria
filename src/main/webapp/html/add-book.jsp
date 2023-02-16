<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../css/style.css">
<link rel="shortcut icon" href="../img/favicon-livro.png"
	type="image/x-icon" />
<link rel="stylesheet" href="../css/books.css">
<link rel="stylesheet" href="../css/add-book.css">
<link rel="stylesheet" href="../css/setError.css">
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

	<section>
		<form id="add-book"
			action="http://localhost:8080/projeto-livraria/Controller"
			method="POST">
			<label for="book-name"
				class="col-sm-2 col-form-label col-form-label-sm label-add-book">Nome</label>
			<div class="col-sm-10">
				<input type="text" name="nome" id="book-name"
					class="form-add-book form-control" placeholder="Nome do livro"  oninput="nameValidate()"
					required> <span class="span-off">Nome deve ter mais do que 8 caracteres</span>
			</div>

			<label for="book-author"
				class="col-sm-2 col-form-label label-add-book">Autor</label>
			<div class="col-sm-10">
				<input type="text" name="autor" id="book-author"
					class="form-add-book form-control" placeholder="Autor do livro" oninput="authorValidate()"
					required><span class="span-off">Autor deve ter mais do que 8 caracteres</span>
			</div>

			<label for="book-category"
				class="col-sm-2 col-form-label col-form-label-lg label-add-book">Categoria</label>
			<div class="col-sm-10">
				<input type="text" name="categoria" id="book-category"
					class="form-add-book form-control" placeholder="Categoria do livro" oninput="categoryValidate()"
					required><span class="span-off">Nome deve ter mais do que 5 caracteres</span>
			</div>
			<input id="input-cadastrar" type="submit" value="Cadastrar"
				class="btn btn-primary">

		</form>
	</section>

	<footer> Copyright 2023 Â© - Asafe Livrariaâ¢ </footer>
	<script type="text/javascript" src="../scripts/formValidation.js"></script>
</body>
</html>