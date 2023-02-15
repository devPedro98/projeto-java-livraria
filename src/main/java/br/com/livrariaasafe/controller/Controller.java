package br.com.livrariaasafe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/Controller", "/main"})
public class Controller extends HttpServlet {
	final Logger logger = Logger.getLogger(Controller.class.getName());
	private static final long serialVersionUID = 1L;
	static DAO dao = new DAO();
	static JavaBeans contact = new JavaBeans();

	public Controller() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/main")) {
			showBooks(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		logger.log(Level.INFO, req.getParameter("nome"));
		logger.log(Level.INFO, req.getParameter("autor"));
		logger.log(Level.INFO, req.getParameter("categoria"));
		out.println("<p>Livro cadastrado com sucesso!</p>");
		contact.setName(req.getParameter("nome"));
		contact.setAuthor(req.getParameter("autor"));
		contact.setCategory(req.getParameter("categoria"));

		dao.createBook(contact);

	}

	protected void showBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> list = dao.readBooks();
		request.setAttribute("asafelibrary", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/books.jsp");
		requestDispatcher.forward(request, response);

	}

}
