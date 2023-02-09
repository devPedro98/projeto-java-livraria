package br.com.livrariaasafe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
	
	Logger logger = Logger.getLogger(DAO.class.getName());
	/** Módulos de conexão **/
	//Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/livraria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "10203040";
	//Método de conexão
	private Connection conectar() {
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
	public void testeConexao() {
		try {
			Connection con = conectar();
			logger.log(Level.INFO, con.toString(), con);
			con.close();
		} catch (NullPointerException|SQLException e) {
			logger.log(Level.WARNING, e.toString(), e);
		}
	}
}
