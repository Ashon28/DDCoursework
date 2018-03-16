import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
                drawingArea.clearing();
                drawingArea.repaint();
            }
        });

        JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingArea.undoing();
                drawingArea.repaint();
            }
        });

        JButton redo = new JButton("Redo");
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingArea.redoing();
                drawingArea.repaint();
            }
        });

        JCheckBox eraser = new JCheckBox("Erase");
        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JCheckBox ToggleSectorLines = new JCheckBox("Toggle Sector Lines");
        ToggleSectorLines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingArea.toggleSectorLines();
                drawingArea.repaint();
            }
        });



        String[] colours = {"Green", "Orange", "Red", "Blue"};
        Color[] colors = {Color.green,Color.orange,Color.red,Color.blue};
        JComboBox colourList = new JComboBox(colours);
        colourList.setSelectedIndex(0);
        colourList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(colourList.getSelectedItem());
                Color colorSelection = colors[colourList.getSelectedIndex()];
                drawingArea.setPenColour(colorSelection);

            }
        });




        SpinnerModel penSize = new SpinnerNumberModel(2,1,10,1);
        JSpinner penSpinner = new JSpinner(penSize);
        penSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(penSpinner.getValue());
                drawingArea.setPenSize((Integer) penSpinner.getValue());
            }
        });

        SpinnerModel numberOfSectors = new SpinnerNumberModel(12,2,24,1);
        JSpinner sectorSpinner = new JSpinner(numberOfSectors);
        sectorSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                drawingArea.setNumberOfSectors((Integer) sectorSpinner.getValue());
                drawingArea.repaint();
            }
        });


        add(clear);
        add(undo);
        add(redo);
        add(eraser);
        add(ToggleSectorLines);
        add(colourList);
        add(penSpinner);
        add(sectorSpinner);

    }

}
