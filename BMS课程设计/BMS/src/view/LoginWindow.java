package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.CreatecdIcon;

/**
 * <p>Title: Login</p>
 * <p>Description: 登录界面</p>
 * @author Transmirgration_zhou
 * @date 2020年6月25日
 */
@SuppressWarnings("serial")
public class LoginWindow extends JFrame {
	public JTextField account;
	JLabel account1, password1;
	public JLabel label1;
	public JPasswordField password;
	JButton login1, login2;
	JPanel jp1, jp2, jp3, jp4;
	Box baseBox, boxv1, boxv2;

	public LoginWindow() {
		init();
		setBounds(600, 300, 425, 250);
		setTitle("图书管理系统登录界面");
		setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		setLayout(new FlowLayout());
		account1 = new JLabel("            账号：");
		account = new JTextField(25);
		password1 = new JLabel("            密码：");
		password = new JPasswordField(25);

		final JLabel logoLabel = new JLabel();
		ImageIcon bookTypeModiAndDelIcon = CreatecdIcon.add("res/picture.png");
		logoLabel.setIcon(bookTypeModiAndDelIcon);
		logoLabel.setPreferredSize(new Dimension(400, 80));
		logoLabel.setText("logo");
		add(logoLabel);

		boxv1 = Box.createVerticalBox();
		boxv1.add(account1);
		boxv1.add(password1);
		boxv2 = Box.createVerticalBox();
		boxv2.add(account);
		boxv2.add(password);
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxv1);
		baseBox.add(boxv2);
		add(baseBox);

		label1 = new JLabel("                     ");
		add(label1);

		login1 = new JButton("登录");
		Dimension preferredSize1 = new Dimension(100, 30);
		login1.setPreferredSize(preferredSize1);
		turn turn1 = new turn();
		turn1.setView(this);
		login1.addActionListener(turn1);
		add(login1);
		this.getRootPane().setDefaultButton(login1);
	}

	private class turn implements ActionListener {
		LoginWindow view;

		public void setView(LoginWindow view) {
			this.view = view;
		}

		public void actionPerformed(ActionEvent e) {
			String account = view.account.getText();
			@SuppressWarnings("deprecation")
			String password = view.password.getText();
			try {
				if (account.equals("admin") && password.equals("admin")) {
					view.setVisible(false); // 隐藏主界面
					@SuppressWarnings("unused")
					MainWindow mainWindow = new MainWindow();
				} else if (account.equals("")) {
					view.label1.setText("账号不能为空");
					view.label1.setForeground(Color.RED);
				} else if (password.equals("")) {
					view.label1.setText("密码不能为空");
					view.label1.setForeground(Color.RED);
				} else {
					view.label1.setText("账号或者密码错误");
					view.label1.setForeground(Color.RED);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
