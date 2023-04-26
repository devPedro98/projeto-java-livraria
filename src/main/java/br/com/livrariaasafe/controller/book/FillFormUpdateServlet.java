package br.com.livrariaasafe.controller.book;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@WebServlet("/fillFormUpdate")
public class FillFormUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(FillFormUpdateServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Book bookJavaBeans = new Book();
			BookDAO bookDAO = new BookDAO();
			Long id = getIdBook(request);
			bookJavaBeans.setId(id);
			bookJavaBeans = bookDAO.selectId(id);
			fillBook(request, bookJavaBeans);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit.jsp");
			requestDispatcher.forward(request, response);
		} catch (IllegalArgumentException|NullPointerException | ServletException | IOException e) {
			logger.log(Level.SEVERE, e.toString());
			request.setAttribute("error", "O ID do livro que você está tentando editar não existe.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error/error-id-doestn-exist.jsp");
			try {
				requestDispatcher.forward(request, response);

			} catch (IOException | ServletException e2) {
				logger.log(Level.WARNING, e2.toString());
			}

		}
	}

	private void fillBook(HttpServletRequest request, Book bookJavaBeans) {
		request.setAttribute("id", bookJavaBeans.getId());
		request.setAttribute("nome", bookJavaBeans.getName());
		request.setAttribute("autor", bookJavaBeans.getAuthor());
		request.setAttribute("categoria", bookJavaBeans.getCategory());
		request.setAttribute("book", bookJavaBeans);
	}

	public Long getIdBook(HttpServletRequest request) {
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("idbook"));
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		return id;
	}

}
