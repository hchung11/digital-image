
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class GetSetPicels {
    public static void main (String arg[]) throws IOException
    {
        BufferedImage img = null;
        File f = null;

        //read image
        try
        {
            f = new File("C:/Users/gustl/Downloads/Image/baba.jpg");
            img = ImageIO.read(f);
        }
        catch(IOException e)
        {
            System.out.println(e);

        }
        int width = img.getWidth();
        int hight = img.getHeight();

        //get alpha
        int p = img.getRGB(0, 0);
        //get alpha
        int a = (p>>24) & 0xff;
        //get red
        int r = (p>>16) & 0xff;
        // get green
        int g = (p>>8) & 0xff;
        // get blue
        int b =p & 0xff;

        //value for the color
        a = 255;
        r = 100;
        g = 150;
        b = 200;

        p = (a<<24) | (r<<16) |(g<<8) |b;
        img.setRGB(0,0,p);

        try
        {
            f = new File ("C:/Users/gustl/Downloads/Image/a.jpg");
            ImageIO.write(img,"JPG", f);
        }catch (IOException e){
            System.out.println(e);
        }

    }

}
