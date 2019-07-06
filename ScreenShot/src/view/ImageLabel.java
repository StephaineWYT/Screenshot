package view;

import javax.swing.JLabel;

import model.Nums;
import model.Strings;

public class ImageLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JLabel imgLbl;

	public ImageLabel() {
		initImgLbl();
		update();
	}

	public void initImgLbl() {
		imgLbl = new JLabel();
		imgLbl.setBounds(Nums.X_IMG_START, Nums.Y_IMG_START, Nums.IMG_WIDTH, Nums.IMG_HEIGHT);
		imgLbl.setOpaque(true);
	}

	public JLabel getImgLbl() {
		return imgLbl;
	}

	public static void update() {
		UpdateImage ui = new UpdateImage(String.valueOf(Strings.imagefileList.get(Nums.imagesCursor)));
		imgLbl.setIcon(ui.getUpdateImgIcon());
	}
}
