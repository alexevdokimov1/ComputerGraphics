package Examples.Lesson5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ButtonDemo implements ActionListener {
    JLabel jlab;
    ButtonDemo(){
// Создаем фрейм
        JFrame frame = new JFrame("Обработка событий кнопок");
// Устанавливаем размеры созданного фрейма
        frame.setSize(220, 90);
// Устанавливаем менеджер компоновки
// для созданного фрейма
        frame.setLayout(new FlowLayout());
// Устанавливаем поведение при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Создаем две кнопки
        JButton button1 = new JButton("Первая");
        JButton button2 = new JButton("Вторая");
// К каждой кнопке добаляем слушателя события
// ActionEvent. В нашем случае обрабатывать
// событие будет наш класс ButtonDemo. Он может
// делать это, поскольку реализует интерфейс
// ActionListener
        button1.addActionListener(this);
        button2.addActionListener(this);
// Добавляем кнопки к фрейму
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
// Создаем метку и добавляем ее к фрейму
        jlab = new JLabel("Нажмите кнопку");
        frame.getContentPane().add(jlab);
// Делаем фрейм видимым
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
// Этот метод будет вызываться, когда в любой
// из двух кнопок возникнет событие класса ActionEvent
        if (e.getActionCommand().equals("Первая"))
            jlab.setText("Нажата первая кнопка");
        else
//
            jlab.setText("Нажата вторая кнопка");
    }
    public static void main(String[] args) {
        ButtonDemo bd = new ButtonDemo();
    }
}
