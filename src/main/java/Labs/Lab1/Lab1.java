package Labs.Lab1;

import java.awt.*;
import javax.swing.*;

public class Lab1 extends JFrame {
    //Вариант 6
    private static final int width = 600;
    private static final int height = 300;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int[] x = new int[12];
        int[] y = new int[12];

        g.setColor(new Color(0,112,192));
        //Полигоны
        int x_dif = 130;
        int y_dif = 130;
        for(int i =0; i<2; i++)
            for (int j = 0; j < 2; j++){
                x[0] = x[11] = 30 + x_dif * i;
                x[1] = x[2] = x[9] = x[10] = 60 + x_dif * i;
                x[3] = x[4] = x[7] = x[8] = 120 + x_dif * i;
                x[5] = x[6] = 150 + x_dif * i;

                y[2] = y[3] = 30 + y_dif * j;
                y[0] = y[1] = y[4] = y[5] = 60 + y_dif * j;
                y[11] = y[10] = y[7] = y[6] = 120 + y_dif * j;
                y[9] = y[8] = 150 + y_dif * j;

                g.fillPolygon(x, y, 12);
        }

        // Прямоугольник
        g.setColor(new Color(0,0,0));
        g.fillRect(125, 130, 60, 50);
        // Вырезаем прямоугольник
        g.setColor(new Color(250,250,250));
        g.fillRect(125+5, 130+5, 60-10, 50-10);

        // Надписи
        g.setColor(new Color(255,0,0));
        g.setFont(new Font("Arial",Font.BOLD,34));
        g.drawString("Arial", 400, 220);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.setColor(new Color(0,32,96));
        g.drawArc(250, 120, 250, 130, 0, -90);
    }

    public static void main(String[] args) {
        Lab1 gd = new Lab1();
        gd.setTitle("Вариант 6");
        gd.setSize(width, height);
        gd.setResizable(false);
        gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gd.setVisible(true);
    }
}