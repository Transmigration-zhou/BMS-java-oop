package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * 
 * <p>Title: BookDao</p>
 * <p>Description: </p>
 * @author Transmirgration_zhou
 * @date 2020年6月29日
 */
public class BookDao {
	/**
	 * 图书添加
	 * 
	 * @param con
	 * @param book
	 * @throws Exception
	 */
	public void insert(Connection con, Book book) throws Exception {
		String sql = "insert into 图书信息 values(?,?,?,?,?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, book.getBID());
		psmt.setString(2, book.getBname());
		psmt.setString(3, book.getBauthor());
		psmt.setString(4, book.getBpublisher());
		psmt.setDouble(5, book.getBprice());
		psmt.setString(6, book.getBISBN());
		psmt.setBoolean(7, book.getBcheck());
		psmt.execute();
	}

	/**
	 * 图书删除
	 * 
	 * @param con
	 * @param ID
	 * @throws Exception
	 */
	public void delete(Connection con, int ID) throws Exception {
		String sql = "delete from 图书信息 where ID=?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, ID);
		psmt.execute();
	}

	/**
	 * 图书修改
	 * 
	 * @param con
	 * @param book
	 * @throws Exception
	 */
	public void update(Connection con, Book book) throws Exception {
		String sql = "update 图书信息 set 图书名称=?,作者=?,出版社=?,定价=?,ISBN=? where ID=?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, book.getBname());
		psmt.setString(2, book.getBauthor());
		psmt.setString(3, book.getBpublisher());
		psmt.setDouble(4, book.getBprice());
		psmt.setString(5, book.getBISBN());
		psmt.setInt(6, book.getBID());
		psmt.execute();
	}

	/**
	 * 按图书名称为关键字查询
	 * 
	 * @param con
	 * @param book
	 * @throws Exception
	 */
	public List<Book> selectBookName(Connection con, String name) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID,图书名称,作者,出版社,定价,ISBN,是否被借阅  from 图书信息 where 图书名称='" + name + "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		while (rs.next()) {
			book = new Book();
			book.setBID(rs.getInt("ID"));
			book.setBname(rs.getString("图书名称"));
			book.setBauthor(rs.getString("作者"));
			book.setBpublisher(rs.getString("出版社"));
			book.setBprice(rs.getDouble("定价"));
			book.setBISBN(rs.getString("ISBN"));
			book.setBcheck(rs.getBoolean("是否被借阅"));
			bookList.add(book);
		}
		return bookList;
	}

	/**
	 * 按作者为关键字查询
	 * 
	 * @param con
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Book> selectAuthor(Connection con, String name) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID, 图书名称, 作者, 出版社, 定价, ISBN,是否被借阅  from 图书信息 where 作者='" + name + "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		while (rs.next()) {
			book = new Book();
			book.setBID(rs.getInt("ID"));
			book.setBname(rs.getString("图书名称"));
			book.setBauthor(rs.getString("作者"));
			book.setBpublisher(rs.getString("出版社"));
			book.setBprice(rs.getDouble("定价"));
			book.setBISBN(rs.getString("ISBN"));
			book.setBcheck(rs.getBoolean("是否被借阅"));
			bookList.add(book);
		}
		return bookList;
	}

	public List<Book> select(Connection con, String bookname, String author) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID, 图书名称, 作者, 出版社, 定价, ISBN,是否被借阅  from 图书信息 where 图书名称='" + bookname + "'and 作者=" + author
				+ "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		while (rs.next()) {
			book = new Book();
			book.setBID(rs.getInt("ID"));
			book.setBname(rs.getString("图书名称"));
			book.setBauthor(rs.getString("作者"));
			book.setBpublisher(rs.getString("出版社"));
			book.setBprice(rs.getDouble("定价"));
			book.setBISBN(rs.getString("ISBN"));
			book.setBcheck(rs.getBoolean("是否被借阅"));
			bookList.add(book);
		}
		return bookList;
	}


	public List<Book> selectID(Connection con, String id) throws Exception {
		Statement stmt = con.createStatement();
		String sql = "select ID, 图书名称, 作者, 出版社, 定价, ISBN,是否被借阅  from 图书信息 where ID='" + id + "'";
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		while (rs.next()) {
			book = new Book();
			book.setBID(rs.getInt("ID"));
			book.setBname(rs.getString("图书名称"));
			book.setBauthor(rs.getString("作者"));
			book.setBpublisher(rs.getString("出版社"));
			book.setBprice(rs.getDouble("定价"));
			book.setBISBN(rs.getString("ISBN"));
			book.setBcheck(rs.getBoolean("是否被借阅"));
			bookList.add(book);
		}
		return bookList;
	}
}
