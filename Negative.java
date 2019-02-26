import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Negative {
    public static void main (String ars[])throws IOException
    {
        BufferedImage img = img = null;
        File f = null;

        try
        {
            f = new File ("C:/Users/gustl/Downloads/Image/baba.jpg");
            img = ImageIO.read(f);

        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y++)
        {
            for(int x =0; x <width; x++)
            {
                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //subtract RGB from 255
                //change to the 255 - color will change to opposite
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a<<24) | (r<<16) | (g<<8)| b;
                img.setRGB(x,y,p);
            }
        }
        try
        {
            f = new File("C:/Users/gustl/Downloads/Image/Negative.jpg");
            ImageIO.write(img, "JPG", f);

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
