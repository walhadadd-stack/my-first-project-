package Model;

import java.awt.image.BufferedImage;
import java.util.Stack;

public class Model {
    private BufferedImage currentImage;
    private final Stack<BufferedImage> undoStack;
    private final Stack<BufferedImage> redoStack;

    public Model() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public BufferedImage getImage() {
        return currentImage;
    }

    public void setImage(BufferedImage image) {
        if (currentImage != null) {
            undoStack.push(currentImage);
            redoStack.clear();
        }
        currentImage = image;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentImage);
            currentImage = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentImage);
            currentImage = redoStack.pop();
        }
    }
}

