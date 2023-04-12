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

@WebServlet("/selectid")
public class SelectIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(SelectIdController.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDAO bookDAO = new BookDAO();
			String id = request.getParameter("id");
			Long idLong = Long.parseLong(id);
			Book bookJavaBeans = bookDAO.selectId(idLong);
			request.setAttribute("javabeans", bookJavaBeans);
			request.getRequestDispatcher("html/book-id.jsp").forward(request, response);

		} catch (ServletException | IOException | NumberFormatException e) {
			e.printStackTrace();
		}

	}

}
