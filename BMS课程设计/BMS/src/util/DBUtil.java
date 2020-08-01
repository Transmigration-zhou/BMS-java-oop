package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <p>Title: DBUtil</p>
 * <p>Description: 连接数据库</p>
 * @author Transmirgration_zhou
 * @date 2020年6月25日
 */
public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/bms?"
			+ "useUnicode = true & serverTimezone = GMT"
			// MySQL在高版本需要指明是否进行SSL连接
			+ "& characterEncoding = utf8 & useSSL = false";
	private static String user = "root";
	private static String password = "zhou0322";
	private static String jdbcName = "com.mysql.cj.jdbc.Driver"; // 驱动名称
	private static Connection con = null;

	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception {
		Class.forName(jdbcName);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

//	测试用
//	public static void main(String[] args) {
//		new DBUtil();
//		try {
//			DBUtil.getCon();
//			System.out.println("数据库连接成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("数据库连接失败");
//		}
//	}
}
