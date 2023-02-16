package br.com.livrariaasafe.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.DAO;
import br.com.livrariaasafe.model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/select" })
public class Controller extends HttpServlet {
	final Logger logger = Logger.getLogger(Controller.class.getName());
	private static final long serialVersionUID = 1L;
	static DAO dao = new DAO();
	static JavaBeans book = new JavaBeans();

	public Controller() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getServletPath();
			if (action.equals("/main")) {
				showBooks(request, response);
			} else if (action.equals("/select")) {
				updateBook(request, response);
			} else {
				response.sendRedirect("index.html");
			}
		} catch (IOException | ServletException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response) {
		String idBook = request.getParameter("idbook");
		book.setId(idBook);
		dao.selectBook(book);
		System.out.println(book.getId());
		System.out.println(book.getName());
		System.out.println(book.getAuthor());
		System.out.println(book.getCategory());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			book.setName(req.getParameter("nome"));
			book.setAuthor(req.getParameter("autor"));
			book.setCategory(req.getParameter("categoria"));
			dao.createBook(book);
			resp.sendRedirect("html/successfully-registered-user.html");
		} catch (IOException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	protected void showBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<JavaBeans> list = dao.readBooks();
		request.setAttribute("asafelibrary", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/books.jsp");
		requestDispatcher.forward(request, response);

	}

}
