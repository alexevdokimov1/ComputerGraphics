package Examples.Lesson8;

import java.awt.image.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
public class Task10 {

    public static void main(String[] args) throws Exception
    {
        // Определяем URL изображения. Попробуйте другое
        URL url= new URL("https://cs11.pikabu.ru/post_img/2019/02/04/12/1549312329147951618.jpg");

        // Читаем изображение
        BufferedImage image = ImageIO.read(url);
        // Сохраняем исходное изображение на диск
        ImageIO.write(image, "jpg", new File("images/image.jpg"));

        // Устанавливаем значение параметров масштабирования (factors)
        // и смещения (offsets) цвета

// масштаб для каждой составляющей цвета RGB. Поменяте!
        float[] factors = new float[] {1.45f, 1.45f, 1.45f};
        // смещение для каждой составляющей цвета RGB. Поменяте!
        float[] offsets = new float[] {100.0f, 15.0f, 0.0f};

        // Создаем объект RescaleOp
        RescaleOp rop = new RescaleOp(factors, offsets, null);

        // Фильтруем изображение
        BufferedImage bi = rop.filter((BufferedImage)image, null);

        // Получаем графический контекст изображения
        Graphics2D gbi = (Graphics2D) bi.getGraphics();

        // Добавляем к изображению строку
        gbi.setColor(new Color(255, 255, 255));
        gbi.drawString("Это судьба!!!", 15, 60);

        // Сохраняем отфильтрованное изображение в файл.
        ImageIO.write(bi, "jpg", new File("images/processed.jpg"));
    }
}
// Если каталог images пуст, то нажмите F5