package model;

/**
 * <p>Title: Book</p>
 * <p>Description: 图书信息 </p>
 * @author Transmirgration_zhou
 * @date 2020年6月17日
 */

public class Book {
	private int bookID;
	private String bookName;
	private String author;
	private String publisher;
	private double price;
	private String ISBN;
	private Boolean check;

	public Book() {
		super();
	}
	
	public Book(int bookID,Boolean check) {
		super();
		this.bookID = bookID;
		this.check = check;
	}
	
	public Book(int bookID, String bookName, String author,String publisher,double price,String ISBN) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.ISBN = ISBN;
	}
	
	public Book(int bookID, String bookName, String author,String publisher,double price,String ISBN,Boolean check) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.ISBN = ISBN;
		this.check = check;
	}
	
	public int getBID() {
		return bookID;
	}

	public void setBID(int bookID) {
		this.bookID = bookID;
	}

	public String getBname() {
		return bookName;
	}

	public void setBname(String bookName) {
		this.bookName = bookName;
	}

	public String getBauthor() {
		return author;
	}

	public void setBauthor(String author) {
		this.author = author;
	}

	public String getBpublisher() {
		return publisher;
	}

	public void setBpublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getBprice() {
		return price;
	}

	public void setBprice(double price) {
		this.price = price;
	}

	public String getBISBN() {
		return ISBN;
	}

	public void setBISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Boolean getBcheck() {
		return check;
	}

	public void setBcheck(Boolean check) {
		this.check = check;
	}
}
