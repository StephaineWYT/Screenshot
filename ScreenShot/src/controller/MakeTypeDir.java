package controller;

import java.io.File;

import model.Strings;

public class MakeTypeDir {
	public static boolean mkDirectory(String path) {
		File file = null;
		try {
			file = new File(path);
			if (!file.exists()) {
				return file.mkdirs();
			} else {
				return false;
			}
		} catch (Exception e) {
		} finally {
			file = null;
		}
		return false;
	}

	public static void traverseType() {
		for (String typeStr : Strings.TYPES) {
			if (mkDirectory(Strings.getImageDir() + "\\" + typeStr)) {
				System.out.println("已建立" + typeStr);
			} else {
				System.out.println(typeStr + "建立失败！此目录已经存在！");
			}
		}
	}
}
