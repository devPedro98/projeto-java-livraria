package br.com.livrariaasafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariaasafe.model.DAO;
import br.com.livrariaasafe.model.JavaBeans;

@WebServlet(urlPatterns = { "/SelectIdController", "/selectid" })
public class SelectIdController extends HttpServlet {
	private static DAO dao = new DAO();
	private static final long serialVersionUID = 1L;

	public SelectIdController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getServletPath();
			if (action.equals("/selectid")) {
				showBookId(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	protected void showBookId(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		JavaBeans javaBeans = dao.showBookId(id);
		request.setAttribute("javabeans", javaBeans);
		request.getRequestDispatcher("html/book-id.jsp").forward(request, response);
	}

}
