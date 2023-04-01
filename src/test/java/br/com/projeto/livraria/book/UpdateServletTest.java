package br.com.projeto.livraria.book;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.livrariaasafe.controller.book.UpdateBookServlet;
import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

public class UpdateServletTest {

	private UpdateBookServlet servlet = new UpdateBookServlet();

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private BookDAO bookDAO;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    public void testService() throws ServletException, IOException {
        // Simula os parâmetros do request
        when(request.getParameter("id")).thenReturn("418");
        when(request.getParameter("nome")).thenReturn("Novo Nome");
        when(request.getParameter("autor")).thenReturn("Novo Autor");
        when(request.getParameter("categoria")).thenReturn("Nova Categoria");

        // Simula o ID do livro a ser atualizado
        Long id = Long.valueOf(request.getParameter("id"));

        // Simula o livro a ser atualizado
        Book book = new Book();
        book.setId(id);
        book.setName(request.getParameter("nome"));
        book.setAuthor(request.getParameter("autor"));
        book.setCategory(request.getParameter("categoria"));

        // Chama o método a ser testado
        servlet.service(request, response);

        // Verifica se o livro foi atualizado corretamente no banco de dados
        verify(response).sendRedirect("html/successfully-updated.jsp");
    }

}
