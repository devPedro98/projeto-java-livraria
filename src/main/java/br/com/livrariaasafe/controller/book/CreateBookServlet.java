package br.com.livrariaasafe.controller.book;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@WebServlet("/createBook")
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(CreateBookServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Book bookJavaBeans = new Book();
			BookDAO bookDAO = new BookDAO();
			bookJavaBeans.setName(request.getParameter("nome"));
			bookJavaBeans.setAuthor(request.getParameter("autor"));
			bookJavaBeans.setCategory(request.getParameter("categoria"));
			bookDAO.register(bookJavaBeans);
			response.sendRedirect("html/successfully-registered-user.jsp");
		} catch (IOException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

}
