package Examples.Lesson8;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;
import javax.swing.JFrame;
public class Task5 extends JFrame{
    private static final long serialVersionUID = 1L;
    private Image img, newimg;
    //Конструктор
    public Task5(String s) {
//Вызов конструктора суперкласса
        super(s);
//Читаем изображение
        img = Toolkit.getDefaultToolkit().getImage("images/sa.jpg");
//Создаем экземпляр RGBImageFilter типа GrayColorFilter
        RGBImageFilter rgb = new GrayColorFilter();
//Создаем отфильтрованное изображние
        newimg = this.createImage(new FilteredImageSource(img.getSource(),rgb));
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
//Рисуем изображение
        g.drawImage(newimg, 0, 0, this);
    }
    public static void main(String[] args) {
        new Task5("RGBImageFilterDemo");
    }
}

class GrayColorFilter extends RGBImageFilter {
    public GrayColorFilter() {
        this.canFilterIndexColorModel = true;
    }
    @Override
    public int filterRGB(int x, int y, int rgb) {
//Получаем красную компоненту цвета
        int r = (0x000000ff & (rgb>>16));
//Получаем зеленую компоненту цвета
        int g = (0x000000ff & (rgb>>8));
//Получаем синюю компоненту цвета
        int b = (0x000000ff & rgb);
//Вычисляем яркость точки
        int gray = (int)(0.56 * g + 0.33 * r + 0.11 * b);
        int grayColor = (int) (0xff000000 | gray << 16 | gray << 8 | gray);
        return grayColor;
    }
}


