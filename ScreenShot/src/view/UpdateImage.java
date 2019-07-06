package view;

import java.io.File;

import javax.swing.ImageIcon;

import model.Nums;
import utils.ImageUtils;

public class UpdateImage {

	// 图片的具体路径
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public UpdateImage(String imagePath) {
		this.imagePath = imagePath;
	}

	public ImageIcon getUpdateImgIcon() {
		File file = new File(imagePath);
		ImageIcon icon = new ImageIcon(imagePath);
		icon.setImage(ImageUtils.getScaleImage(file, Nums.IMG_WIDTH, Nums.IMG_HEIGHT));
		return icon;
	}
}
