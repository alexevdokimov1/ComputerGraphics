package Examples.Lesson8;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Task8
{
    public static void main( String[] args )
    {
        BufferedImage image = null;
        try {
            URL url = new URL("https://cs11.pikabu.ru/post_img/2019/02/04/12/1549312329147951618.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int w = image.getWidth();
        int h = image.getHeight();

        JFrame frame = new JFrame("Фотография котиков");
        frame.setSize(w, h);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.RED);
        int diameter = 50; // Диаметр круга
        graphics.fillOval((w - diameter) / 2, (h - diameter) / 2, diameter, diameter);
        graphics.dispose();
        File outputfile = new File("images/saved.png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
