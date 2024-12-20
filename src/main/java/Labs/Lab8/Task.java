package Labs.Lab8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Task extends Frame{
    private BufferedImage bi;

    final float[] wl = {
            1.f/16, 2.f/16, 1.f/16,
            2f/16, 4f/16, 2f/16,
            1f/16, 2f/16, 1f/16 };

    final float[] wl2 = {
            -0.5f, -0.5f, -0.5f,
            -0.5f,  5.0f, -0.5f,
            -0.5f, -0.5f, -0.5f };

    final float[] wl3 = {
            -2f, -1f, -0f,
            -1f,  1f,  1f,
            0f,  1f,  2f };


    // Конструктор
    public Task(String s) {
        super (s) ;
        URL url = null;
        // Адрес изображения на сайте РГРТУ
        try {
            url = new
                    URL("https://cs11.pikabu.ru/post_img/2019/02/04/12/1549312329147951618.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // Создаем объект BufferedImage
        bi = new BufferedImage(img.getWidth(null),
                img.getHeight(null),BufferedImage.TYPE_INT_RGB);
// Выводим
        Graphics2D big = bi.createGraphics();
        big.drawImage(img, 0, 0, this);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        int w = this.getSize().width;
        int bw = bi.getWidth(null);
        int bh = bi.getHeight(null);
        BufferedImage bimg = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg2 = new BufferedImage(bw,bh,BufferedImage.TYPE_INT_RGB);
        //Матрица фильтра размытия для ядра свёртки

        Kernel kernel = new Kernel(3, 3, wl);
        Kernel kernel2 = new Kernel(3, 3, wl2);
        Kernel kernel3 = new Kernel(3, 3, wl3);
        // Обънкт ConvolveOp
        ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop2 = new ConvolveOp(kernel2, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop3 = new ConvolveOp(kernel3, ConvolveOp.EDGE_NO_OP, null);

        BufferedImage tmp = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        cop.filter(bi, tmp);
        cop2.filter(tmp, bimg);
        cop3.filter(bi, bimg2);
        try {
            ImageIO.write(bimg, "jpg", new File("images/draw_saved.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Выводим исходное и размытое изображения
        g2.drawImage(bi, null, 0, 0);
        g2.drawImage(bimg, null, w/3, 0);
        g2.drawImage(bimg2, null, 2*w/3, 0);

    }
    public static void main(String args[]){
        Frame f = new Task("ConvolveDemo - Исходное и размытое изображения");
        f.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e) {
                                    System.exit(0);
                                }
                            }
        );
        f.setSize(1600,300);
        f.setResizable(false);
        f.setVisible(true);
    }
}