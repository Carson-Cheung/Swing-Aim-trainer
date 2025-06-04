import java.awt.event.*;

// this class is responsible for handling the button click event
public class ButtonListener implements ActionListener {
    private final ScoreCounter scoreCounter;

    public ButtonListener(ScoreCounter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.scoreCounter.reset(); // reset the score when the button is clicked
    }
}
