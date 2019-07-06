package model;

import java.io.File;
import java.util.ArrayList;

public class Strings {
	private static String imageDir;
	public static ArrayList<File> imagefileList;
	public final static String TYPE_1 = "type1";
	public final static String TYPE_2 = "type2";
	public final static String TYPE_3 = "type3";
	public final static String TYPE_4 = "type4";
	public final static String TYPE_5 = "type5";
	public final static String[] TYPES = new String[] { TYPE_1, TYPE_2, TYPE_3, TYPE_4, TYPE_5 };

	public static String getImageDir() {
		return imageDir;
	}

	public static void setImageDir(String imageDir) {
		Strings.imageDir = imageDir;
	}

}
