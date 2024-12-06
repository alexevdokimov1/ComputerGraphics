package Labs.Lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Lab4 {
    public static int width = 800;
    public static int height = 600;

    public JMenuBar createBar(){
        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem fileItem_Load = new JMenuItem("Load");
        JMenuItem fileItem_Save = new JMenuItem("Save");
        JMenuItem fileItem_SaveAs = new JMenuItem("Save As");
        JMenuItem fileItem_Exit = new JMenuItem("Exit");
        
        fileMenu.add(fileItem_Load);
        fileMenu.add(fileItem_Save);
        fileMenu.add(fileItem_SaveAs);
        fileMenu.add(fileItem_Exit);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem editItem_Undo = new JMenuItem("Undo");
        JMenuItem editItem_Redo = new JMenuItem("Redo");
        JMenuItem editItem_Copy = new JMenuItem("Copy");
        JMenuItem editItem_Paste = new JMenuItem("Paste");
        JMenuItem editItem_Find = new JMenuItem("Find");
        JMenuItem editItem_Replace = new JMenuItem("Replace");

        editMenu.add(editItem_Undo);
        editMenu.add(editItem_Redo);
        editMenu.add(editItem_Copy);
        editMenu.add(editItem_Paste);
        editMenu.add(editItem_Find);
        editMenu.add(editItem_Replace);

        JMenu viewMenu = new JMenu("View");

        JMenuItem viewItem_Appearance = new JMenuItem("Appearance");
        JMenuItem viewItem_ZoomUp = new JMenuItem("Zoom Up");
        JMenuItem viewItem_ZoomDown = new JMenuItem("Zoom Down");

        viewMenu.add(viewItem_Appearance);
        viewMenu.add(viewItem_ZoomUp);
        viewMenu.add(viewItem_ZoomDown);

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(viewMenu);

        return bar;
    }

    Lab4(){
        JFrame baseFrame = new JFrame("Lab4");
        baseFrame.setSize(width, height);
        baseFrame.setLayout(new FlowLayout());

        JMenuBar bar = createBar();
        baseFrame.setJMenuBar(bar);

        JTabbedPane tabs = new JTabbedPane();

        JPanel tab1Panel = new JPanel();
        tab1Panel.setLayout(new FlowLayout());
        JCheckBox checkBox1 = new JCheckBox("Check Box 1");
        checkBox1.setFocusable(false);
        checkBox1.setBorder(BorderFactory.createEtchedBorder());
        JCheckBox checkBox2 = new JCheckBox("Check Box 2");
        checkBox2.setFocusable(false);
        JButton button1 = new JButton("Button");
        button1.setFocusable(false);
        tab1Panel.add(checkBox1);
        tab1Panel.add(checkBox2);
        tab1Panel.add(button1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JTextField textField = new JTextField(10);
        JButton submitButton = new JButton("Сохранить");
        submitButton.setFocusable(false);
        JLabel textArea = new JLabel();
        submitButton.addActionListener(e -> {
            String str = textField.getText();
            if(str.isEmpty()) str = "Field is empty";
            else str = "Your new text: " + str;
            textArea.setText(str);
            }
        );
        panel2.add(textField);
        panel2.add(submitButton);
        panel2.add(textArea);

        String[] columnNames = {"Name", "Birthdate"};
        Object[][] data = {
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"},
                {"Igor", "20.05.2001"},
                {"Alex", "01.10.1995"},
                {"Irina", "30.10.1984"},
                {"Anna", "11.02.1998"}
        };
        JTable table = new JTable(new DefaultTableModel(data, columnNames));

        DefaultMutableTreeNode food = new DefaultMutableTreeNode("Food");

        DefaultMutableTreeNode fruits = new DefaultMutableTreeNode("Fruit");
        DefaultMutableTreeNode apple = new DefaultMutableTreeNode("apple");
        DefaultMutableTreeNode pineapple = new DefaultMutableTreeNode("pineapple");
        food.add(fruits);
        fruits.add(apple);
        fruits.add(pineapple);
        JTree tree = new JTree(food);
        JScrollPane treeView = new JScrollPane(tree);

        JPanel sliderView = new JPanel();
        JSlider baseSlider = new JSlider(0,100,5);

        baseSlider.setFocusable(false);

        sliderView.add(baseSlider);

        tabs.addTab("Check Box", null, tab1Panel);
        tabs.addTab("Table with info", null, new JScrollPane(table));
        tabs.addTab("Input", null, panel2);
        tabs.addTab("Tree", null, treeView);
        tabs.addTab("Slider", null, sliderView);
        tabs.setFocusable(false);

        baseFrame.add(tabs);

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
                new Lab4();
            }
        });
    }
}

