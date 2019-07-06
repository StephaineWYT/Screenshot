package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Nums;
import view.ImageLabel;
import view.ProgressLabel;

public class BtnNextListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Nums.imagesCursor < Nums.imagesCount - 1) {
			Nums.imagesCursor++;
			// 进度条刷新
			ProgressLabel.getProgress().setText((Nums.imagesCursor + 1) + " / " + Nums.imagesCount);
			// 图片刷新
			ImageLabel.update();
		} else {
			JOptionPane.showMessageDialog(null, "最后一张!", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
