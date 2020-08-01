package model;
/**
 * <p>Title: User</p>
 * <p>Description: 用户实体</p>
 * @author Transmirgration_zhou
 * @date 2020年6月29日
 */
public class User {
	private int id;
	private String userName;
	private String phone;
	private String identity;
	private int number;
	private String book = "";

	public User(int id, int number, String book) {
		super();
		this.id = id;
		this.number = number;
		this.book = this.book + book + " ";
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
}
