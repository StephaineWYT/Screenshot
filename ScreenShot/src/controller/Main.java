package controller;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Nums;
import model.Strings;
import utils.GetDefaultLocation;
import utils.CheckSubFolders;
import view.ChooseFileDir;
import view.Framework;

public class Main {
	public static void main(String[] args) {

		// 用户选择图片文件夹
		ChooseFileDir cfd = new ChooseFileDir(new GetDefaultLocation().getDesktopPath());
		String imageDir = cfd.choose();
		Strings.setImageDir(imageDir);

		// 读取文件夹目录下所有子文件
		if (readFiles(imageDir)) {

			// 显示截图页面
			new Framework().showInterface();

			// 判断是否已经存在类型的子文件夹不存在则新建
			if (!CheckSubFolders.typeFolderExists(imageDir)) {
				new MakeTypeDir();
				MakeTypeDir.traverseType();
			}
		}
	}

	public static boolean readFiles(String imageDir) {
		Strings.imagefileList = new ArrayList<File>();
		File fileDir = new File(imageDir);
		File[] files = fileDir.listFiles();
		if (files == null) {
			JOptionPane.showMessageDialog(null, "指定的图片文件不存在!", "错误信息", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for (File f : files) {
			if (f.isFile() && !f.isDirectory()) {
				Strings.imagefileList.add(f);
				Nums.imagesCount++;
			}
		}
		return true;
	}

}
