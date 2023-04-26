<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Erro - ID não existente</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/projeto-livraria/css/error-delete-book.css">
</head>
<body>
	<div class="container">
		<h1>Erro - Não foi possível concluir ação que você tentou
			executar, ID inexistente</h1>
		<div class="error">
			<c:if test="${not empty requestScope.error}">
				<div class="error">
					<c:out value="${requestScope.error}" />
				</div>
			</c:if>
		</div>
		<p>Se você precisa de ajuda, entre em contato com o nosso suporte
			técnico:</p>
		<p>
			<a href="mailto:suporte@asafelivraria.com.br">suporte@asafelivraria.com.br</a>
		</p>
		<p>
			Clique <a href="http://localhost:8080/projeto-livraria/readBooks">aqui</a>
			para voltar ao menu de livros.
		</p>
	</div>
</body>
</html>
