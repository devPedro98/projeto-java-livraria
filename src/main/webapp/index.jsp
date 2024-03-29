<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Asafe Livraria</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="img/favicon-livro.png"
	type="image/x-icon" />

<!-- Google Font  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Exo+2:wght@300&display=swap"
	rel="stylesheet">
</head>

<body class="body-index">
	<%@ include file="includes/header.jsp"%>
	<div class="container">
		<p class="welcome">Bem-vindo à Asafe Livraria!<br>Se você deseja ter um controle melhor para sua livraria, você está no lugar certo. O nosso sistema permite que você cadastre os livros que você possui em sua livraria e também cadastre os leitores que estão lendo determinado livro.</p>
	</div>

	<main>
		<div class="container carrosel-index">
			<div id="carouselExampleFade" class="carousel slide carousel-fade"
				data-ride="carousel" data-interval="3000">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/img-carousel-1.jpg" class="d-block w-100"
							alt="imagem de um um livro aberto">
					</div>
					<div class="carousel-item">
						<img src="img/img-carousel-2.jpg" class="d-block w-100"
							alt="imagem de um um livro aberto">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleFade"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleFade"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>



	</main>


	<%@ include file="includes/footer.jsp"%>

	<script src="https://kit.fontawesome.com/c742a003d1.js"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>