package Projecto_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class DbUtilities {
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dbbanco";
	static final String DATABASE_USER = "root";
	static final String DATABASE_PSW = "root";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DbUtilities() {
		try {
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PSW);
		}catch(SQLException e) {
			System.out.println("Ocorreu o erro " + e.getMessage() + " ao tentar ligar à base de dados.");
		}
	}
	
	public void DisconnectFromDB() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
		}
	}
	
	public ResultSet ReadRecords (String stmt) {
		try {
			this.stmt = conn.createStatement();
			rs = this.stmt.executeQuery(stmt);
		}catch (SQLException e) {
			System.out.println("Ocorreu o seguinte erro: " + e.getMessage() + " ao tentar aceder dados.");
		}
		
		return rs;
	}
	
	public void ExecuteSqlStatement (String stmt) {
		try {
			this.stmt=conn.createStatement();
			this.stmt.executeUpdate(stmt);
		}catch (SQLException e) {
			System.out.println("Ocorreu o seguinte erro: " + e.getMessage() + " ao tentar alterar dados.");
		}
	}
}
