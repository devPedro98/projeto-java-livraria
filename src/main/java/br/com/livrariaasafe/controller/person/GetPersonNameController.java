package br.com.livrariaasafe.controller.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.person.Person;
import br.com.livrariaasafe.model.person.PersonDAO;


@WebServlet(urlPatterns = { "/GetPersonNameController" })
public class GetPersonNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetPersonNameController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersonDAO personDAO = new PersonDAO();
			List<Person> list = personDAO.readAllPeople();
			request.setAttribute("persondao", list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/reader.jsp");
			requestDispatcher.forward(request, response);
		} catch (IOException|ServletException e) {
			e.printStackTrace();
		}
	}
	
	

}
