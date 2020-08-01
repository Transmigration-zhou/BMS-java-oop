package turn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddWindow;
import view.BorrowWindow;
import view.DeleteWindow;
import view.FindBookWindow;
import view.FindUserWindow;
import view.MainWindow;
import view.ModifyWindow;
import view.ReturnWindow;

public class Return implements ActionListener {
	MainWindow view;
	BorrowWindow view1;
	ReturnWindow view2;
	AddWindow view3;
	DeleteWindow view4;
	ModifyWindow view5;
	FindBookWindow view6;
	FindUserWindow view7;

	public void setView(MainWindow view) {
		this.view = view;
		this.view1 = null;
		this.view2 = null;
		this.view3 = null;
		this.view4 = null;
		this.view5 = null;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(BorrowWindow view) {
		this.view = null;
		this.view1 = view;
		this.view2 = null;
		this.view3 = null;
		this.view4 = null;
		this.view5 = null;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(ReturnWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = view;
		this.view3 = null;
		this.view4 = null;
		this.view5 = null;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(AddWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = null;
		this.view3 = view;
		this.view4 = null;
		this.view5 = null;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(DeleteWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = null;
		this.view3 = null;
		this.view4 = view;
		this.view5 = null;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(ModifyWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = null;
		this.view3 = null;
		this.view4 = null;
		this.view5 = view;
		this.view6 = null;
		this.view7 = null;
	}

	public void setView(FindBookWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = null;
		this.view3 = null;
		this.view4 = null;
		this.view5 = null;
		this.view6 = view;
		this.view7 = null;
	}

	public void setView(FindUserWindow view) {
		this.view = null;
		this.view1 = null;
		this.view2 = null;
		this.view3 = null;
		this.view4 = null;
		this.view5 = null;
		this.view6 = null;
		this.view7 = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (view != null) {
				view.setVisible(false);
			} else if (view1 != null) {
				view1.setVisible(false);
			} else if (view2 != null) {
				view2.setVisible(false);
			} else if (view3 != null) {
				view3.setVisible(false);
			} else if (view4 != null) {
				view4.setVisible(false);
			} else if (view5 != null) {
				view5.setVisible(false);
			} else if (view6 != null) {
				view6.setVisible(false);
			} else if (view7 != null) {
				view7.setVisible(false);
			}
			new ReturnWindow();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}