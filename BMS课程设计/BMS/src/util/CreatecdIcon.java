package util;

import java.net.URL;

import javax.swing.ImageIcon;

import view.LoginWindow;

/**
 * <p>Title: CreatecdIcon</p>
 * <p>Description: 指定路径加载图片</p>
 * @author Transmirgration_zhou
 * @date 2020年6月8日
 */
public class CreatecdIcon {
	public static ImageIcon add(String ImageName) {
		URL IconUrl = LoginWindow.class.getResource("/"+ImageName);
		ImageIcon icon= new ImageIcon(IconUrl);	
		return icon;
	}
}
