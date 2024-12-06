package Examples.Lesson5;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class IrinaButton implements MouseListener, ChangeListener {
    public static int width = 800;
    public static int height = 600;

    public JButton irinaRun = new JButton("Попробуй кликнтуть");
    public int countPressed = 0;
    public JFrame baseFrame;

    public JSlider slider = new JSlider(0,100,1);
    public JLabel label = new JLabel("");

    IrinaButton(){
        baseFrame = new JFrame("IrinaButton");
        baseFrame.setSize(width, height);
        baseFrame.setLayout(new FlowLayout());

        irinaRun.setBounds(0,300,200,50);
        irinaRun.setFocusable(false);
        irinaRun.addMouseListener(this);
        baseFrame.add(irinaRun);

        slider.addChangeListener(this);
        baseFrame.add(slider);

        baseFrame.add(label);

        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new IrinaButton();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Random rnd = new Random();
        if(countPressed >= 2)  {
            irinaRun.setText("Ну ладно");
            irinaRun.setBackground(Color.RED);
            label.setText("Ладно, сдаюсь");
        }
        else
            irinaRun.setLocation(rnd.nextInt(500),rnd.nextInt(500));
        countPressed++;
        baseFrame.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("Не жми!!!");
        baseFrame.repaint();
    }
}