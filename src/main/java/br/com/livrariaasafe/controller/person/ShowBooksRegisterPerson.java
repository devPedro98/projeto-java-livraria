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
	private final BookDAO bookDAO;
	private final PersonDAO personDAO;

	public ShowBooksRegisterPerson() {
		super();
		this.bookDAO = new BookDAO();
		this.personDAO = new PersonDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Book> booksList = bookDAO.readAllBooks();
			request.setAttribute("books", booksList);
			forwardToPage(request, response, "html/register-person.jsp");

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("nome");
			String surname = request.getParameter("sobrenome");
			Long bookId = Long.parseLong(request.getParameter("livro"));
			Book book = bookDAO.selectId(bookId);

			Person person = createPerson(name, surname, book);
			personDAO.createPerson(person);

			redirectToPage(response, "html/successfully-registered-person.jsp");
		} catch (IOException| NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}

	private void redirectToPage(HttpServletResponse response, String page) throws IOException {
		response.sendRedirect(page);
	}

	private Person createPerson(String name, String surname, Book book) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		person.setBook(book);
		return person;
	}
}
