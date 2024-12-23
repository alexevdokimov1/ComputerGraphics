package Examples.Lesson3;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;

public class CompositeTest {
    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new CompositeTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class CompositeTestFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public CompositeTestFrame() {
        this.setTitle("Правила композиции");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        canvas=new CompositeComponent();
        add(canvas, BorderLayout.CENTER);
        ruleCombo = new JComboBox(new Object[] {
                new Rule("CLEAR"," "," "),
                new Rule("SRC"," S"," S"),
                new Rule("DST"," ","DD"),
                new Rule("SRC_OVER"," S","DS"),
                new Rule("DST_OVER"," S","DD"),
                new Rule("SRC_IN"," "," S"),
                new Rule("SRC_OUT"," S"," "),
                new Rule("DST_IN"," "," D"),
                new Rule("DST_OUT"," ","D "),
                new Rule("SRC_ATOP"," ","DS"),
                new Rule("DST_ATOP"," S"," D"),
                new Rule("XOR"," S","D "),});
        ruleCombo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event){
                Rule r=(Rule)ruleCombo.getSelectedItem();
                canvas.setRule(r.getValue());
                explanation.setText(r.getExplanation());
            }
        });
        alphaSlider=new JSlider(0,100,75);
        alphaSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent event) {
                        canvas.setAlpha(alphaSlider.getValue());
                    }
                });
        JPanel panel=new JPanel();
        panel.add(ruleCombo);
        panel.add(new JLabel("Альфа"));
        panel.add(alphaSlider);
        add(panel,BorderLayout.NORTH);
        explanation = new JTextField();
        add(explanation, BorderLayout.SOUTH);
        canvas.setAlpha(alphaSlider.getValue());
        Rule r=(Rule)ruleCombo.getSelectedItem();
        canvas.setRule(r.getValue());
        explanation.setText(r.getExplanation());
    }
    private CompositeComponent canvas;
    private JComboBox ruleCombo;
    private JSlider alphaSlider;
    private JTextField explanation;
    private static final int DEFAULT_WIDTH=400;
    private static final int DEFAULT_HEIGHT=400;
}
class Rule{
    public Rule(String n, String pd1, String pd2) {
        name=n;
        porterDuff1=pd1;
        porterDuff2=pd2;
    }
    public String getExplanation() {
        StringBuilder r=new StringBuilder("Source ");
        if (porterDuff2.equals(" ")) r.append("clears");
        if (porterDuff2.equals(" S")) r.append("overwrites");
        if (porterDuff2.equals("DS")) r.append("blends with");
        if (porterDuff2.equals(" D")) r.append("alpha modifies");
        if (porterDuff2.equals("D ")) r.append("alpha component modifies");
        if (porterDuff2.equals("DD")) r.append("does not affect");
        r.append(" destination");
        if (porterDuff1.equals(" S")) r.append(" and overwrites empty pixels");
        r.append(".");
        return r.toString();
    }
    public String toString() {
        return name;
    }
    public int getValue() {
        try
        {
            return(Integer)AlphaComposite.class.getField(name).get(null);
        }
        catch(Exception e) {
            return -1;
        }
    }
    private String name;
    private String porterDuff1;
    private String porterDuff2;
}
class CompositeComponent extends JComponent{
    public CompositeComponent() {
        shape1=new Ellipse2D.Double(100,100,150,100);
        shape2=new Ellipse2D.Double(150,150,150,100);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        BufferedImage image=new BufferedImage(getWidth(),
                getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gImage=image.createGraphics();
        gImage.setPaint(Color.RED);
        gImage.fill(shape1);
        AlphaComposite composite=
                AlphaComposite.getInstance(rule, alpha);
        gImage.setComposite(composite);
        gImage.setPaint(Color.BLUE);
        gImage.fill(shape2);
        g2.drawImage(image,null,0,0);
    }
    public void setRule(int r) {
        rule=r;
        repaint();
    }
    public void setAlpha(int a) {
        alpha=(float)a/100.0F;
        repaint();
    }
    private int rule;
    private Shape shape1;
    private Shape shape2;
    private float alpha;
}

