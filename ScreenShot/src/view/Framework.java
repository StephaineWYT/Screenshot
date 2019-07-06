package view;

import javax.swing.JFrame;

import model.Nums;

public class Framework extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 根据文件夹显示图片
	public void showInterface() {
		setBackground();
	}

	public void setBackground() {
		JFrame f = new JFrame("图片截图");
		ImageLabel ib = new ImageLabel();
		f.setLayout(null);
		f.setBounds(Nums.X_START, Nums.Y_START, Nums.SCREEN_WIDTH, Nums.SCREEN_HEIGHT);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.add(ib.getImgLbl());
		f.add(new OpLabel());
		f.setVisible(true);
	}
}