package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBconnector.DBConnector;
import beans.UserBean;
import users.UserViewForm;

public class UserDao{

	public List<UserBean> getUserAll(UserViewForm form){
		DBConnector db = new DBConnector();
		List<UserBean> users = null;
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		ResultSet rs = null;
		try {
			String sql = "select * from CUSTOMER wehre 1=1";// 準備//

			StringBuilder Sql = new StringBuilder(sql);
			if(form.getUserId() != 0) {
				Sql.append(" and USER_ID = ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and first_name like ?");
			}
			if(form.getLastName() != null || !form.getLastName().isEmpty()) {
				Sql.append(" and last_name like ?");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and first_name_kana like ?");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and last_name_kana like ?");
			}
			if(form.getSex() != null || !form.getSex().isEmpty()) {
				Sql.append(" and sex like ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and user_name like ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and user_name like ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and user_name like ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and user_name like ?");
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				Sql.append(" and user_name like ?");
			}

			// ドライバロード.DB接続.SQLをセット
			st = db.connect().prepareStatement(Sql.toString());
			rs = st.executeQuery();// 実行と結果の戻り//
			users = new ArrayList<>();
			while (rs.next()) {// 次のレコードに下がれればの条件式//
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setFirstNameKana(rs.getString("first_name_kana"));
				user.setLastName(rs.getString("last_name"));
				user.setLastNameKana(rs.getString("last_name"));
				user.setTitle(rs.getString("title"));
				user.setSex(rs.getString("sex"));
				user.setClassification1(rs.getString("classification"));
				user.setClassification2(rs.getString("classification2"));
				user.setCompany(rs.getString("company"));
				user.setDepartment1(rs.getString("department1"));
				user.setDepartment2(rs.getString("department2"));
				user.setPostal(rs.getInt("postal"));
				user.setStreet1(rs.getString("street1"));
				user.setStreet2(rs.getString("street2"));
				user.setTell(rs.getString("tell"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);
		}
		return users;

	}

}
