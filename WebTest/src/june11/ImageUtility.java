package june11;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtility {
	
	public static final int SAME = -1, RATIO = 0;
	
	public static void resize(File src, File dest, int width, int height) throws IOException {
		
		FileInputStream srcIs = null;
		srcIs = new FileInputStream(src);
		ImageUtility.resize(srcIs, dest, width, height);
		
		if(srcIs != null) srcIs.close();
		
	}
	
	public static void resize(InputStream src, File dest, int width, int height) throws IOException {
		
		BufferedImage srcImage = ImageIO.read(src);
		
		int srcWidth = srcImage.getWidth();
		int srcHeight = srcImage.getHeight();
		int destWidth = -1;
		int destHeight = -1;
		
		if(width == SAME) {
			destWidth = srcWidth;
		}else if(width > 0) {
			destWidth = width;
		}
		
		if(height == SAME) {
			destHeight = srcHeight;
		}else if(height > 0) {
			destHeight = height;
		}
		
		if(width == RATIO && height == RATIO) {
			destWidth = srcWidth;
			destHeight = srcHeight;
		}else if(width == RATIO) {
			double ratio = (double)destHeight/(double)srcHeight;
			destWidth = (int)((double)srcWidth * ratio);
		}else if(height == RATIO) {
			double ratio = (double)destWidth/(double)srcWidth;
			destHeight = (int)((double)srcHeight * ratio);
		}
		
		BufferedImage destImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = destImage.createGraphics();
		g2.drawImage(srcImage, 0, 0, destWidth, destHeight, null);
		File newFile = dest.getParentFile();
		newFile.mkdir();
		
		String extName = String.valueOf(dest);
		int extNumber = extName.lastIndexOf(".");
		extName = extName.substring(extNumber + 1);
		ImageIO.write(destImage, extName, dest);
		
	}
	
}
