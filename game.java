import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Aim Trainer Game
// This is a simple game where the player has to click on randomly placed targets in a grid.
public class game extends JPanel implements MouseListener {
    // selectedRow and selectedCol are used to determine which square was last
    // clicked
    private int selectedRow = -1;
    private int selectedCol = -1;
    private final int gridSize = 5; // size of the grid (5x5), change as desired
    private final int cellSize = 150; // size of each cell in pixels, change as desired

    // marginX and marginY are used to center the grid in the JFrame
    // they are calculated in the paintComponent method later
    private int marginX = 0;
    private int marginY = 0;

    // instance of the JFrame class to create the window
    private final JFrame frame;
    // instance of the ScoreCounter class to keep track of the score
    private final ScoreCounter scoreCounter;
    // instance of the Targets class to manage the targets
    private final Targets targets;

    public game() {

        this.addMouseListener(this);

        this.scoreCounter = new ScoreCounter();
        this.targets = new Targets(this.gridSize, 3); // 3 random targets, change as desired

        this.frame = new JFrame("Aim Trainer");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.scoreCounter.getLabel().setBounds(820, 10, 400, 70);
        this.frame.add(this.scoreCounter.getLabel());

        this.scoreCounter.getResetButton().setBounds(820, 75, 300, 50);
        this.frame.add(this.scoreCounter.getResetButton());

        this.frame.add(this);

        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // make the JFrame full screen
        this.frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // get margins to center the shapes
        int gridSizeInPixels = this.gridSize * this.cellSize;
        this.marginX = (this.getWidth() - gridSizeInPixels) / 2;
        this.marginY = (this.getHeight() - gridSizeInPixels) / 2;

        // draw the grid squares
        for (int row = 0; row < this.gridSize; row++) {
            for (int col = 0; col < this.gridSize; col++) {
                this.drawSquare(g, row, col);
            }
        }

        // draw the targets
        this.drawTargets(g);
        // repaint the score label and reset button
        // it will dissapear if updated
        this.scoreCounter.getLabel().repaint();
        this.scoreCounter.getResetButton().repaint();

    }

    // draws the grid squares
    private void drawSquare(Graphics g, int row, int col) {

        int x = this.marginX + col * this.cellSize;
        int y = this.marginY + row * this.cellSize;

        g.setColor(Color.BLACK);
        g.drawRect(x, y, this.cellSize, this.cellSize);
    }

    // draws the targets in the grid
    private void drawTargets(Graphics g) {
        g.setColor(Color.RED);
        int padding = this.cellSize / 10; // space between red square and border
        int size = this.cellSize - 2 * padding;

        // for target in targets array {row, col}
        for (int[] target : this.targets.getTargets()) {

            // calculate the x and y coordinates of the target square
            int x = this.marginX + target[1] * this.cellSize;
            int y = this.marginY + target[0] * this.cellSize;

            // draw the target with padding
            g.fillRect(x + padding, y + padding, size, size);
        }
    }

    // this method is used to update the score when a target is clicked
    private void updateScore() {
        // check if the clicked square is a target using the isTargetClicked method
        // the method also replaces the target with a new one if it was clicked
        if (this.targets.isTargetClicked(this.selectedRow, this.selectedCol)) {
            // update scoreCounter class
            this.scoreCounter.increment();
        } else {
            this.scoreCounter.reset();
        }
    }

    @Override
    // called when the mouse is clicked
    // used to determine which square was clicked
    public void mousePressed(MouseEvent e) {
        // accounts for margins
        // makes calcuation of squares easier
        int x = e.getX() - this.marginX;
        int y = e.getY() - this.marginY;

        // only check if the click is in the grid
        if (x > -1 && y > -1 && x < this.gridSize * this.cellSize && y < this.gridSize * this.cellSize) {
            // update selectedRow and selectedCol to the square that was clicked
            this.selectedCol = x / this.cellSize;
            this.selectedRow = y / this.cellSize;
            this.updateScore();
            this.repaint();
        }
    }

    // unused MouseListener methods
    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
