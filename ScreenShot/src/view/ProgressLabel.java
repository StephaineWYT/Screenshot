package view;

import javax.swing.JLabel;

import model.Nums;

public class ProgressLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JLabel numLbl;

	public ProgressLabel() {
		setImageNums();
	}

	public void setImageNums() {
		numLbl = new JLabel();
		numLbl.setText((Nums.imagesCursor + 1) + " / " + Nums.imagesCount);
		numLbl.setBounds(250, Nums.Y_PROGRESS_START, Nums.BUTTON_WIDTH, Nums.BUTTON_HEIGHT);
	}

	public static JLabel getProgress() {
		return numLbl;
	}
}
