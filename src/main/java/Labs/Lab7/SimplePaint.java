package Labs.Lab7;

import java.awt.*;
import javax.swing.*;

public class SimplePaint extends JFrame {
    private JColorChooser colorChooser = new JColorChooser();
    public static JLabel sliderStrokeSizeValue;

    public SimplePaint(String s) {
        super(s);
        this.setResizable(false);
        this.setSize(1920, 1080);
        PaintPanel paintPanel = new PaintPanel(this, 800, 800);
        paintPanel.addMouseListener(paintPanel);
        paintPanel.addMouseMotionListener(paintPanel);
        JScrollPane pane = new JScrollPane(paintPanel);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(pane, BorderLayout.CENTER);
        JPanel toolsPanel = new JPanel();
        this.add(toolsPanel, BorderLayout.SOUTH);
        JButton clear = new JButton("Очистить");
        clear.addActionListener(paintPanel);
        toolsPanel.add(clear);
        colorChooser.getSelectionModel().addChangeListener(paintPanel);
        toolsPanel.add(colorChooser);

        JPanel sliderStrokePanel = new JPanel();
        sliderStrokePanel.setLayout(new GridLayout(2,1));

        JSlider strokeSizeSlider = new JSlider(1,200,20);

        sliderStrokeSizeValue = new JLabel(String.valueOf(strokeSizeSlider.getValue()));
        sliderStrokePanel.add(sliderStrokeSizeValue, BorderLayout.SOUTH);

        strokeSizeSlider.addChangeListener(paintPanel);
        sliderStrokePanel.add(strokeSizeSlider, BorderLayout.NORTH);

        toolsPanel.add(sliderStrokePanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SimplePaint("Очень простой редактор");
    }
}