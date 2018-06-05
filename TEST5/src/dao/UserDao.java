package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBconnector.DBConnector;
import beans.UserBean;

public class UserDao{

	public List<UserBean> getUserAll(){
		DBConnector db = new DBConnector();
		List<UserBean> users = null;
		PreparedStatement st = null; // SQLを送るとき必要 /クラス型のst
		ResultSet rs = null;
		try {
			String sql = "select ";// 準備//

			StringBuilder Sql = new StringBuilder(sql);
			// ドライバロード.DB接続.SQLをセット
			st = db.connect().prepareStatement(Sql.toString());
			rs = st.executeQuery();// 実行と結果の戻り//
			users = new ArrayList<>();
			while (rs.next()) {// 次のレコードに下がれればの条件式//
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("user_id"));

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
