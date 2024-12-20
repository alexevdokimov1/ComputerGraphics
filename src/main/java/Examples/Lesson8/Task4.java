package Examples.Lesson8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ReplicateScaleFilter;
import javax.swing.JFrame;
public class Task4 extends JFrame {
    private static final long serialVersionUID = 1L;
    private Image img, simg, croping, scroping, replimg, averimg;
    //Конструктор
    Task4(String s){
        super(s);
//Получаем изображение из файла
        img = Toolkit.getDefaultToolkit().getImage("images/sa.jpg");
//Создаем фильтры
//Фильтр для обрезки изображения
        CropImageFilter cif = new CropImageFilter(200, 150, 600, 700);
//Простой фильтр для масштабирования в область 200 на 200 пикселей
        ReplicateScaleFilter rsf = new ReplicateScaleFilter(200, 200);
//Более сложный фильтр для масштабирования в область 200 на 200 пикселей
        AreaAveragingScaleFilter asf = new AreaAveragingScaleFilter(200, 200);
//Масштабированное AreaAveragingScaleFilter исходное изображение
        simg = this.createImage(new FilteredImageSource(img.getSource(), asf));
//Обрезанное и масштабированное ReplicateScaleFilter изображение
        croping = this.createImage(new FilteredImageSource(img.getSource(), cif));
        scroping = this.createImage(new FilteredImageSource(croping.getSource(), rsf));
//Масштабированное ReplicateScaleFilter исходное изображение
        replimg = this.createImage(new FilteredImageSource(img.getSource(), rsf));
//Масштабированное AreaAveragingScaleFilter исходное изображение
        CropImageFilter cif1 = new CropImageFilter(900, 140, 100, 100);
        averimg = this.createImage(new FilteredImageSource(img.getSource(), cif1));
        averimg = this.createImage(new FilteredImageSource(averimg.getSource(), asf));
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {
//Выводим отфилтрованные изображения в разные места окна
        g.drawImage(averimg, 0, 0, this);
    }
    public static void main(String[] args) {
        new Task4("Фильтры");
    }
}