package utils;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class GetDefaultLocation {
	// 获取桌面路径
	FileSystemView fsv = FileSystemView.getFileSystemView();
	File fileDir = fsv.getHomeDirectory();
	String desktopPath = fileDir.getPath();

	public String getDesktopPath() {
		return desktopPath;
	}
}
