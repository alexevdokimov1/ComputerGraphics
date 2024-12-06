package Labs.Lab7;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintPanel extends JPanel implements ActionListener, MouseListener,
        MouseMotionListener, ChangeListener {
    private static final long serialVersionUID = 1L;
    protected int lastX, lastY, w, h;
    protected float strokeSize = 5f;
    protected Color curColor = Color.BLACK;
    protected JFrame f;

    public PaintPanel(JFrame frame, int width, int height) {
        super();
        f = frame;
        w = width;
        h = height;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if ((me.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK) {
            Graphics2D g2 = (Graphics2D)this.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));
            g2.setColor(curColor);
            g2.drawLine(lastX, lastY, me.getX(), me.getY());
            lastX = me.getX();
            lastY = me.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent me) {

        if ((me.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK) {
            lastX = me.getX();
            lastY = me.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {}
    @Override
    public void actionPerformed(ActionEvent event) {
        String s = event.getActionCommand();
        if (s.equals("Очистить")) this.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource() instanceof DefaultColorSelectionModel)
            curColor = ((DefaultColorSelectionModel)e.getSource()).getSelectedColor();

        if(e.getSource() instanceof JSlider) {
            strokeSize = ((JSlider) e.getSource()).getValue();
            SimplePaint.sliderStrokeSizeValue.setText(String.valueOf(strokeSize));
        }
    }
}