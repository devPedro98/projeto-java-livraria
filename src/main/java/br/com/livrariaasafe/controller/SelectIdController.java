package br.com.livrariaasafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.Book;
import br.com.livrariaasafe.model.BookDAO;

@WebServlet(urlPatterns = { "/SelectIdController", "/selectid" })
public class SelectIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectIdController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getServletPath();
			if (action.equals("/selectid")) {
				showBookId(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	protected void showBookId(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		BookDAO bookDAO = new BookDAO();
		String id = request.getParameter("id");
		Long idLong = Long.parseLong(id);
//		JavaBeans javaBeans = dao.showBookId(id);
		Book bookJavaBeans = bookDAO.selectId(idLong);
		request.setAttribute("javabeans", bookJavaBeans);
		request.getRequestDispatcher("html/book-id.jsp").forward(request, response);
	}

}
