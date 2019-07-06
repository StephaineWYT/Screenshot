package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageUtils {
	/**
	 * @param file    图片文件的File对象
	 * @param targetW 缩放的目标宽度
	 * @param targetH 缩放的目标高度
	 * @return Image 从文件中读取的并进行缩放后的Image对象
	 */
	public static Image getScaleImage(File file, int targetW, int targetH) {
		if (!file.exists()) {
			JOptionPane.showMessageDialog(null, "指定的图片文件不存在!", "错误信息", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try {
			BufferedImage source = ImageIO.read(file);
			// targetW，targetH分别表示目标长和宽
			int type = source.getType();
			BufferedImage target = null;
			double sx = (double) targetW / source.getWidth();
			double sy = (double) targetH / source.getHeight();

			// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
			// 则将下面的if else语句注释即可
			if (sx > sy) {
				sx = sy;
				targetW = (int) (sx * source.getWidth());
			} else {
				sy = sx;
				targetH = (int) (sy * source.getHeight());
			}

			if (type == BufferedImage.TYPE_CUSTOM) { 
				ColorModel cm = source.getColorModel();
				WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
				boolean alphaPremultiplied = cm.isAlphaPremultiplied();
				target = new BufferedImage(cm, raster, alphaPremultiplied, null);
			} else
				target = new BufferedImage(targetW, targetH, type);
			Graphics2D g = target.createGraphics();
			// smoother than exlax:
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
			g.dispose();
			File obj = new File("临时");
			ImageIO.write(target, "JPG", obj);
			Image image = getImage(obj);
			obj.delete();
			return image;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件读取错误!", "错误信息", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public static Image getImage(File file) {
		if (!file.exists()) {
			JOptionPane.showMessageDialog(null, "指定的图片文件不存在!", "错误信息", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Image image;
		try {
			FileInputStream fis = new FileInputStream(file);
			image = getImage(fis);
			fis.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件读取错误!", "错误信息", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return image;
	}

	private static Image getImage(InputStream is) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte buf[] = new byte[1024 * 4];
			while (true) {
				int n = is.read(buf);
				if (n == -1)
					break;
				baos.write(buf, 0, n);
			}
			baos.close();
			return Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
		} catch (Throwable e) {
			return null;
		}
	}
}
