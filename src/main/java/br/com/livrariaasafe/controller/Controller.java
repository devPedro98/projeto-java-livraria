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

@WebServlet(urlPatterns = { "/Controller", "/main", "/select", "/update" })
public class Controller extends HttpServlet {
	final Logger logger = Logger.getLogger(Controller.class.getName());
	private static final long serialVersionUID = 1L;
	static DAO dao = new DAO();
	static JavaBeans book = new JavaBeans();
	private static final String BOOKID = "id";
	private static final String BOOKNAME = "nome";
	private static final String BOOKAUTOR = "autor";
	private static final String BOOKCATEGORY = "categoria";

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
				fillFormUpdateBook(request, response);
			} else if (action.equals("/update")) {
				updateBook(request, response);
			} else {
				response.sendRedirect("index.html");
			}
		} catch (IOException | ServletException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		book.setId(request.getParameter(BOOKID));
		book.setName(request.getParameter(BOOKNAME));
		book.setAuthor(request.getParameter(BOOKAUTOR));
		book.setCategory(request.getParameter(BOOKCATEGORY));
		dao.changeBook(book);
		response.sendRedirect("html/successfully-updated.html");
	}

	protected void fillFormUpdateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBook = request.getParameter("idbook");
		book.setId(idBook);
		dao.selectBook(book);
		request.setAttribute("id", book.getId());
		request.setAttribute("nome", book.getName());
		request.setAttribute("autor", book.getAuthor());
		request.setAttribute("categoria", book.getCategory());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			book.setName(req.getParameter(BOOKNAME));
			book.setAuthor(req.getParameter(BOOKAUTOR));
			book.setCategory(req.getParameter(BOOKCATEGORY));
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
