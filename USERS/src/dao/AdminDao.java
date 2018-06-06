package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBconnector.DBConnector;
import beans.AdminBean;

public class AdminDao {

	static final int COUNT = 5;
	AdminBean admin = new AdminBean();

	public int OneList(String email, String passWord) {
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		DBConnector db = new DBConnector();// *DBを使用するための準備
		ResultSet rs = null;
		final int COUNT = 5;
		try {
			st = db.connect().prepareStatement("SELECT * FROM ADMIN WHERE EMAIL = ?");
			st.setString(1, "y_ishihara@asupage.co.jp");
			rs = st.executeQuery();// 実行と結果の戻り//
			if (!rs.next()) {
				db.close(st, rs);
				return -1;
			}
//			if (COUNT <= rs.getInt("login_miss_count")) {
//				db.close(st, rs);
//				return -3;
//			}
//			byte[] bytes = MessageDigest.getInstance("MD5").digest(passWord.getBytes(StandardCharsets.UTF_8));
//			String hash = DatatypeConverter.printHexBinary(bytes);
//			if (!hash.equals(rs.getString("password"))) {
//				doCount(email, rs.getInt("login_miss_count"));
//				return -2;
//			}
//			doCountR(email);
//			doLoginTime(email);
			admin.setAdminId(rs.getInt("ADMIN_ID"));
			admin.setFirstName(rs.getString("FIRST_NAME"));
			admin.setLastName(rs.getString("LAST_NAME"));
			admin.setRegistDate(rs.getDate("REGIST_DATE"));
			admin.setEmail(rs.getString("EMAIL"));
			admin.setLoginMissCount(rs.getInt("LOGIN_MISS_COUNT"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);
		}
		return 1;
	}
}