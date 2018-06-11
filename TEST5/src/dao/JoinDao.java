package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.naming.NamingException;

import DBconnector.DBConnect;
import join.JoinActionForm;

public class JoinDao {

	private static JoinDao instance;

	// singleton pattern
	private JoinDao() {
	}

	public static JoinDao getInstance() {
		if (instance == null)
			instance = new JoinDao();
		return instance;
	}
	
	public void insertAdmin(JoinActionForm form) throws SQLException
	{
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DBConnect.getConnection();
			conn.setAutoCommit(false);
			
		}catch(Exception sqle) {
			
			throw new RuntimeException(sqle.getMessage());
		}finally {
			
		}
	}
}
