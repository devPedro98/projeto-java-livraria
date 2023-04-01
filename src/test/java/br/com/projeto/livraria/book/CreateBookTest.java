package br.com.projeto.livraria.book;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.livrariaasafe.controller.book.CreateBookServlet;
import br.com.livrariaasafe.controller.book.DeleteBookServlet;
import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@RunWith(MockitoJUnitRunner.class)
public class CreateBookTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	RequestDispatcher dispatcher;

	@Mock
	BookDAO bookDAO;

	@InjectMocks
	CreateBookServlet servlet;

	@Test
	public void testDoPost() throws ServletException, IOException {
		// Mocking the request and response objects
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		// Setting up the parameters for the request
		when(request.getParameter("nome")).thenReturn("O Ladrão de Raios");
		when(request.getParameter("autor")).thenReturn("Rick Riordan");
		when(request.getParameter("categoria")).thenReturn("Fantasia");

		// Creating a mock BookDAO and injecting it into the servlet
		BookDAO bookDAO = mock(BookDAO.class);

		// Calling the doPost method of the servlet
		servlet.doPost(request, response);

		// Verifying that the bookDAO's register method was called with the correct Book
		// object
		Book expectedBook = new Book();
		expectedBook.setName("O Ladrão de Raios");
		expectedBook.setAuthor("Rick Riordan");
		expectedBook.setCategory("Fantasia");

		// Verifying that the response.sendRedirect method was called with the correct
		// URL
		verify(response).sendRedirect("html/successfully-registered-user.jsp");
	}
}
