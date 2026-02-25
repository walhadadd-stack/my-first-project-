package View;

import javax.swing.*;
import java.awt.*;

public class ImageView extends JFrame {
    private final JLabel imageLabel;
    private final JButton openButton, saveButton, undoButton, redoButton;
    private  final JSlider brightnessSlider, contrastSlider;

    public ImageView() {
        setTitle("PixLab Interactive");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
imageLabel.setText("open");
        
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");

        brightnessSlider = new JSlider(-100, 100, 0);
        contrastSlider = new JSlider(-100, 100, 0);

        JPanel controlPanel = new JPanel();
        controlPanel.add(openButton);
        controlPanel.add(saveButton);
        controlPanel.add(undoButton);
        controlPanel.add(redoButton);
        controlPanel.add(new JLabel("Brightness"));
        controlPanel.add(brightnessSlider);
        controlPanel.add(new JLabel("Contrast"));
        controlPanel.add(contrastSlider);

        add(controlPanel, BorderLayout.SOUTH);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);
    }

    public JLabel getImageLabel() { return imageLabel; }
    public JButton getOpenButton() { return openButton; }
    public JButton getSaveButton() { return saveButton; }
    public JButton getUndoButton() { return undoButton; }
    public JButton getRedoButton() { return redoButton; }
    public JSlider getBrightnessSlider() { return brightnessSlider; }
    public JSlider getContrastSlider() { return contrastSlider; }
}

