package controller;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnShotListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					ScreenShotWindow ssw = new ScreenShotWindow();
					ssw.setVisible(true);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
