package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 * <p>Title: UserDao</p>
 * <p>Description: </p>
 * @author Transmirgration_zhou
 * @date 2020年6月29日
 */
public class UserDao {
	/**
	 * 	按姓名为关键字查询
	 * @param con
	 * @param book
	 * @throws Exception
	 */
	public List<User> selectUserName(Connection con, String name) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID,姓名,电话,身份证,已借书数量,书籍ID from 读者信息 where 姓名='" + name + "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<User> userList = new ArrayList<User>();
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("ID"));
			user.setUserName(rs.getString("姓名"));
			user.setPhone(rs.getString("电话"));
			user.setIdentity(rs.getString("身份证"));
			user.setNumber(rs.getInt("已借书数量"));
			user.setBook(rs.getString("书籍ID"));
			userList.add(user);
		}
		return userList;
	}

	/**
	 * 按ID为关键字查询
	 * 
	 * @param con
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> selectUserID(Connection con, int id) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID,姓名,电话,身份证,已借书数量,书籍ID from 读者信息 where ID=" + id;
		ResultSet rs = stmt.executeQuery(sql);
		List<User> userList = new ArrayList<User>();
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("ID"));
			user.setUserName(rs.getString("姓名"));
			user.setPhone(rs.getString("电话"));
			user.setIdentity(rs.getString("身份证"));
			user.setNumber(rs.getInt("已借书数量"));
			user.setBook(rs.getString("书籍ID"));
			userList.add(user);
		}
		return userList;
	}

	public List<User> selectUser(Connection con, String name, int id) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID,姓名,电话,身份证,已借书数量,书籍ID from 读者信息 where ID=" + id + " and 姓名='" + name + "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<User> userList = new ArrayList<User>();
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("ID"));
			user.setUserName(rs.getString("姓名"));
			user.setPhone(rs.getString("电话"));
			user.setIdentity(rs.getString("身份证"));
			user.setNumber(rs.getInt("已借书数量"));
			user.setBook(rs.getString("书籍ID"));
			userList.add(user);
		}
		return userList;
	}

}
