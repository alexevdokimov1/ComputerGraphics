package Labs.Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc implements ActionListener {
    public static int width = 800;
    public static int height = 600;

    enum Actions {PLUS, MINUS, MUL, DIV};

    private Actions savedAction = Actions.PLUS;

    JTextField inputOne = new JTextField(10);
    JTextField inputTwo = new JTextField(10);
    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton multiply = new JButton("*");
    private final JButton divide = new JButton("/");
    JTextField output = new JTextField(10);

    public JFrame baseFrame;

    Calc(){
        baseFrame = new JFrame("Calculator");
        baseFrame.setSize(width, height);

        baseFrame.setLayout(new FlowLayout());

        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

        JPanel panel = new JPanel();

        baseFrame.add(inputOne);
        baseFrame.add(inputTwo);

        panel.setLayout(new GridLayout(2,2));

        panel.add(plus);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);
        baseFrame.add(output);
        output.setEditable(false);

        baseFrame.add(panel);

        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                new Calc();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "+":
                savedAction = Actions.PLUS;
                break;
            case "-":
                savedAction = Actions.MINUS;
                break;
            case "*":
                savedAction = Actions.MUL;
                break;
            case "/":
                savedAction = Actions.DIV;
                break;
        }
        solve();
    }

    private void solve(){
        String input1String = inputOne.getText();
        if(input1String.isEmpty()) input1String="0";
        String input2String = inputTwo.getText();
        if(input2String.isEmpty()) input2String="0";

        double input1 = Double.parseDouble(input1String);
        double input2 = Double.parseDouble(input2String);

        double result=0;

        switch (savedAction){
            case Actions.PLUS -> result = input1+input2;
            case Actions.MINUS -> result = input1 - input2;
            case Actions.MUL -> result = input1 * input2;
            case Actions.DIV -> {
                    if(input2==0) {
                        output.setText("ERROR");
                        return;
                    }
                    result = input1 / input2;
            }
        }

        output.setText(Double.toString(result));
    }
}