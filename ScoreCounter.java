import javax.swing.*;
import java.awt.*;

// Score Counter Class
// This class is responsible for displaying and managing the score label and reset button
public class ScoreCounter {

    private int score;
    private final JLabel label;
    private final JButton resetButton;

    public ScoreCounter() {
        this.score = 0;

        // Create score label
        this.label = new JLabel("Score: 0");
        this.label.setFont(new Font("Arial", Font.BOLD, 69));

        // Create reset button
        this.resetButton = new JButton("Reset Score");
        this.resetButton.addActionListener(new ButtonListener(this));
        this.resetButton.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public void increment() {
        this.score++;
        this.label.setText("Score: " + this.score);
    }

    public void reset() {
        this.score = 0;
        this.label.setText("Score: 0");
    }

    public JLabel getLabel() {
        return this.label;
    }

    public JButton getResetButton() {
        return this.resetButton;
    }

    public int getScore() {
        return this.score;
    }
}
