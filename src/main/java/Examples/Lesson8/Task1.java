package Examples.Lesson8;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Task1 extends JFrame
{
    private static final long serialVersionUID = 1L;
    Image img2;
    int h, w;
    public Task1( )
    {
        super("Изображениe в окне");
//Получаем размеры экрана
        h = Toolkit.getDefaultToolkit().getScreenSize().height;
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
        //Устанавливаем размеры окна равными размеру экрана
        setSize(w, h);
        //Отключаем менеджер компоновки
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g)
    {


        JPanel p1 = new JPanel();

        p1.setBounds(w/4, h/4, w/2, h/2);

        this.add(p1);

        Graphics2D gp1 = (Graphics2D) p1.getGraphics();

        Image img = Toolkit.getDefaultToolkit().getImage("sa.jpg");

        int imh = img.getHeight(this);
        int imw = img.getWidth(this);

        gp1.scale(0.5*(h/imh), 0.5*(w/imw));

        gp1.drawImage(img, 0, 0, this);
    }
    public static void main( String args[])
    {
        new Task1();
    }
}
