package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JWindow;

public class ToolsWindow extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScreenShotWindow parent;

	public ToolsWindow(ScreenShotWindow parent, int x, int y) {
		this.parent = parent;
		this.init();
		this.setLocation(x, y);
		this.pack();
		this.setVisible(true);
	}

	private void init() {

		this.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar("Java 截图");

		// 保存按钮
		JButton saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					parent.saveImage();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(saveButton);

		// 关闭按钮
		JButton closeButton = new JButton("退出");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "截图已取消", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		toolBar.add(closeButton);

		this.add(toolBar, BorderLayout.NORTH);
	}
}