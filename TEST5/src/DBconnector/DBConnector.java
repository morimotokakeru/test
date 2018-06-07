package DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	private Connection cn = null;
	//変更しないものは定数で用意する
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL  = "jdbc:oracle:thin:@192.168.1.16:1521:orcl";
	private final static String USER = "hr";
	private final static String PASS = "1234";

	// ドライバをロードする
	public DBConnector() {
		try {
			Class.forName(DRIVER).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//DB接続
	public Connection connect() {
		if(this.cn == null) {
			try {
				this.cn = DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//接続が成功したらその接続中のconnectionを呼び出し元に返して使う
		return this.cn;
	}

	//DB切断(Resultsetなしver.)
	public void close(PreparedStatement st) {
		try {
			if (st != null && ! st.isClosed()) {
				//接続中のPreparedStatementを閉じる
				st.close();
			}
			if(this.cn != null && ! this.cn.isClosed()) {
				//接続中のconnectionを閉じる
				this.cn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//DB切断(Resultsetありver.)
		public void close(PreparedStatement st, ResultSet rs) {
			try {
				if (rs != null && ! rs.isClosed()) {
					//接続中のResultSetを閉じる
					rs.close();
				}
				if (st != null && ! st.isClosed()) {
					//接続中のPreparedStatementを閉じる
					st.close();
				}
				if(this.cn != null && ! this.cn.isClosed()) {
					//接続中のconnectionを閉じる
					this.cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}