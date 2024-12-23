package Examples.Lesson2;

import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
public class DragKing extends ApplicationFrame implements MouseListener, MouseMotionListener{
    public static void main(String[] args) {
        new DragKing();
    }
    protected Point2D[] mPoints;
    protected Point2D mSelectedPoint;
    public DragKing() {
        super("Кривые");
        setSize(300, 300);
        mPoints = new Point2D[9];
// Кривая третьего порядка.
        mPoints[0] = new Point2D.Double(50, 75);
        mPoints[1] = new Point2D.Double(100, 100);
        mPoints[2] = new Point2D.Double(200, 50);
        mPoints[3] = new Point2D.Double(250, 75);
// Кривая второго порядка.
        mPoints[4] = new Point2D.Double(50, 175);
        mPoints[5] = new Point2D.Double(150, 150);
        mPoints[6] = new Point2D.Double(250, 175);
// Линия.
        mPoints[7] = new Point2D.Double(50, 275);
        mPoints[8] = new Point2D.Double(250, 275);
        mSelectedPoint = null;
        // Прослушивание событий мыши.
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
// Рисуем направляющие.
        Line2D tangent1 = new Line2D.Double(mPoints[0], mPoints[1]);
        Line2D tangent2 = new Line2D.Double(mPoints[2], mPoints[3]);
        g2.setPaint(Color.gray);
        g2.draw(tangent1);
        g2.draw(tangent2);
// Рисуем кривую третьего порядка.
        CubicCurve2D c = new CubicCurve2D.Float();
        c.setCurve(mPoints, 0);
        g2.setPaint(Color.black);
        g2.draw(c);
// Рисуем направляющие.
        tangent1 = new Line2D.Double(mPoints[4], mPoints[5]);
        tangent2 = new Line2D.Double(mPoints[5], mPoints[6]);
        g2.setPaint(Color.gray);
        g2.draw(tangent1);
        g2.draw(tangent2);
// Рисуем кривую второго порядка.
        QuadCurve2D q = new QuadCurve2D.Float();
        q.setCurve(mPoints, 4);
        g2.setPaint(Color.black);
        g2.draw(q);
// Рисуем линию.
        Line2D l = new Line2D.Float();
        l.setLine(mPoints[7], mPoints[8]);
        g2.setPaint(Color.black);
        g2.draw(l);
        for (int i = 0; i < mPoints.length; i++) {
// Если точка выбрана, то используем цвет для выбранной точки.
            if (mPoints[i] == mSelectedPoint)
                g2.setPaint(Color.red);
            else
                g2.setPaint(Color.blue);
// Рисуем точку.
            g2.fill(getControlPoint(mPoints[i]));
        }
    }
    protected Shape getControlPoint(Point2D p) {
// Создаём маленький квадрат вокруг точки.
        int side = 4;
        return new Rectangle2D.Double(p.getX() - side / 2, p.getY() - side / 2,side, side);
    }
    public void mouseClicked(MouseEvent me) {
    }
    public void mousePressed(MouseEvent me) {
        mSelectedPoint = null;
        for (int i = 0; i < mPoints.length; i++) {
            Shape s = getControlPoint(mPoints[i]);
            if (s.contains(me.getPoint())) {
                mSelectedPoint = mPoints[i];
                break;
            }
        }
        repaint();
    }
    public void mouseReleased(MouseEvent me) {}
    public void mouseMoved(MouseEvent me) {}
    public void mouseDragged(MouseEvent me) {
        if (mSelectedPoint != null) {
            mSelectedPoint.setLocation(me.getPoint());
            repaint();
        }
    }
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
}