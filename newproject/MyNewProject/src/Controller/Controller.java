package Controller;

import Model.Model;
import View .ImageView;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Controller {
    private final Model Model;
    private final ImageView View;

    public Controller(Model model, ImageView view) {
        this.Model = model;
        this.View = view;

        initController();
    }

    private void initController() {
        View.getOpenButton().addActionListener(e -> openImage());
        View.getSaveButton().addActionListener(e -> saveImage());
        View.getUndoButton().addActionListener(e -> undo());
        View.getRedoButton().addActionListener(e -> redo());
    }

    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(View) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage img = ImageIO.read(chooser.getSelectedFile());
                Model.setImage(img);
                View.getImageLabel().setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(View, "Error opening image!");
            }
        }
    }

    private void saveImage() {
        if (Model.getImage() != null) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(View) == JFileChooser.APPROVE_OPTION) {
                try {
                    ImageIO.write(Model.getImage(), "png", chooser.getSelectedFile());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(View, "Error saving image!");
                }
            }
        }
    }

    private void undo() {
        Model.undo();
        View.getImageLabel().setIcon(new ImageIcon(Model.getImage()));
    }

    private void redo() {
        Model.redo();
        View.getImageLabel().setIcon(new ImageIcon(Model.getImage()));
    }
}

