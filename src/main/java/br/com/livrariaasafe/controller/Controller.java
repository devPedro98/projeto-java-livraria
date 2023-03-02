package br.com.livrariaasafe.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.Book;
import br.com.livrariaasafe.model.BookDAO;
import br.com.livrariaasafe.model.DAO;
import br.com.livrariaasafe.model.JavaBeans;
import br.com.livrariaasafe.util.JPAUtil;

@WebServlet(urlPatterns = { "/Controller", "/main", "/select", "/update", "/delete" })
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
			} else if (action.equals("/delete")) {
				removeBook(request, response);
			} else {
				response.sendRedirect("index.html");
			}
		} catch (IOException | ServletException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	protected void removeBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		book.setId(id);
		dao.removeBook(book);
		response.sendRedirect("main");

	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Book bookJavaBeans = new Book();
		BookDAO bookDAO = new BookDAO();
		String idString = request.getParameter(BOOKID);
		Long idLong = Long.parseLong(idString);
		bookJavaBeans.setId(idLong);
		bookJavaBeans.setName(request.getParameter(BOOKNAME));
		bookJavaBeans.setAuthor(request.getParameter(BOOKAUTOR));
		bookJavaBeans.setCategory(request.getParameter(BOOKCATEGORY));
		bookDAO.updateBook(bookJavaBeans);
		response.sendRedirect("html/successfully-updated.jsp");
	}

	protected void fillFormUpdateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book bookJavaBeans = new Book();
		BookDAO bookDAO = new BookDAO();
		String idBook = request.getParameter("idbook");
		bookJavaBeans.setId(Long.parseLong(idBook));
		bookJavaBeans = bookDAO.selectId(Long.parseLong(idBook));
		request.setAttribute(BOOKID, bookJavaBeans.getId());
		request.setAttribute(BOOKNAME, bookJavaBeans.getName());
		request.setAttribute(BOOKAUTOR, bookJavaBeans.getAuthor());
		request.setAttribute(BOOKCATEGORY, bookJavaBeans.getCategory());
		request.setAttribute("book", bookJavaBeans);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Book bookJavaBeans = new Book();
			BookDAO bookDAO = new BookDAO();
			bookJavaBeans.setName(req.getParameter(BOOKNAME));
			bookJavaBeans.setAuthor(req.getParameter(BOOKAUTOR));
			bookJavaBeans.setCategory(req.getParameter(BOOKCATEGORY));
			bookDAO.register(bookJavaBeans);
			resp.sendRedirect("html/successfully-registered-user.jsp");
		} catch (IOException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	protected void showBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		List<Book> list = bookDAO.readAllBooks();
		request.setAttribute("asafelibrary", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/books.jsp");
		requestDispatcher.forward(request, response);

	}

}
