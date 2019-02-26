//2.20.2019i
import  java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImage {
    public static void main(String arg[])throws IOException{
        //width of the image
        int width = 963;
        //height of the image
        int height = 640;

        BufferedImage image = null;

        try{
            //put image in to valuable
            File input_file = new File("C:/Users/gustl/Downloads/Image/logo_no_google.jpg");

            //useing BufferedImage to change image --> Alpha,Red, Green and Blue component
            // of the image Gray.
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);

            image = ImageIO.read(input_file);
            System.out.println("Reding compulete.");

        }catch (IOException e){
            System.out.println("Error: " +e);
        }

        try{
            //initlize the new file in to output_file
            File output_file = new File("C:/Users/gustl/Downloads/Image/First_file_t.jpg");
            //changeing image into the output_file
            ImageIO.write(image, "jpg", output_file);

            System.out.println("Writing complet. ");

        }catch (IOException e){
            System.out.println("Error: " +e);
        }

    }
}
