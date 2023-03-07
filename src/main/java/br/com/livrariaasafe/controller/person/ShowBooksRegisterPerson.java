package br.com.livrariaasafe.controller.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.model.book.BookDAO;
import br.com.livrariaasafe.model.person.Person;
import br.com.livrariaasafe.model.person.PersonDAO;

@WebServlet(urlPatterns = { "/ShowBooksRegisterPerson" })
public class ShowBooksRegisterPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowBooksRegisterPerson() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDAO bookDAO = new BookDAO();
			List<Book> booksList = bookDAO.readAllBooks();
			request.setAttribute("books", booksList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/register-person.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDAO bookDAO = new BookDAO();
			PersonDAO personDAO = new PersonDAO();
			Person person = new Person();
			String name = request.getParameter("nome");
			String surname = request.getParameter("sobrenome");
			Long bookId = Long.parseLong(request.getParameter("livro"));
			Book book = bookDAO.selectId(bookId);
			person.setName(name);
			person.setSurname(surname);
			person.setBook(book);
			personDAO.createPerson(person);
			response.sendRedirect("html/successfully-registered-person.jsp");

		} catch (IOException|NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
