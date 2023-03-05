<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.livrariaasafe.model.Person"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Person> list = (ArrayList<Person>) request.getAttribute("persondao");
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
<link rel="stylesheet" href="css/reader.css">

</head>
<body>
	<%@ include file="../includes/header.jsp"%>
	<table>
		<caption></caption>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Livro que está lendo</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getSurname()%></td>
				<td><%=list.get(i).getBook().getName()%></td>
				<%
				}
				%>
			
		</tbody>
	</table>

	<a id="botao-cadastrar"
		href="http://localhost:8080/projeto-livraria/html/register-person.jsp">Cadastrar
		leitor</a>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>