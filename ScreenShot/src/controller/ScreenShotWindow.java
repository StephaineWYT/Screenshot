package controller;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JWindow;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Strings;

public class ScreenShotWindow extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int startX, startY, endX, endY;
	private BufferedImage image = null;
	private BufferedImage tempImage = null;
	private BufferedImage savedImage = null;

	private ToolsWindow tools = null;

	public ScreenShotWindow() throws AWTException {
		// 获取屏幕尺寸
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, d.width, d.height);

		// 截取屏幕
		Robot robot = new Robot();
		image = robot.createScreenCapture(new Rectangle(0, 0, d.width, d.height));

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 鼠标点击时记录起始点坐标并隐藏操作窗口
				startX = e.getX();
				startY = e.getY();

				if (tools != null) {
					tools.setVisible(false);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// 鼠标松开时显示操作窗口
				if (tools == null) {
					tools = new ToolsWindow(ScreenShotWindow.this, e.getX(), e.getY());
				} else {
					tools.setLocation(e.getX(), e.getY());
				}
				tools.setVisible(true);
				tools.toFront();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// 鼠标拖动时记录坐标并重绘窗口
				endX = e.getX();
				endY = e.getY();

				// 临时图像用于缓冲屏幕区域放置屏幕闪烁
				Image tempImage2 = createImage(ScreenShotWindow.this.getWidth(), ScreenShotWindow.this.getHeight());
				Graphics g = tempImage2.getGraphics();
				g.drawImage(tempImage, 0, 0, null);
				int x = Math.min(startX, endX);
				int y = Math.min(startY, endY);
				int width = Math.abs(endX - startX) + 1;
				int height = Math.abs(endY - startY) + 1;
				// 防止width或height = 0
				g.setColor(Color.BLUE);
				g.drawRect(x - 1, y - 1, width + 1, height + 1);
				// 防止图片矩形框覆盖掉
				savedImage = image.getSubimage(x, y, width, height);
				g.drawImage(savedImage, x, y, null);

				ScreenShotWindow.this.getGraphics().drawImage(tempImage2, 0, 0, ScreenShotWindow.this);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		RescaleOp ro = new RescaleOp(0.8f, 0, null);
		tempImage = ro.filter(image, null);
		g.drawImage(tempImage, 0, 0, this);
	}

	// 保存图像到文件
	public void saveImage() throws IOException {
		// 自动定位到分类
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("保存");

		// 文件过滤器，用户过滤可选择文件
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png");
		jfc.setFileFilter(filter);

		// 初始化一个默认文件（此文件会生成到桌面上）
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String fileName = sdf.format(new Date());
		// File filePath = FileSystemView.getFileSystemView().getHomeDirectory();
		File categoryFilePath = new File(Strings.getImageDir());
		File defaultFile = new File(categoryFilePath + File.separator + fileName + ".png");
		jfc.setSelectedFile(defaultFile);

		int flag = jfc.showSaveDialog(this);
		if (flag == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			String path = file.getPath();
			// 检查文件后缀防止用户忘记输入后缀或者输入不正确的后缀
			if (!(path.endsWith(".png") || path.endsWith(".PNG"))) {
				path += ".png";
			}
			// 写入文件
			ImageIO.write(savedImage, "png", new File(path));
		}
	}
}