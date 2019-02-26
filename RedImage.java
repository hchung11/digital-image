import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RedImage {
    public static void main(String arg[])throws IOException
    {
        BufferedImage img = null;
        File f = null;
            try
            {
                //reading file
            f = new File("C:/Users/gustl/Downloads/Image/baba.jpg");
            img = ImageIO.read(f);
            }
                catch (IOException e)
                {
                System.out.println(e);
            }
            //get the width and hight pixle
            int width = img.getWidth();
            int hight = img.getHeight();

            //It 2D array so that need two for loop
            for (int y = 0; y <hight; y++ )
            {
                for (int x = 0; x<width; x++)
                {
                    //I think this is each every one pixel.
                    int p = img.getRGB(x,y);

                    int a = (p >>24)&0xff;

                    int r = (p >>16)&0xff;
                    int g = (p >>8)&0xff;

                    //if is i << x the lower the 'i' more consentrate the color
                    p = (a<<24) | (r<<16) |(0<<8) | 0;
                    img.setRGB(x,y,p);

                }
            }
            try
            {
                f = new File("C:/Users/gustl/Downloads/Image/red.jpg");
                ImageIO.write(img, "jpg", f);

            }
            catch (IOException e)
            {
                System.out.println(e);
            }
    }
}
