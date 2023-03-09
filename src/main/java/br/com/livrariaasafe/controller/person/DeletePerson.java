package br.com.livrariaasafe.controller.person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.person.Person;
import br.com.livrariaasafe.model.person.PersonDAO;

@WebServlet(urlPatterns = { "/deleteperson" })
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePerson() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Person person = new Person();
			PersonDAO dao = new PersonDAO();
			Long id = Long.parseLong(request.getParameter("id"));
			person.setId(id);
			dao.deletePerson(person);
			response.sendRedirect("GetPersonNameController");

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
