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

	private final Logger logger = Logger.getLogger(DAO.class.getName());
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/livraria?useUnicode=true&characterEncoding=utf-8&useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "10203040";

	private Connection connect() throws SQLException {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			throw new SQLException("Não foi possível estabelecer a conexão com o banco de dados", e);
		}
	}

	public void createBook(JavaBeans contact) {
		String create = "insert into livro (nome, autor, categoria) values (?, ?, ?)";
		PreparedStatement pst = null;
		try {
			Connection con = connect();
			pst = con.prepareStatement(create);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getAuthor());
			pst.setString(3, contact.getCategory());
			pst.executeUpdate();
			con.close();

		} catch (SQLException | NullPointerException e) {
			logger.log(Level.WARNING, e.toString(), e);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<JavaBeans> readBooks() {
		ArrayList<JavaBeans> books = new ArrayList<>();
		String read = "select * from livro";
		PreparedStatement pst = null;
		try {
			Connection connectionDB = connect();
			pst = connectionDB.prepareStatement(read);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String id = result.getString(1);
				String name = result.getString(2);
				String author = result.getString(3);
				String category = result.getString(4);
				books.add(new JavaBeans(id, name, author, category));
			}
			connectionDB.close();
		} catch (SQLException | NullPointerException e) {
			logger.log(Level.WARNING, e.toString(), e);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	public void selectBook(JavaBeans book) {
		String readBook = "select * from livro where id = ?";
		PreparedStatement pst = null;
		try {
			Connection con = connect();
			pst = con.prepareStatement(readBook);
			pst.setString(1, book.getId());
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				book.setId(resultSet.getString(1));
				book.setName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setCategory(resultSet.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.toString(), e);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void changeBook(JavaBeans book) {
		String sqlCommandUpdate = "update livro set nome = ?, autor = ?, categoria = ? where id = ?";
		PreparedStatement pst = null;
		try {
			Connection con = connect();
			pst = con.prepareStatement(sqlCommandUpdate);
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getCategory());
			pst.setString(4, book.getId());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.toString(), e);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void removeBook(JavaBeans book) {
		String delete = "delete from livro where id = ?";
		PreparedStatement pst = null;
		try {
			Connection con = connect();
			pst = con.prepareStatement(delete);
			pst.setString(1, book.getId());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.toString(), e);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
