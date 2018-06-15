package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO ADMIN values" );
			sql.append("((SELECT nvl(max(admin_id),0)+1 FROM ADMIN), ?, ?, SYSDATE, SYSDATE, ?, ?, ?, SYSDATE)" );
			
			st = conn.prepareStatement(sql.toString());
			st.setString(1,  form.getFirstName());
			st.setString(2,  form.getLastName());
			st.setString(3,  form.getEmail());
			st.setString(4,  form.getPassword1());
			st.setString(5,  "0");
			
			st.executeUpdate();
			
			conn.commit();
			
		}catch(SQLException sqle) {
			
			conn.rollback();
			
			throw new RuntimeException(sqle.getMessage());
		}finally {
			try {
				if( st != null) {
					st.close();
					st=null;
				}
				if( conn != null) {
					conn.close();
					conn=null;
				}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public int idCheck(String email) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String dbEmail = "";
		int x = -1;

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT email FROM ADMIN WHERE EMAIL=?");
			
			conn = DBConnect.getConnection();
			st = conn.prepareStatement(query.toString());
			st.setString(1, email);
			
			rs = st.executeQuery();

			if (rs.next()) {
				dbEmail = rs.getString("email");
				if (dbEmail.equals(email))
					x = 0;
				else
					x = 1;
			} else {
				x = 1;
			}

			return x;
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if(st!= null) {
					st.close();
					st=null;
				}
				if(conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
