package view;

import javax.swing.JButton;

import model.Nums;

public class Buttons extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JButton btnPre;
	private static JButton btnShot;
	private static JButton btnNext;

	public Buttons() {
		initButtons();
	}

	public void initButtons() {
		btnPre = new JButton("上一张");
		btnPre.setLayout(null);
		btnPre.setBounds(0, Nums.Y_BUTTON_START, Nums.BUTTON_WIDTH, Nums.BUTTON_HEIGHT);
		controller.BtnPreListener btnPreListener = new controller.BtnPreListener();
		btnPre.addActionListener(btnPreListener);

		btnShot = new JButton("截图");
		btnShot.setLayout(null);
		btnShot.setBounds(220, Nums.Y_BUTTON_START, Nums.BUTTON_WIDTH, Nums.BUTTON_HEIGHT);
		controller.BtnShotListener btnShotListener = new controller.BtnShotListener();
		btnShot.addActionListener(btnShotListener);

		btnNext = new JButton("下一张");
		btnNext.setLayout(null);
		btnNext.setBounds(420, Nums.Y_BUTTON_START, Nums.BUTTON_WIDTH, Nums.BUTTON_HEIGHT);
		controller.BtnNextListener btnNextListener = new controller.BtnNextListener();
		btnNext.addActionListener(btnNextListener);
	}

	public JButton getBtnPre() {
		return btnPre;
	}

	public JButton getBtnShot() {
		return btnShot;
	}

	public JButton getBtnNext() {
		return btnNext;
	}
}
