package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBconnector.DBConnector;
import beans.UserBean;
import users.UpdateForm;
import users.UserViewForm;

public class UserDao {

	//検索・全レコード取り出し
	public List<UserBean> getUserAll(UserViewForm form) {
		DBConnector db = new DBConnector();
		List<UserBean> users = null;
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM CUSTOMER WHERE 1=1";// 準備//

			StringBuilder Sql = new StringBuilder(sql);
			if (form.getUserId() != 0) {
				Sql.append(" and USER_ID = ?");
			}
			if (form.getFirstName() != null && !form.getFirstName().isEmpty()) {
				Sql.append(" and FIRST_NAME like ?");
			}
			if (form.getLastName() != null && !form.getLastName().isEmpty()) {
				Sql.append(" and LAST_NAME like ?");
			}
			if (form.getFirstNameKana() != null && !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and FIRST_NAME_KANA like ?");
			}
			if (form.getFirstNameKana() != null && !form.getFirstNameKana().isEmpty()) {
				Sql.append(" and LAST_NAME_KANA like ?");
			}
			if (form.getSex() != null && !form.getSex().isEmpty()) {
				Sql.append(" and SEX like ?");
			}
			if (form.getClassification1() != null && !form.getClassification1().isEmpty()) {
				Sql.append(" and CLASSIFICATION1 like ?");
			}
			if (form.getClassification2() != null && !form.getClassification2().isEmpty()) {
				Sql.append(" and CLASSIFICATION2 like ?");
			}
			if (form.getPositionName() != null && !form.getPositionName().isEmpty()) {
				Sql.append(" and POSITION_NAME like ?");
			}
			if (form.getStreet1() != null && !form.getStreet1().isEmpty()) {
				Sql.append(" and STREET1 like ?");
			}
			if (form.getStreet2() != null && !form.getStreet2().isEmpty()) {
				Sql.append(" and STREET2 like ?");
			}
			if (form.getTell() != null && !form.getTell().isEmpty()) {
				Sql.append(" and TELL like ?");
			}
			if (form.getFax() != null && !form.getFax().isEmpty()) {
				Sql.append(" and FAX like ?");

			}
			if (form.getMobile() != null && !form.getMobile().isEmpty()) {
				Sql.append(" and mobile like ?");
			}
			if (form.getEmail() != null && !form.getEmail().isEmpty()) {
				Sql.append(" and EMAIL like ?");
			}
			Sql.append(" ORDER BY  USER_ID ASC");
			

			// ドライバロード.DB接続.SQLをセット
			st = db.connect().prepareStatement(Sql.toString());

			int index = 0;

			if (form.getUserId() != 0) {
				st.setInt(++index, form.getUserId());
			}
			if (form.getFirstName() != null && !form.getFirstName().isEmpty()) {
				st.setString(++index, "%" + form.getFirstName() + "%");
			}
			if (form.getLastName() != null && !form.getLastName().isEmpty()) {
				st.setString(++index, "%" + form.getLastName() + "%");
			}
			if (form.getFirstNameKana() != null && !form.getFirstNameKana().isEmpty()) {
				st.setString(++index, "%" + form.getFirstNameKana() + "%");
			}
			if (form.getFirstNameKana() != null && !form.getFirstNameKana().isEmpty()) {
				st.setString(++index, "%" + form.getFirstNameKana() + "%");
			}
			if (form.getSex() != null && !form.getSex().isEmpty()) {
				st.setString(++index, "%" + form.getSex() + "%");
			}
			if (form.getClassification1() != null && !form.getClassification1().isEmpty()) {
				st.setString(++index, "%" + form.getClassification1() + "%");
			}
			if (form.getClassification2() != null && !form.getClassification2().isEmpty()) {
				st.setString(++index, "%" + form.getClassification2() + "%");
			}
			if (form.getPositionName() != null && !form.getPositionName().isEmpty()) {
				st.setString(++index, "%" + form.getPositionName() + "%");
			}
			if (form.getStreet1() != null && !form.getStreet1().isEmpty()) {
				st.setString(++index, "%" + form.getStreet1() + "%");
			}
			if (form.getStreet2() != null && !form.getStreet2().isEmpty()) {
				st.setString(++index, "%" + form.getStreet2() + "%");
			}
			if (form.getTell() != null && !form.getTell().isEmpty()) {
				st.setString(++index, "%" + form.getTell() + "%");
			}
			if (form.getFax() != null && !form.getFax().isEmpty()) {
				st.setString(++index, "%" + form.getFax() + "%");
			}
			if (form.getMobile() != null && !form.getMobile().isEmpty()) {
				st.setString(++index, "%" + form.getMobile() + "%");
			}
			if (form.getEmail() != null && !form.getEmail().isEmpty()) {
				st.setString(++index, "%" + form.getEmail() + "%");
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
				user.setPostal(rs.getString("POSTAL"));
				user.setStreet1(rs.getString("STREET1"));
				user.setFax(rs.getString("FAX"));
				user.setTell(rs.getString("TELL"));
				user.setMobile(rs.getString("MOBILE"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPositionName(rs.getString("POSITION_NAME"));
				user.setStreet2(rs.getString("STREET2"));
				user.setComment1(rs.getString("COMMENT1"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);
		}
		return users;

	}

	//Update
	public void doUpdate(UpdateForm form) {
		DBConnector db = new DBConnector();
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		try {
			String sql = "UPDATE CUSTOMER SET FIRST_NAME = ?, LAST_NAME = ?,FIRST_NAME_KANA = ?, LAST_NAME_KANA = ?, TITLE = ?, SEX = ?, CLASSIFICATION1 = ?, CLASSIFICATION2 = ?, POSITION_NAME = ?, COMPANY = ?, DEPARTMENT1 = ?, DEPARTMENT2 = ?, POSTAL = ?, STREET1 = ?,STREET2 = ?, TELL = ?, FAX = ?, MOBILE = ?, EMAIL = ?, UPDATE_DATE = SYSDATE, CHANGEDATE_DATE = TO_DATE(?), COMMENT1 = ? WHERE USER_ID = ?";
			StringBuilder Sql = new StringBuilder(sql);
			st = db.connect().prepareStatement(Sql.toString());// 準備//
			int index = 0;
			st.setString(++index, form.getFirstName());
			st.setString(++index, form.getLastName());
			st.setString(++index, form.getFirstNameKana());
			st.setString(++index, form.getLastNameKana());
			st.setString(++index, form.getTitle());
			st.setString(++index, form.getSex());
			st.setString(++index, form.getClassification1());
			st.setString(++index, form.getClassification2());
			st.setString(++index, form.getPositionName());
			st.setString(++index, form.getCompany());
			st.setString(++index, form.getDepartment1());
			st.setString(++index, form.getDepartment2());
			st.setString(++index, form.getPostal());
			st.setString(++index, form.getStreet1());
			st.setString(++index, form.getStreet2());
			st.setString(++index, form.getTell());
			st.setString(++index, form.getFax());
			st.setString(++index, form.getMobile());
			st.setString(++index, form.getEmail());
			st.setDate(++index, form.getChangeDate());
			st.setString(++index, form.getComment1());
			st.setInt(++index, form.getUserId());
			System.out.println(st);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st);
		}

	}
  
	//Oneレコード分データ
	public List<UserBean> getOneRecode(int userId) {
		DBConnector db = new DBConnector();
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		List<UserBean> users = null;
		ResultSet rs = null;
		try {
			st = db.connect().prepareStatement("SELECT * FROM CUSTOMER WHERE USER_ID = ?");
			st.setInt(1, userId);
			rs = st.executeQuery();// 実行と結果の戻り//
			users = new ArrayList<>();
			UserBean user = new UserBean();
			while (rs.next()) {// 次のレコードに下がれればの条件式//
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
				user.setPostal(rs.getString("POSTAL"));
				user.setStreet1(rs.getString("STREET1"));
				user.setFax(rs.getString("FAX"));
				user.setTell(rs.getString("TELL"));
				user.setMobile(rs.getString("MOBILE"));
				user.setEmail(rs.getString("EMAIL"));
				user.setStreet2(rs.getString("STREET2"));
				user.setComment1(rs.getString("COMMENT1"));
				user.setPositionName(rs.getString("POSITION_NAME"));
				user.setChangeDate(rs.getDate("CHANGEDATE_DATE"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			db.close(st);
		}
		return users;
	}

	//プールダウン用、分類１、分類2、性別、敬称リスト
	public List<UserBean> doPullDown() {
		DBConnector db = new DBConnector();
		List<UserBean> pullDowns = null;
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		ResultSet rs = null;
		try {
			pullDowns = new ArrayList<UserBean>();
			st = db.connect().prepareStatement("SELECT * FROM PULLDOWN");
			rs = st.executeQuery();
			while (rs.next()) {
				UserBean list = new UserBean();
				list.setTitle(rs.getString("TITLE_NAME"));
				list.setSex(rs.getString("SEX"));
				list.setClassification1(rs.getString("CLASSIFICATION1_NAME"));
				list.setClassification2(rs.getString("CLASSIFICATION2_NAME"));
				pullDowns.add(list);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} // 準備//

		return pullDowns;

	}

}
