package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBconnector.DBConnect;
import beans.AdminBean;
import join.UpdateActionForm;

public class AdminDao {

	private static AdminDao instance;

	// singleton pattern
	private AdminDao() {
	}

	public static AdminDao getInstance() {
		if (instance == null)
			instance = new AdminDao();
		return instance;
	}

	public AdminBean getUserInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminBean member = null;

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM ADMIN WHERE EMAIL=?");

			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new AdminBean();
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setFirstName(rs.getString("first_name"));
				member.setLastName(rs.getString("last_name"));
			}
			
			return member;
		} catch (

		Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public int loginCheck(String id, String pw) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String dbPW = ""; // db password
		int logCount; 
		
		int x = -1;

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT PASSWORD, LOGIN_MISS_COUNT FROM ADMIN WHERE EMAIL=?");
			
			StringBuffer query2 = new StringBuffer();
			query2.append("UPDATE ADMIN SET LOGIN_MISS_COUNT = LOGIN_MISS_COUNT+1");
			query2.append(" WHERE EMAIL=?");
			
			conn = DBConnect.getConnection();
			st = conn.prepareStatement(query.toString());
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				dbPW = rs.getString("password");
				logCount = rs.getInt("LOGIN_MISS_COUNT");
				if (dbPW.equals(pw) && logCount < 6)
					x = 1;
				else {
					st = conn.prepareStatement(query2.toString());
					conn.setAutoCommit(false);
					st.setString(1, id);
					st.executeUpdate();
					conn.commit();
					x = 0;}
			} else {
				x = -1;
			}

			return x;
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
					st = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public void doUpdate(String id, UpdateActionForm form) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			StringBuffer query = new StringBuffer();
			query.append("UPDATE ADMIN SET");
			query.append(" PASSWORD=?, FIRST_NAME=?, LAST_NAME=?");
			query.append(" WHERE EMAIL=?");

			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(query.toString());

			conn.setAutoCommit(false);

			pstmt.setString(1, form.getPassword());
			pstmt.setString(2, form.getFirstname());
			pstmt.setString(3, form.getLastname());
			pstmt.setString(4, id);

			pstmt.executeUpdate();

			conn.commit();

		} catch (

		Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public int deleteUser(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpw = "";
		int x = -1;
		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("SELECT PASSWORD FROM ADMIN WHERE EMAIL=?");

			StringBuffer query2 = new StringBuffer();
			query2.append("DELETE FROM ADMIN WHERE EMAIL=?");

			conn = DBConnect.getConnection();

			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(query1.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpw = rs.getString("password");
				if (dbpw.equals(password)) 
				{
					pstmt = conn.prepareStatement(query2.toString());
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					conn.commit();
					x = 1;
				} else {
					x = 0;
				}
			}
			return x;
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}*/

/**
 * Servlet implementation class AdminDao
 */
/*
 * @WebServlet("/AdminDao") public class AdminDao extends HttpServlet {
 * 
 * 
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public AdminDao() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */
