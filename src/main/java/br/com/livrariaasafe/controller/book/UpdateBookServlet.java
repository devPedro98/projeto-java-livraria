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

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(UpdateBookServlet.class.getName());

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book bookJavaBeans = new Book();
		BookDAO bookDAO = new BookDAO();
		Long idLong = getIdBook(request);
		bookJavaBeans.setId(idLong);
		bookJavaBeans.setName(request.getParameter("nome"));
		bookJavaBeans.setAuthor(request.getParameter("autor"));
		bookJavaBeans.setCategory(request.getParameter("categoria"));
		bookDAO.updateBook(bookJavaBeans);
		try {
			response.sendRedirect("html/successfully-updated.jsp");
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.toString());
		}
	}

	public Long getIdBook(HttpServletRequest request) {
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		return id;
	}

}
