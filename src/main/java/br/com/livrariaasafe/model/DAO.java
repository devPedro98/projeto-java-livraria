package br.com.livrariaasafe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

	final Logger logger = Logger.getLogger(DAO.class.getName());
	/** Módulos de conexão **/
	// Parâmetros de conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/livraria?useUnicode=true&characterEncoding=utf-8&useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "10203040";

	// Método de conexão
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

		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString(), e);
		}
	}
}
