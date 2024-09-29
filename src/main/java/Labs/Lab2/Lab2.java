package Labs.Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Lab2 extends JFrame {

    public GeneralPath createTriangle(float xOffset){
        GeneralPath gp = new GeneralPath();
        gp.moveTo(0+xOffset, 180);
        gp.lineTo(120+xOffset, 180);
        gp.lineTo(60+xOffset, 80);
        gp.closePath();
        return gp;
    }

    public GeneralPath createArrow(float xOffset, float yOffset){
        GeneralPath gp = new GeneralPath();
        gp.moveTo(-30+xOffset, -10+yOffset); //0
        gp.lineTo(-40+xOffset, -10+yOffset); //1
        gp.lineTo(-40+xOffset, -15+yOffset); //2
        gp.lineTo(-55+xOffset, 0+yOffset); //3
        gp.lineTo(-40+xOffset, 15+yOffset); //4
        gp.lineTo(-40+xOffset, 10+yOffset); //5
        gp.lineTo(-30+xOffset, 10+yOffset); //6
        gp.lineTo(-30+xOffset, 30+yOffset); //7
        gp.lineTo(-10+xOffset, 30+yOffset); //8
        gp.lineTo(-10+xOffset, 40+yOffset); //9
        gp.lineTo(-15+xOffset, 40+yOffset); //10
        gp.lineTo(xOffset, 55+yOffset); //11
        gp.lineTo(15+xOffset, 40+yOffset); //12
        gp.lineTo(10+xOffset, 40+yOffset); //13
        gp.lineTo(10+xOffset, 30+yOffset); //14
        gp.lineTo(30+xOffset, 30+yOffset); //15
        gp.lineTo(30+xOffset, 10+yOffset); //16
        gp.lineTo(40+xOffset, 10+yOffset); //17
        gp.lineTo(40+xOffset, 15+yOffset); //18
        gp.lineTo(55+xOffset, 0+yOffset); //19
        gp.lineTo(40+xOffset, -15+yOffset); //20
        gp.lineTo(40+xOffset, -10+yOffset); //21
        gp.lineTo(30+xOffset, -10+yOffset); //22
        gp.lineTo(30+xOffset, -30+yOffset); //23
        gp.lineTo(10+xOffset, -30+yOffset); //24
        gp.lineTo(10+xOffset, -40+yOffset); //25
        gp.lineTo(15+xOffset, -40+yOffset); //26
        gp.lineTo(0+xOffset, -55+yOffset); //27
        gp.lineTo(-15+xOffset, -40+yOffset); //28
        gp.lineTo(-10+xOffset, -40+yOffset); //29
        gp.lineTo(-10+xOffset, -30+yOffset); //30
        gp.lineTo(-30+xOffset, -30+yOffset); //31
        gp.closePath();
        return gp;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paint(g2);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2f));

        GeneralPath gp = createTriangle(40f);
        g2.draw(gp);

        g2.setPaint(new GradientPaint(80,80,
                new Color(255,255,255),80,180, new Color(0,0,0)));

        g2.fill(gp);

        g2.setPaint(new Color(0,0,0));

        g2.setStroke(new BasicStroke(2f));
        gp = createTriangle(200f);
        g2.draw(gp);

        g2.setStroke(new BasicStroke(1f));
        gp = createTriangle(380f);
        g2.draw(gp);

        Ellipse2D ellipse = new Ellipse2D.Double(315,60,75,70);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        float[] dashPattern = {7.f,7.f, 2f, 7.f};
        g2.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0F, // Предельный фасетный угол
                dashPattern, // Шаблон пунктира
                0));

        g2.draw(ellipse);

        g2.setStroke(new BasicStroke(1f));

        GeneralPath arrow = createArrow(180f,100f);

        g2.draw(arrow);

    }

    public static void main(String[] args) {
        Lab2 gd = new Lab2();
        gd.setTitle("Вариант 6");
        gd.setSize(600, 200);
        gd.setResizable(false);
        gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gd.setVisible(true);
    }
}
