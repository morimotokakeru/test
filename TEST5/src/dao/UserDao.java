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
				Sql.append(" and FIRST_NAME like ?");
			}
			if(form.getLastName() != null || !form.getLastName().isEmpty()) {
				Sql.append(" and LAST_NAME like ?");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and FIRST_NAME_KANA like ?");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and LAST_NAME_KANA like ?");
			}
			if(form.getSex() != null || !form.getSex().isEmpty()) {
				Sql.append(" and SEX like ?");
			}
			if(form.getClassification1() != null || !form.getClassification1().isEmpty()) {
				Sql.append(" and CLASSIFICATION1 like ?");
			}
			if(form.getClassification2() != null || !form.getClassification2().isEmpty()) {
				Sql.append(" and CLASSIFICATION2 like ?");
			}
			if(form.getPositionName() != null || !form.getPositionName().isEmpty()) {
				Sql.append(" and POSITION_NAME like ?");
			}
			if(form.getStreet1() != null || !form.getStreet1().isEmpty()) {
				Sql.append(" and STREET1 like ?");
			}
			if(form.getTell() != null || !form.getTell().isEmpty()) {
				Sql.append(" and TELL like ?");
			}
			if(form.getFax() != null || !form.getFax().isEmpty()) {
				Sql.append(" and FAX like ?");
				
			}
			if(form.getMobile() != null || !form.getMobile().isEmpty()) {
				Sql.append(" and mobile like ?");
			}
			if(form.getEmail() != null || !form.getEmail().isEmpty()) {
				Sql.append(" and EMAIL like ?");
			}

			// ドライバロード.DB接続.SQLをセット
			st = db.connect().prepareStatement(Sql.toString());

			int index = 0;

			if(form.getUserId() != 0) {
				st.setInt(++index,form.getUserId());
			}
			if(form.getFirstName() != null || !form.getFirstName().isEmpty()) {
				st.setString(++index,"%" + form.getFirstName() + "%");
			}
			if(form.getLastName() != null || !form.getLastName().isEmpty()) {
				st.setString(++index,"%" + form.getLastName() + "%");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				st.setString(++index,"%" + form.getFirstNameKana() + "%");
			}
			if(form.getFirstNameKana() != null || !form.getFirstNameKana().isEmpty()) {
				st.setString(++index,"%" + form.getFirstNameKana() + "%");
			}
			if(form.getSex() != null || !form.getSex().isEmpty()) {
				st.setString(++index,"%" + form.getSex() + "%");
			}
			if(form.getClassification1() != null || !form.getClassification1().isEmpty()) {
				st.setString(++index,"%" + form.getClassification1() + "%");
			}
			if(form.getClassification2() != null || !form.getClassification2().isEmpty()) {
				st.setString(++index,"%" + form.getClassification2() + "%");
			}
			if(form.getPositionName() != null || !form.getPositionName().isEmpty()) {
				st.setString(++index,"%" + form.getPositionName() + "%");
			}
			if(form.getStreet1() != null || !form.getStreet1().isEmpty()) {
				st.setString(++index,"%" + form.getStreet1() + "%");
			}
			if(form.getTell() != null || !form.getTell().isEmpty()) {
				st.setString(++index,"%" + form.getTell() + "%");
			}
			if(form.getFax() != null || !form.getFax().isEmpty()) {
				st.setString(++index,"%" + form.getFax() + "%");
			}
			if(form.getMobile() != null || !form.getMobile().isEmpty()) {
				st.setString(++index,"%" + form.getMobile() + "%");
			}
			if(form.getEmail() != null || !form.getEmail().isEmpty()) {
				st.setString(++index,"%" + form.getEmail() + "%");
			}

			rs = st.executeQuery();// 実行と結果の戻り//
			users = new ArrayList<>();
			while (rs.next()) {// 次のレコードに下がれればの条件式//
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("USER_ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setFirstNameKana(rs.getString("FIRST_NAME_KANA"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setLastNameKana(rs.getString("LAST_NAME_KANA"));
				user.setTitle(rs.getString("TITLE"));
				user.setSex(rs.getString("SEX"));
				user.setClassification1(rs.getString("CLASSIFICATION1"));
				user.setClassification2(rs.getString("CLASSIFICATION2"));
				user.setCompany(rs.getString("COMPANY"));
				user.setDepartment1(rs.getString("DEPARTMENT1"));
				user.setDepartment2(rs.getString("DEPARTMENT2"));
				user.setPostal(rs.getInt("POSTAL"));
				user.setStreet1(rs.getString("STREET1"));
			//	user.setStreet2(rs.getString("street2"));
				user.setTell(rs.getString("TELL"));
				user.setMobile(rs.getString("MOBILE"));
				user.setEmail(rs.getString("EMAIL"));

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
