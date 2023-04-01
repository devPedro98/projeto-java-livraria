package br.com.projeto.livraria.book;

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

import br.com.livrariaasafe.controller.book.FillFormUpdateServlet;
import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@RunWith(MockitoJUnitRunner.class)
public class FillFormUpdateTest {

	@Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private BookDAO bookDAO;
    @Mock
    private RequestDispatcher requestDispatcher;
    @InjectMocks
    private FillFormUpdateServlet fillForm;

    @Test
    public void testDoGet() throws ServletException, IOException {
        // arrange
    	Long id = 420l;
        Book bookJavaBeans = new Book();
        bookJavaBeans.setId(id);
        bookJavaBeans.setName("Harry Potter");
        bookJavaBeans.setAuthor("Will Ledson");
        bookJavaBeans.setCategory("Romance");
        when(request.getParameter("idbook")).thenReturn(String.valueOf(id));
        when(request.getRequestDispatcher("html/edit.jsp")).thenReturn(requestDispatcher);
        
        // act
        fillForm.doGet(request, response);
        
        // assert
        verify(request).setAttribute("id", bookJavaBeans.getId());
        verify(request).setAttribute("nome", bookJavaBeans.getName());
        verify(request).setAttribute("autor", bookJavaBeans.getAuthor());
        verify(request).setAttribute("categoria", bookJavaBeans.getCategory());
        verify(requestDispatcher).forward(request, response);
    }

}
