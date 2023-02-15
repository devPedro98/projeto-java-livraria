package br.com.livrariaasafe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

	final Logger logger = Logger.getLogger(DAO.class.getName());

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/livraria?useUnicode=true&characterEncoding=utf-8&useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "10203040";

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString(), e);
			return null;
		}
	}

	public void createBook(JavaBeans contact) {
		String create = "insert into livro (nome, autor, categoria) values (?, ?, ?)";
		try {
			Connection connectionDB = connect();
			PreparedStatement pst = connectionDB.prepareStatement(create);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getAuthor());
			pst.setString(3, contact.getCategory());
			pst.executeUpdate();
			connectionDB.close();

		} catch (SQLException|NullPointerException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}
	}
	
	public ArrayList<JavaBeans> readBooks() {
		ArrayList<JavaBeans> books = new ArrayList<>();
		String read = "select * from livro";
		try {
			Connection connectionDB = connect();
			PreparedStatement pst = connectionDB.prepareStatement(read);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				String id = result.getString(1);
				String name = result.getString(2);
				String author = result.getString(3);
				String category = result.getString(4);
				books.add(new JavaBeans(id, name, author, category));
			}
			connectionDB.close();
			return books;
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString(), e);
			return books;
		}
	}
}
