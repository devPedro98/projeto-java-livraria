package br.com.projeto.livraria.book;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.livrariaasafe.controller.book.ReadBooksServlet;
import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

public class ReadTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private BookDAO bookDAO;

    private ReadBooksServlet servlet;

    @Before
    public void setUp() throws ServletException {
        MockitoAnnotations.openMocks(this);
        servlet = new ReadBooksServlet();
        servlet.init();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("O Ladrão de Raios", "Rick Riordan", "Fantasia"));
        expectedBooks.add(new Book("O Mar de Monstros", "Rick Riordan", "Fantasia"));
        expectedBooks.add(new Book("A Maldição do Titã", "Rick Riordan", "Fantasia"));
        expectedBooks.add(new Book("A Batalha do Labirinto", "Rick Riordan", "Fantasia"));
        expectedBooks.add(new Book("O Último Olimpiano", "Rick Riordan", "Fantasia"));

        when(request.getRequestDispatcher("html/books.jsp")).thenReturn(requestDispatcher);
        when(bookDAO.readAllBooks()).thenReturn(expectedBooks);

        servlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }
}
