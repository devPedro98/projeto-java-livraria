package br.com.projeto.livraria.book;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.livrariaasafe.controller.book.DeleteBookServlet;
import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

class DeleteBookServletTest {

	@InjectMocks
	private DeleteBookServlet deleteBookServlet;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private BookDAO bookDAO;

	@Mock
	private Book book;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testService() throws ServletException, IOException {
		String id = "1";
		Long idLong = Long.parseLong(id);
		BookDAO bookDAO = mock(BookDAO.class);
		when(request.getParameter("id")).thenReturn(id);
		when(book.getId()).thenReturn(idLong);
		doNothing().when(bookDAO).deleteBook(book);
		DeleteBookServlet deleteBookServlet = new DeleteBookServlet(bookDAO);
		doNothing().when(response).sendRedirect("readBooks");

		deleteBookServlet.service(request, response);

		verify(response).sendRedirect("readBooks");
	}

}
