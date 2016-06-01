package ko.school.schoolmanage.domain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtil {
    
    public static final int SAME = -1;
    public static final int RATIO = 0;
                                            //원본이미지와 , 썸네일 이미지 
    public static void resize(File src, File dest, 
                              int width, int height) throws IOException {
        FileInputStream srcIs = null;
        try {
            srcIs = new FileInputStream(src);
            ImageUtil.resize(srcIs, dest, width, height);
        } finally {
            if (srcIs != null) try { srcIs.close(); } catch(IOException ex) {}
        }
    }

    public static void resize(InputStream src, File dest, 
                              int width, int height) throws IOException {
        BufferedImage srcImg = ImageIO.read(src);
        
        int destWidth = 300, destHeight = 300;
        
        BufferedImage destImg = new BufferedImage(
             destWidth, destHeight, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = destImg.createGraphics();
        g.drawImage(srcImg, 0, 0, destWidth, destHeight, null);
        
        ImageIO.write(destImg, "jpg", dest);
    }
    
    
    
}









