package Examples.Lesson8;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
public class Task6 {
    //Попробуйте разные варианты
    //private static ComplexNumber c = new ComplexNumber(-0.223, 0.745);
    private static ComplexNumber c = new ComplexNumber(-0.123, 0.745);
    //private static ComplexNumber c = new ComplexNumber(0.223, 0.1);

    //Массив пикселей для хранения фрактала
    private boolean[][] values = null;
    //Границы комплексной плоскости
    private double minX = -1.5;
    private double maxX = 1.5;
    private double minY = -1.5;
    private double maxY = 1.5;
    // BufferedImage для рисования фрактала
    private BufferedImage image = null;
    //Максимальное разрешенное значение ComplexNumer
    private double threshold = 1;
    //Глубина рекурсии
    private int iterations = 100;
    public Task6(){
        // Создание объекта BufferedImage
        image = new BufferedImage(350,350,BufferedImage.TYPE_BYTE_GRAY);
        // Заполняем booean[][]
        this.getValues();
        for(int i=0;i<350;i++){
            for(int j=0;j<350;j++){
                //Если точка принадлежит множеству Жулиа - она красная, если нет - желтая
                if(values[i][j]) image.setRGB(i, j, Color.RED.getRGB());
                if(!values[i][j]) image.setRGB(i, j, Color.YELLOW.getRGB());
            }
        }
        JFrame f = new JFrame("Множество Жулиа"){
            private static final long serialVersionUID = 1L;
            @Override
            public void paint(Graphics g){
                g.drawImage(image,0,0,null);
            }
        };
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350,350);
        f.repaint();
        f.setVisible(true);
    }
    //Заполнение boolean[][] данными
    private void getValues(){
        values = new boolean[350][350];
        for(int i=0;i<350;i++){
            for(int j=0;j<350;j++){
                double a = (double)i*(maxX-minX)/(double)350 + minX;
                double b = (double)j*(maxY-minY)/(double)350 + minY;
                values[i][j] = isInSet(new ComplexNumber(a,b));
            }
        }
    }
    private boolean isInSet(ComplexNumber cn){
        for(int i=0;i<iterations;i++){
            cn = cn.square().add(c);
        }
        return cn.magnitude()<Math.pow(threshold, 2);
    }
    public static void main(String[] args){
        new Task6();
    }
}

class ComplexNumber{
    private double a, b;
    // Создание комплексного числа из двух вещественных чисел
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    // Возведение комплексных чисел в квадрат
    public ComplexNumber square(){
        return new ComplexNumber(this.a*this.a - this.b*this.b, 2*this.a*this.b);
    }
    // Сложение комплексных чисел
    public ComplexNumber add(ComplexNumber cn){
        return new ComplexNumber(this.a+cn.a, this.b+cn.b);
    }
    // Вычисление модуля^2
    public double magnitude(){
        return a*a+b*b;
    }
}


