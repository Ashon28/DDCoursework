import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class DrawingArea extends JPanel implements MouseListener,MouseMotionListener {

    protected int numberOfSectors = 12;
    protected int x1 ;
    protected int y1 ;
    protected int cx,cy;
    protected int count = 0;

    ArrayList<Path2D.Double> undoStorage = new ArrayList<Path2D.Double>();

    ArrayList<Path2D.Double> pathStorage = new ArrayList<Path2D.Double>();

    ArrayList<Integer> penSizeStorage = new ArrayList<Integer>();

    ArrayList<Integer> undoPenSizeStorage = new ArrayList<Integer>();

    ArrayList<Color> colorStorage = new ArrayList<Color>();

    ArrayList<Color> undoColorStorage = new ArrayList<Color>();

    Path2D.Double path1 = new Path2D.Double();

    boolean start = true;

    boolean currentlyClearing = false;

    boolean currentlyUndoing = false;

    boolean showSectorLines = true;

    protected int penSize = 2;

    Color penColour = Color.green;

    public void setNumberOfSectors(int sectorNumber) {
        numberOfSectors = sectorNumber;
    }

    public int getNumberOfSectors(){
        return numberOfSectors;
    }

    public void toggleSectorLines(){
        showSectorLines = !showSectorLines;
    }

    public void setPenSize(int pen){
        penSize = pen;
    }

    public int getPenSize(){
        return penSize;
    }

    public void setPenColour(Color colorChange){
        penColour = colorChange;
    }

    public Color getPenColour() {
        return penColour;
    }

    public void undoing(){
        if (pathStorage.size() > 0) {
            System.out.println("Undoing");
            Path2D.Double recentPath = pathStorage.get(pathStorage.size() - 1);
            undoStorage.add(recentPath);
            undoColorStorage.add(colorStorage.get(colorStorage.size()-1));
            undoPenSizeStorage.add(penSizeStorage.get(penSizeStorage.size()-1));

            pathStorage.remove(pathStorage.size() - 1);
            colorStorage.remove(colorStorage.size()-1);
            penSizeStorage.remove(penSizeStorage.size()-1);
            currentlyUndoing = true;
        }
    }

    public void redoing(){
        if(undoStorage.size() > 0){
            System.out.println("Redoing");
            Path2D.Double PathToRedo = undoStorage.get(undoStorage.size() -1);
            pathStorage.add(PathToRedo);
            colorStorage.add(undoColorStorage.get(undoColorStorage.size()-1));
            penSizeStorage.add(undoPenSizeStorage.get(undoColorStorage.size()-1));

            undoStorage.remove(undoStorage.size() - 1 );
            undoColorStorage.remove(undoColorStorage.size() - 1);
            undoPenSizeStorage.remove(undoPenSizeStorage.size() - 1 );
        }
    }

    public void clearing(){
        System.out.println("Clearing");
        pathStorage.clear();
        colorStorage.clear();
        penSizeStorage.clear();

        undoStorage.clear();
        undoColorStorage.clear();
        undoPenSizeStorage.clear();

        currentlyClearing = true;

    }

    public void erasing(){
        System.out.println("Erasing");

    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void paintComponent(Graphics g1){

        //System.out.println("Painting");

        super.paintComponent(g1);
        Graphics2D g2 = (Graphics2D) g1;

        if (showSectorLines == true) {

            for (int i = 0; i < numberOfSectors; i++) {
                g2.setColor(Color.white);
                g2.drawLine(450, 450, 450, 0);
                g2.rotate(Math.toRadians(360/numberOfSectors), 450, 450);
            }

        }

        //System.out.println(start);

        if (start == false && currentlyClearing == false) {

            //System.out.println("Drawing");

            g2.setPaint(penColour);
            g2.setStroke(new BasicStroke(penSize));


            //Path2D.Double currentpath = pathStorage.get(pathStorage.size()-1);

            /*
            if (currentlyUndoing == false) {
                currentpath.moveTo(cx, cy);
                currentpath.quadTo(cx, cy, x1, y1);
            }
            */

            int pathNumber = 0;

            for (Path2D.Double path : pathStorage) {

                g2.setPaint(colorStorage.get(pathNumber));
                g2.setStroke(new BasicStroke(penSizeStorage.get(pathNumber)));

                for (int i = 0; i < numberOfSectors; i++) {
                    g2.draw(path);
                    g2.rotate(Math.toRadians(360/numberOfSectors), 450, 450);
                }

                pathNumber++;
            }
            /*
            cx = x1;
            cy = y1;
            */

        }

        currentlyUndoing = false;
        currentlyClearing = false;

    }

    public DrawingArea(){
        super();
        this.setBackground(Color.black);

        //pathStorage.add(path1);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //start = false;
                cx = e.getX();
                cy = e.getY();
                //pathStorage.add(new Path2D.Double());

                //System.out.println("Clicked");

                //repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

                //System.out.println("Pressed down");
                start = false;
                cx = e.getX();
                cy = e.getY();
                pathStorage.add(new Path2D.Double());
                colorStorage.add(penColour);
                penSizeStorage.add(penSize);
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
                //System.out.println("Dragged");
                x1 = e.getX();
                y1 = e.getY();
                start = false;

                Path2D.Double currentpath = pathStorage.get(pathStorage.size()-1);
                currentpath.moveTo(cx, cy);
                currentpath.quadTo(cx, cy, x1, y1);

                repaint();

                cx = x1;
                cy = y1;
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
