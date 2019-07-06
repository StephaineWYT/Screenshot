package utils;

import java.io.File;
import java.util.ArrayList;

import model.Strings;

public class CheckSubFolders {

	public static boolean typeFolderExists(String imageDir) {
		// 子文件夹的集合
		ArrayList<File> fileList = new ArrayList<File>();
		// 读取文件到集合
		File file = new File(imageDir);
		File[] subfiles = file.listFiles();
		for (File f : subfiles) {
			if (f.isDirectory()) {
				fileList.add(f);
			}
		}
		// 判断文件夹是否包含类别
		for (File f : subfiles) {
			String fileName = String.valueOf(f);
			if (fileName.contains(Strings.TYPE_1)) {
				return true;
			}
		}
		return false;
	}
}
