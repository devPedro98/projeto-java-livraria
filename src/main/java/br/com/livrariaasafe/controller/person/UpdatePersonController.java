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

@WebServlet(urlPatterns = { "/UpdatePersonController" })
public class UpdatePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePersonController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idPerson = Long.parseLong(request.getParameter("id"));
			PersonDAO personDAO = new PersonDAO();
			Person person = personDAO.getPerson(idPerson);
			BookDAO bookDAO = new BookDAO();
			List<Book> books = bookDAO.readAllBooks();
			request.setAttribute("nome", person.getName());
			request.setAttribute("sobrenome", person.getSurname());
			request.setAttribute("livro", person.getBook().getName());
			request.setAttribute("person", person);
			request.setAttribute("books", books);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit-person.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
