package Examples.Lesson5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class TextFieldDemo implements ActionListener{
    JTextField field1, field2;
    JLabel itog;
    TextFieldDemo(){
// Создаем фрейм
        JFrame frame = new JFrame("Обработка событий кнопок");
        // Устанавливаем размеры созданного фрейма
        frame.setSize(300, 120);
// Устанавливаем менеджер компоновки
// для созданного фрейма
        frame.setLayout(new GridLayout(4,1));
// Устанавливаем поведение при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Создаем два поля для ввода
        field1 = new JTextField(10);
        field2 = new JTextField(10);
// Создаем метку, в которую будем выводить
// результат умножения
        itog = new JLabel("Введите числа для умножения");
// Создаем кнопку, по нажатии на которую
// будет производиться умножение
        JButton go = new JButton("Умножить");
// добавляем к кнопке обработчик событий
        go.addActionListener(this);
// добавляем к фрейму два поля для ввода,
// кнопку и метку
        frame.getContentPane().add(field1);
        frame.getContentPane().add(field2);
        frame.getContentPane().add(go);
        frame.getContentPane().add(itog);
        frame.setVisible(true);
    }
    // Реализуем метод для обработки нажатия кнопки.
// Метод описан в интерфейсе ActionListener,
// который реализуется нашим классом TextFieldDemo
    public void actionPerformed(ActionEvent e) {
// Получаем строку, которая введена в первое
// текстовое поле
        String f1 = field1.getText();
// Получаем строку, которая введена во второе
// текстовое поле
        String f2 = field2.getText();
// Преобразуем полученные из текстовых полей строки
// в целые числа. Для этого используем статический
// метод parseInt класса Integer
        int num1 = Integer.parseInt(f1);
        int num2 = Integer.parseInt(f2);
        // выполняем умножение
        int num = num1 * num2;
// Помещаем в метку результат. Для этого сначала
// создаем объект класса-оболочки Integer,
// передавая в его конструктор величину типа int.
// Затем с помощью метода toString преобразуем
// величину в строку
        itog.setText(String.valueOf(num));
    }
    public static void main(String[] args) {
        TextFieldDemo tfd = new TextFieldDemo();
    }
}

