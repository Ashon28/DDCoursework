import javax.swing.*;
import java.awt.*;

public class DisplayGUI extends JFrame {
    public static void main(String[] args){
        completeWindow run = new completeWindow("Digital Doily Program");
        run.init();
    }
}

class completeWindow extends JFrame{

    public completeWindow(String title){
        super(title);
    }

    public void init(){
        Container pane = this.getContentPane();


        DrawingArea drawingArea = new DrawingArea();
        drawingArea.setSize(new Dimension(900,900));

        JPanel controlOptions = new JPanel();
        controlOptions.setPreferredSize(new Dimension(300,900));
        controlOptions.setBackground(Color.gray);
        controlOptions.setLayout(new FlowLayout());


        JPanel galleryStorage = new JPanel();
        galleryStorage.setPreferredSize(new Dimension(300,900));
        galleryStorage.setBackground(Color.gray);
        galleryStorage.setLayout(new FlowLayout());

        ControlOptions controlButtons = new ControlOptions(this,drawingArea);
        controlButtons.setPreferredSize(new Dimension(300,900));

        controlOptions.add(controlButtons);

        pane.setLayout(new BorderLayout());

        pane.add(controlOptions, BorderLayout.WEST);
        pane.add(galleryStorage, BorderLayout.EAST);
        pane.add(drawingArea, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500,900);
        this.setVisible(true);

    }

}