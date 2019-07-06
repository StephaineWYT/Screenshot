package view;

import javax.swing.JLabel;

import model.Nums;

public class OpLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpLabel() {
		setPosition();
		addButtons();
		addProgressLabel();
	}

	public void setPosition() {
		this.setBounds(Nums.X_OP_START, Nums.IMG_HEIGHT, Nums.OP_WIDTH, Nums.OP_HEIGHT);
		this.setOpaque(true);
	}

	public void addButtons() {
		Buttons buttons = new Buttons();
		this.add(buttons.getBtnPre());
		this.add(buttons.getBtnShot());
		this.add(buttons.getBtnNext());
	}

	@SuppressWarnings("static-access")
	public void addProgressLabel() {
		this.add(new ProgressLabel().getProgress());
	}

}
