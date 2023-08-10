
import com.course.swing.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ivan
 */
public class test {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Ivan\\Desktop\\testpicture\\pic.png"));
String blurhashStr = BlurHash.encode(image); 
            System.out.println(blurhashStr);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
