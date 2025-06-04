
// Targets class 
// This class handles the generation and management of targets in the game grid
public class Targets {
    // stored in a 2D array
    // each target is represented by their x and y location on the grid
    // targets[0] = {x, y}
    private final int[][] targets;
    private final int gridSize;
    private final int targetCount;

    public Targets(int gridSize, int targetCount) {
        this.gridSize = gridSize;
        this.targetCount = targetCount;
        this.targets = new int[targetCount][2];
        generateTargets();
    }

    // this method generates a random int between min and max (inclusive)
    private int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // this method generates the targets at the start if the game
    // it makes sure that there are no duplicate targets in the same location
    private void generateTargets() {
        int count = 0;
        // keep generating random targets until we reach the target count
        while (count < this.targetCount) {
            int row = random(0, this.gridSize - 1);
            int col = random(0, this.gridSize - 1);
            boolean used = false;

            // make sure there are no dupes only up to the count index
            // this prevents the code from checking {0,0} that is there by default when the
            // array is made
            for (int i = 0; i < count; i++) {
                if (targets[i][0] == row && targets[i][1] == col) {
                    used = true;
                    break;
                }
            }

            // if there is not a dupe, add it to the targets array
            // if not, try again (count does not go up so while loop does not end)
            if (!used) {
                targets[count][0] = row;
                targets[count][1] = col;
                count++;
            }
        }
    }

    // this method is used to generate a new target when one is clicked
    // it only makes 1 new target at a time
    private int[] generateTarget() {
        // loops until it finds an unocupied space in the grid
        while (true) {
            Boolean used = false;
            int x = random(0, this.gridSize - 1);
            int y = random(0, this.gridSize - 1);

            // make sure there is not already a target at that area
            for (int i = 0; i < this.targetCount; i++) {
                if (targets[i][0] == x && targets[i][1] == y) {
                    used = true;
                    break;
                }
            }
            // try again if there is
            if (used) {
                continue;
            }
            // if not, return the new target coordinates
            // will replace the old target that was clicked
            return new int[] { x, y };
        }
    }

    public int[][] getTargets() {
        return this.targets;
    }

    // this method is used to check if the square in the grid is a target
    // if it is, it replaces the target with a new one
    // returns true if the target was clicked, false if not
    // boolean is to tell the game class when to increment the score
    public boolean isTargetClicked(int row, int col) {
        // loop through targets array
        for (int i = 0; i < this.targets.length; i++) {
            // check if the target is at the clicked square
            if (this.targets[i][0] == row && this.targets[i][1] == col) {
                // replace the target that was clicked with a new one
                this.targets[i] = this.generateTarget();
                return true;
            }
        }
        return false;

    }
}
