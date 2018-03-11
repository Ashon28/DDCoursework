import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlOptions extends JPanel {

    public DrawingArea drawingArea;

    public ControlOptions(JFrame window, DrawingArea drawingArea){
        super();

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
                drawingArea.repaint();
            }
        });

        JButton undo = new JButton("Undo");

        JButton redo = new JButton("Redo");

        add(clear);
        add(undo);
        add(redo);

    }

}
