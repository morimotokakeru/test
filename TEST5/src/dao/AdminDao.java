package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBconnector.DBConnector;

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

	public int loginCheck(String id, String pw) {
		DBConnector conn = new DBConnector();
		PreparedStatement st = null;
		ResultSet rs = null;

		String dbPW = ""; // db password
		int x = -1;

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT PASSWORD FROM ADMIN WHERE EMAIL=?");

			st = conn.connect().prepareStatement(query.toString());
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				dbPW = rs.getString("password");
				if (dbPW.equals(pw))
					x = 1;
				else
					x = 0;
			} else {
				x = -1;
			}

			return x;
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				conn.close(st, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
/*
	public List<AdminBean> getAdmin(LoginActionForm form) {
		DBConnector db = new DBConnector();
		List<AdminBean> adminInfo = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM CUSTOMER WHERE 1=1";

			StringBuilder Sql = new StringBuilder(sql);
			if (form.getUserName() != null && !form.getUserName().isEmpty()) {
				Sql.append(" and EMAIL like ?");
			}
			if (form.getPassword() != null && !form.getPassword().isEmpty()) {
				Sql.append(" and PASSWORD like ?");
			}
			st = db.connect().prepareStatement(Sql.toString());

			int index = 0;

			if (form.getUserName() != null && !form.getUserName().isEmpty()) {
				st.setString(++index, "%" + form.getUserName() + "%");
			}
			if (form.getPassword() != null && !form.getPassword().isEmpty()) {
				st.setString(++index, "%" + form.getPassword() + "%");
			}

			rs = st.executeQuery();
			adminInfo = new ArrayList<>();
			while (rs.next()) {
				AdminBean admin = new AdminBean();
				admin.setEmail(rs.getString("EMAIL"));
				admin.setPassword(rs.getString("PASSWORD"));

				adminInfo.add(admin);
				System.out.println(adminInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);
		}
		return adminInfo;

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