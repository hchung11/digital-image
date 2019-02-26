import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Grayscale
{
    public static void main(String args[])throws IOException
    {
        BufferedImage img = null;
        File f = null;

        // read image 
        try
        {
            f = new File("C:/Users/gustl/Downloads/Image/baba.jpg");
            img = ImageIO.read(f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        // width(가로, 세로)
        int width = img.getWidth();
        int height = img.getHeight();

        // convert to greyscale
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                // Here (x,y)denotes the coordinate of image  
                // for modifying the pixel value. 
                int p = img.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                /** calculate average
                 왜? **/
                int avg = (r+g+b)/3;

                // replace RGB value with avg 
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                //now reset the img
                img.setRGB(x, y, p);
            }
        }

        // write image 
        try
        {
            f = new File("C:/Users/gustl/Downloads/Image/gray.jpg");
            ImageIO.write(img, "jpg", f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
} 