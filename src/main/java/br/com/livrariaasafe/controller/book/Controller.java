package br.com.livrariaasafe.controller.book;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;

@WebServlet(urlPatterns = { "/Controller", "/main", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private final Logger logger = Logger.getLogger(Controller.class.getName());
	private static final long serialVersionUID = 1L;
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
		try {
			Book bookJavaBeans = new Book();
			BookDAO bookDAO = new BookDAO();
			String id = request.getParameter("id");
			Long idLong = Long.parseLong(id);
			bookJavaBeans.setId(idLong);
			bookDAO.deleteBook(bookJavaBeans);
			response.sendRedirect("main");
			
		} catch (RollbackException e) {
			e.printStackTrace();
			response.sendRedirect("error/error-delete-book.html");
		}

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