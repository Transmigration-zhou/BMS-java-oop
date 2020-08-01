package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import dao.BookDao;
import model.Book;
import turn.Borrow;
import turn.Delete;
import turn.FindBook;
import turn.FindUser;
import turn.Modify;
import turn.Return;
import util.CreatecdIcon;
import util.DBUtil;

/**
 * <p>Title: AddWindow</p>
 * <p>Description: 添加图书窗口</p>
 * @author Transmirgration_zhou
 * @date 2020年6月26日
 */
@SuppressWarnings("serial")
public class AddWindow extends JFrame {
	JMenuBar menubar;
	JMenu menu, Borrow, Information, Find;
	JMenuItem Borrow2, back, add1, delete, modify, find_Book, find_User;
	JLabel ID1, name1, author1, money1, ISBN1, Publishing1;
	JTextField ID2, name2, author2, money2, ISBN2, Publishing2;
	JButton add;

	public AddWindow() {
		init();
		setVisible(true);
		setBounds(400, 150, 300, 400);
		setTitle("图书管理系统-添加图书信息");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("deprecation")
	void init() {
		menubar = new JMenuBar();// 菜单栏

		Borrow = new JMenu("图书借阅");
		Information = new JMenu();
		Find = new JMenu("查找");

		ImageIcon logo1 = CreatecdIcon.add("res/borrow.png");
		Borrow.setIcon(logo1);
		Borrow.setPreferredSize(new Dimension(90, 25));
		Borrow.setText("图书借阅");

		ImageIcon logo2 = CreatecdIcon.add("res/BookInformation.png");
		Information.setIcon(logo2);
		Information.setPreferredSize(new Dimension(90, 25));
		Information.setText("图书信息");

		ImageIcon logo3 = CreatecdIcon.add("res/find.png");
		Find.setIcon(logo3);
		Find.setPreferredSize(new Dimension(90, 25));
		Find.setText("查找");

		Borrow2 = new JMenuItem("借阅信息");
		back = new JMenuItem("归还图书");

		add1 = new JMenuItem("增加图书");
		delete = new JMenuItem("删除图书");
		modify = new JMenuItem("修改图书");

		find_Book = new JMenuItem("查找书籍");
		find_User = new JMenuItem("查找用户");

		Borrow2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		back.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		add1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		modify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_MASK));
		find_Book.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.CTRL_MASK));
		find_User.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.CTRL_MASK));

		Borrow.add(Borrow2);
		Borrow.addSeparator();
		Borrow.add(back);

		Information.add(add1);
		Information.add(delete);
		Information.add(modify);

		Find.add(find_Book);
		Find.add(find_User);

		menubar.add(Borrow);
		menubar.add(Information);
		menubar.add(Find);

		setJMenuBar(menubar);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		ID1 = new JLabel("ID:");
		name1 = new JLabel("书名:");
		author1 = new JLabel("作者:");
		Publishing1 = new JLabel("出版社:");
		ISBN1 = new JLabel("ISBN:");
		money1 = new JLabel("金额:");
		ID2 = new JTextField();
		author2 = new JTextField();
		Publishing2 = new JTextField();
		ISBN2 = new JTextField();
		name2 = new JTextField();
		money2 = new JTextField();
		add = new JButton("添加");
		this.getRootPane().setDefaultButton(add);

		panel.add(ID1);
		panel.add(name1);
		panel.add(author1);
		panel.add(Publishing1);
		panel.add(ISBN1);
		panel.add(money1);

		panel.add(ID2);
		panel.add(name2);
		panel.add(author2);
		panel.add(Publishing2);
		panel.add(ISBN2);
		panel.add(money2);

		panel.add(add);
		ID1.setBounds(50, 30, 50, 50);
		name1.setBounds(50, 60, 50, 50);
		author1.setBounds(50, 90, 50, 50);
		Publishing1.setBounds(50, 120, 50, 50);
		money1.setBounds(50, 150, 50, 50);
		ISBN1.setBounds(50, 180, 50, 50);

		ID2.setBounds(100, 40, 100, 25);
		name2.setBounds(100, 70, 100, 25);
		author2.setBounds(100, 100, 100, 25);
		Publishing2.setBounds(100, 130, 100, 25);
		money2.setBounds(100, 160, 100, 25);
		ISBN2.setBounds(100, 190, 100, 25);

		add.setBounds(75, 250, 100, 40);
		getContentPane().add(panel);

		Add add2 = new Add();
		add2.setView(this);
		add.addActionListener(add2);

		Borrow turn1 = new Borrow();
		turn1.setView(this);
		Borrow2.addActionListener(turn1);
		Return turn2 = new Return();
		turn2.setView(this);
		back.addActionListener(turn2);
		Add turn3 = new Add();
		turn3.setView(this);
		add1.addActionListener(turn3);
		Delete turn4 = new Delete();
		turn4.setView(this);
		delete.addActionListener(turn4);
		Modify turn5 = new Modify();
		turn5.setView(this);
		modify.addActionListener(turn5);
		FindBook turn6 = new FindBook();
		turn6.setView(this);
		find_Book.addActionListener(turn6);
		FindUser turn7 = new FindUser();
		turn7.setView(this);
		find_User.addActionListener(turn7);
	}

	private class Add implements ActionListener {
		AddWindow view;

		public void setView(AddWindow view) {
			this.view = view;
		}

		public void actionPerformed(ActionEvent e) {
			String ID = view.ID2.getText();
			String BookName = view.name2.getText();
			String Author = view.author2.getText();
			String Publishing = view.Publishing2.getText();
			String Money = view.money2.getText();
			String ISBN = view.ISBN2.getText();
			BookDao bookDao = new BookDao();
			try {
				if (ID.equals("") || BookName.equals("") || Author.equals("") || Publishing.equals("")
						|| Money.equals("") || ISBN.length() != 13) {
					JOptionPane.showMessageDialog(null, "输入格式有误！");
				} else {
					Book book = new Book(Integer.parseInt(ID), BookName, Author, Publishing, Double.parseDouble(Money),
							ISBN, false);
					Connection con = DBUtil.getCon();
					bookDao.insert(con, book);
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "添加失败！");
				e1.printStackTrace();
			}
		}
	}
}