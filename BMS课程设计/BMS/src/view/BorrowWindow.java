package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import dao.BookDao;
import dao.BorrowReturnDao;
import model.Book;
import model.User;
import turn.Add;
import turn.Delete;
import turn.FindBook;
import turn.FindUser;
import turn.Modify;
import turn.Return;
import util.CreatecdIcon;
import util.DBUtil;

/**
 * <p>Title: BorrowWindow</p>
 * <p>Description: 借书窗口</p>
 * @author Transmirgration_zhou
 * @date 2020年6月26日
 */
@SuppressWarnings("serial")
public class BorrowWindow extends JFrame {
	JMenuBar menubar;
	JMenu menu, Borrow, Information, Find;
	JMenuItem Borrow2, back, add1, delete, modify, find_Book, find_User;
	JLabel Book1, User1;
	JTextField Book2, User2;
	JButton sure;
	Box baseBox, boxv1, boxv2;

	public BorrowWindow() {
		init();
		setVisible(true);
		setBounds(600, 300, 500, 150);
		setTitle("图书管理系统-图书借阅");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings({ "deprecation" })
	void init() {
		setLayout(new FlowLayout());

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

		/**
		 * 添加组件连接数据库，显示书籍情况。
		 */
		Book1 = new JLabel("图书ID  ");
		Book2 = new JTextField(10);
		add(Book1);
		add(Book2);

		User1 = new JLabel("借书人ID  ");
		User2 = new JTextField(10);
		add(User1);
		add(User2);

		sure = new JButton("确认");
		Borrow borrow = new Borrow();
		borrow.setView(this);
		sure.addActionListener(borrow);
		this.getRootPane().setDefaultButton(sure);
		add(sure);

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
	
	private class Borrow implements ActionListener {
		BorrowWindow view;

		public void setView(BorrowWindow view) {
			this.view = view;
		}

		public void actionPerformed(ActionEvent e) {
			String book = view.Book2.getText();
			String user = view.User2.getText();
			BookDao bookDao = new BookDao();
			BorrowReturnDao Dao = new BorrowReturnDao();
			try {
				if (book.equals("") || user.equals("") ) {
					JOptionPane.showMessageDialog(null, "输入不能为空！！");
				} else {
					Connection con = DBUtil.getCon();
					List<Book> booklist = bookDao.selectID(con, book);
					Book book0 = booklist.get(0);
					if(book0.getBcheck()==true) {
						JOptionPane.showMessageDialog(null, "此书已被借阅！");
					}
					else {
						Book book1 = new Book(Integer.parseInt(book), true);
						User user1 = new User(Integer.parseInt(user), 1 , book);
						Dao.borrow(con, book1, user1);
						JOptionPane.showMessageDialog(null, "借书成功！");
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "借书失败！");
				e1.printStackTrace();
			}
		}
	}
}