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
	<%@ include file="../includes/header.jsp"%>
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

				<tr>
					<c:if test="${ javabeans != null}">
						<td class="table-cell"><c:out value="${ javabeans.id}" /></td>
						<td class="table-cell"><c:out value="${ javabeans.name}" /></td>
						<td class="table-cell"><c:out value="${ javabeans.author}" /></td>
						<td class="table-cell"><c:out value="${ javabeans.category}" /></td>
						<td class="table-cell"><a href="fillFormUpdate?idbook=${ javabeans.id}"
							class="btn btn-primary edit-book">Editar</a> <a
							href="javascript: validation(${ javabeans.id})"
							class="btn btn-book-id button-delete">Deletar</a></td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</section>


	<%@ include file="../includes/footer.jsp" %>
	<script type="text/javascript" src="scripts/validationDelete.js"></script>
</body>
</html>