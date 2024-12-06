package Examples.Lesson4;

import javax.swing.*;
import java.awt.*;

public class FrameDemo {
    FrameDemo(){
// Создание контейнера верхнего уровня JFrame
        JFrame jfrm = new JFrame("Простой фрейм");
// Установка начальных размеров фрейма
        jfrm.setSize(275, 100);

        JButton btn = new JButton("Hi there");
        JButton btn2 = new JButton("Мкмааьтцкадлкьалцкьалцукуьацулаьуцлатцулатцуалбуцт");
        jfrm.add(btn);
        jfrm.add(btn2);
        btn.setBounds(0,0,100,100);
        jfrm.setLayout(null);
// Завершение программы при закрытии пользователем
// окна приложения
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Отображение фрейма
        jfrm.setVisible(true);
    }
    public static void main(String[] args) {
// Создание фрейма в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new FrameDemo();
            }
        });
    }
}
