public class Project2Runner {

    /*
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * 
     * This project is a simple aim training game where the player must click
     * on the targets that appear on a (5x5) grid. The player has 3 targets to click
     * at all times and clicking on a target will create a new target at a random
     * location. Each target clicked will increase the score by 1 and missing the
     * target will reset the score to 0. The game's aspects can be controlled in the
     * code by changing the number of targets, the size of the grid, and the size of
     * each cell.
     *
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * The components of the game are the JFrame, JLabel, and JButton.
     * 
     * The JFrame is used to create the window for the game and is defined in the
     * game class on line 34. Everything is added to the JFrame.
     * 
     * The JLabel is used to display the score and is defined in the ScoreCounter
     * class on line 16. It is updated as the score changes.
     * 
     * The JButton is used to reset the score and is defined in the ScoreCounter
     * class on line 20. It is used to reset the score to 0 when clicked.
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * The game class extends JPanel and is used to draw the grid, targets, score,
     * and reset button. It is defined in the game class on line 7.
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * The ActionListener is used to reset the score when the reset button is
     * clicked. It is defined in the ButtonListener class on line 4.
     * 
     * The MouseListener is used to detect when the player clicks on the grid. It is
     * defined in the game class on line 7. The mouseClicked method is used to tell
     * the game which square on the grid was clicked.
     */

    public static void main(String[] args) {
        new game();
    }
}
