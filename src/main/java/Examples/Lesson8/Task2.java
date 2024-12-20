package Examples.Lesson8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.util.Random;
import javax.swing.JFrame;
public class Task2 extends JFrame {
    private static final long serialVersionUID = 1L;
    //Размер создаваемого тзображения
    private int w = 1000;
    private int h = 1000;
    //Массив для создания изображения
    private int[] pix = new int[w * h];
    private Image img;

    Task2(String s) {
        super(s);
//Запоняем массив для изображения
        int i = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int red = new Random().nextInt(0,255);
                int green = new Random().nextInt(0,255);
                int blue = new Random().nextInt(0,255);
                pix[i++] = (255 << 24) | (red << 16) | (green << 8) | blue;
            }
        }
        this.setSize(w, h);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        if (img == null)
            img = this.createImage(new MemoryImageSource(w, h, pix, 0, w));
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        new Task2("Изображение, созданное в памяти");
    }
}
