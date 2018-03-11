import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class DrawingArea extends JPanel implements MouseListener,MouseMotionListener {

    int numberOfSecotrs = 12;
    protected int x1 ;
    protected int y1 ;
    protected int cx,cy;
    protected int count = 0;

    ArrayList<Path2D.Double> pathStorage = new ArrayList<Path2D.Double>();

    Path2D.Double path1 = new Path2D.Double();

    public void clearing(){

    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void paintComponent(Graphics g1){

        super.paintComponent(g1);
        Graphics2D g2 = (Graphics2D) g1;

            for (int i = 0; i < numberOfSecotrs; i++) {
                g2.setColor(Color.white);
                g2.drawLine(450, 450, 450, 0);
                g2.rotate(Math.toRadians(30), 450, 450);
            }

        g2.setPaint(Color.green);
        g2.setStroke(new BasicStroke(2));

        for(Path2D.Double path: pathStorage) {

            path.moveTo(cx, cy);
            path.quadTo(cx, cy, x1, y1);

            for (int i = 0; i < 12; i++) {
                g2.draw(path);
                g2.rotate(Math.toRadians(30), 450, 450);
            }

        }
        cx = x1;
        cy = y1;

    }

    public DrawingArea(){
        super();
        this.setBackground(Color.black);
        pathStorage.add(path1);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cx = e.getX();
                cy = e.getY();
                //repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                cx = e.getX();
                cy = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
