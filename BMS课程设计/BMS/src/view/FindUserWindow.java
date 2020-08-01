package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import dao.UserDao;
import model.User;
import turn.Add;
import turn.Borrow;
import turn.Delete;
import turn.FindBook;
import turn.Modify;
import turn.Return;
import util.CreatecdIcon;
import util.DBUtil;

/**
 * <p>Title: FindUserWindow</p>
 * <p>Description: 查找用戶窗口</p>
 * @author Transmirgration_zhou
 * @date 2020年6月29日
 */
@SuppressWarnings("serial")
public class FindUserWindow extends JFrame {
	JMenuBar menubar;
	JMenu menu, Borrow, Information, Find;
	JMenuItem Borrow2, back, add1, delete, modify, find_Book, find_User;
	JLabel find, findname;
	JTextField find2, findname2;
	JButton find3;
	JTable table;
	Object[][] a = new Object[1][6];
	Object name[] = { "ID", "姓名", "电话", "身份证", "已借书数量", "书籍名称" };

	public FindUserWindow() {
		init();
		setVisible(true);
		setBounds(300, 100, 900, 500);
		setTitle("图书管理系统-查找用户");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("deprecation")
	void init() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
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

		table = new JTable(a, name);
		table.setForeground(Color.BLACK); // 字体颜色
		table.setFont(new Font(null, Font.PLAIN, 14));
		table.setSelectionForeground(Color.DARK_GRAY); // 选中后字体颜色
		table.setSelectionBackground(Color.LIGHT_GRAY); // 选中后字体背景
		table.setGridColor(Color.GRAY); // 网格颜色
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 15)); // 表头名称字体样式
		table.getTableHeader().setForeground(Color.BLUE); // 表头名称字体颜色
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.setPreferredScrollableViewportSize(new Dimension(450, 300));
		table.setBounds(10, 10, 800, 50);
		JScrollPane JSP = new JScrollPane(table);
		panel.add(JSP);
		JSP.setBounds(50, 10, 800, 60);

		find = new JLabel("查找用户id:");
		findname = new JLabel("查找用户姓名");
		find2 = new JTextField();
		findname2 = new JTextField();
		find3 = new JButton("查询");
		panel.add(find);
		panel.add(findname);
		panel.add(find2);
		panel.add(findname2);
		panel.add(find3);
		find.setBounds(250, 300, 70, 50);
		findname.setBounds(250, 250, 70, 50);
		find2.setBounds(330, 310, 150, 30);
		findname2.setBounds(330, 260, 150, 30);
		find3.setBounds(500, 285, 110, 30);
		this.getRootPane().setDefaultButton(find3);
		FindUser FindUser = new FindUser();
		FindUser.setView(this);
		find3.addActionListener(FindUser);
		getContentPane().add(panel);

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

	private class FindUser implements ActionListener {
		FindUserWindow view;

		public void setView(FindUserWindow view) {
			this.view = view;
		}

		public void actionPerformed(ActionEvent e) {
			String UserName = view.findname2.getText();
			String UserID = view.find2.getText();
			UserDao userDao = new UserDao();

			/**
			 * 清空列表
			 */
			for (int i = 0; i < table.getRowCount(); i++) {
				a[i][0] = "";
				a[i][1] = "";
				a[i][2] = "";
				a[i][3] = "";
				a[i][4] = "";
				a[i][5] = "";
			}
			try {
				if (UserName.equals("") && UserID.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入查找信息！");
				} else if (UserID.equals("")) {
					Connection con = DBUtil.getCon();
					List<User> userlist = userDao.selectUserName(con, UserName);
					if (userlist.size() == 0) {
						JOptionPane.showMessageDialog(null, "查找不到相关信息！");
					} else {
						for (int i = 0; i < userlist.size(); i++) {
							User user = userlist.get(i);
							a[i][0] = user.getId();
							a[i][1] = user.getUserName();
							a[i][2] = user.getPhone();
							a[i][3] = user.getIdentity();
							a[i][4] = user.getNumber();
							a[i][5] = user.getBook();
						}
					}
				} else if (UserName.equals("")) {
					Connection con = DBUtil.getCon();
					List<User> userlist = userDao.selectUserID(con, Integer.parseInt(UserID));
					if (userlist.size() == 0) {
						JOptionPane.showMessageDialog(null, "查找不到相关信息！");
					} else {
						for (int i = 0; i < userlist.size(); i++) {
							User user = userlist.get(i);
							a[i][0] = user.getId();
							a[i][1] = user.getUserName();
							a[i][2] = user.getPhone();
							a[i][3] = user.getIdentity();
							a[i][4] = user.getNumber();
							a[i][5] = user.getBook();
						}
					}
				} else {
					Connection con = DBUtil.getCon();
					List<User> userlist = userDao.selectUser(con, UserName, Integer.parseInt(UserID));
					if (userlist.size() == 0) {
						JOptionPane.showMessageDialog(null, "查找不到相关信息！");
					} else {
						for (int i = 0; i < userlist.size(); i++) {
							User user = userlist.get(i);
							a[i][0] = user.getId();
							a[i][1] = user.getUserName();
							a[i][2] = user.getPhone();
							a[i][3] = user.getIdentity();
							a[i][4] = user.getNumber();
							a[i][5] = user.getBook();
						}
					}
				}
				view.repaint();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "查找失败！");
				e1.printStackTrace();
			}
		}
	}
}