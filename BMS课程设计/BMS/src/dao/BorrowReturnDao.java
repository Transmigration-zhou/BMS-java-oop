package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Book;
import model.User;

/**
 * <p>Title: BorrowReturnDao</p>
 * <p>Description: </p>
 * @author Transmirgration_zhou
 * @date 2020年6月29日
 */
public class BorrowReturnDao {
	public void borrow(Connection con, Book book, User user) throws Exception {
		String sql1 = "update 图书信息 set 是否被借阅=? where ID=?";
		String sql2 = "update 读者信息 set 已借书数量=?,书籍ID=? where ID=?";
		PreparedStatement psmt1 = con.prepareStatement(sql1);
		PreparedStatement psmt2 = con.prepareStatement(sql2);
		psmt1.setBoolean(1, book.getBcheck());
		psmt1.setInt(2, book.getBID());
		psmt1.execute();
		psmt2.setInt(1, user.getNumber());
		psmt2.setString(2, user.getBook());
		psmt2.setInt(3, user.getId());
		psmt2.execute();
	}
	
	public void return1(Connection con, Book book, User user) throws Exception {
		String sql1 = "update 图书信息 set 是否被借阅=? where ID=?";
		String sql2 = "update 读者信息 set 已借书数量=?,书籍ID=? where ID=?";
		PreparedStatement psmt1 = con.prepareStatement(sql1);
		PreparedStatement psmt2 = con.prepareStatement(sql2);
		psmt1.setBoolean(1, book.getBcheck());
		psmt1.setInt(2, book.getBID());
		psmt1.execute();
		psmt2.setInt(1, user.getNumber());
		psmt2.setString(2, user.getBook());
		psmt2.setInt(3, user.getId());
		psmt2.execute();
	}
}
