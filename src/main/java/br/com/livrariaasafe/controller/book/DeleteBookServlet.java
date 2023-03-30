package br.com.livrariaasafe.controller.book;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(DeleteBookServlet.class.getName());

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Book bookJavaBeans = new Book();
			BookDAO bookDAO = new BookDAO();
			String id = request.getParameter("id");
			Long idLong = Long.parseLong(id);
			bookJavaBeans.setId(idLong);
			bookDAO.deleteBook(bookJavaBeans);
			response.sendRedirect("readBooks");

		} catch (RollbackException | IOException e) {
			logger.log(Level.SEVERE, e.toString());
			try {
				response.sendRedirect("error/error-delete-book.html");

			} catch (IOException e2) {
				logger.log(Level.SEVERE, e2.toString());
			}
		}

	}
}
