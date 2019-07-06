package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Nums;
import view.ImageLabel;
import view.ProgressLabel;

public class BtnPreListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (0 < Nums.imagesCursor) {
			Nums.imagesCursor = Nums.imagesCursor - 1;
			// 进度条刷新
			ProgressLabel.getProgress().setText((Nums.imagesCursor + 1) + " / " + Nums.imagesCount);
			// 图片刷新
			ImageLabel.update();
		} else {
			JOptionPane.showMessageDialog(null, "第一张!", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
