package view;

import javax.swing.JFileChooser;

public class ChooseFileDir {

	private String desktopPath;

	public ChooseFileDir(String desktopPath) {
		this.desktopPath = desktopPath;
	}

	public String choose() {
		String imgFileDir = null;
		JFileChooser fileChooser = new JFileChooser(desktopPath);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnFlag = fileChooser.showOpenDialog(fileChooser);
		if (returnFlag == JFileChooser.APPROVE_OPTION) {
			imgFileDir = fileChooser.getSelectedFile().getAbsolutePath();
		}
		return imgFileDir;
	}
}
