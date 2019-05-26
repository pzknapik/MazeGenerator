import java.util.ArrayList;

public class Maze {

    private ArrayList<Cell> mazeCells;
    private int size;
    private int numberOfCells;
    private int lastChosenDirection;

    public Maze(int size) {
        this.size = size;
        this.numberOfCells = size * size;
        this.mazeCells = new ArrayList<Cell>();
        initializeCells();
        this.lastChosenDirection = -1;
    }

    public void initializeCells() {
        for (int cellNumber = 0; cellNumber < numberOfCells; cellNumber++){
            mazeCells.add(new Cell(cellNumber));
        }
        mazeCells.get(0).setHasUpperWall(false);
        mazeCells.get(numberOfCells - 1).setHasLowerWall(false);
    }

    /**
     * Executes Aldous-Broder algorithm.
     *
     * Steps:
     * 1. Choose random cell and set as (A).
     * 2. Choose a neighbor connected to cell (A) and:
     *      a) If the neighbor has not yet been visited, connect it to (A) (delete wall between them).
     *      OR
     *      b) If the neighbor has been visited, don't connect it to (A) (leave the wall between them).
     * 3. Set the neighbor as new (A).
     * 4. Repeat steps 2-3 until all cells have been visited.
     */

    public void searchTheMaze() {
        Cell aCell = getRandomCell();
        aCell.markAsVisited();
        while(!allCellsVisited()) {
            aCell = getRandomNeighbor(aCell);
            if (!aCell.wasVisited()) {
                aCell.markAsVisited();

                switch (lastChosenDirection) {
                    case 0: // go left
                        connectToRightNeighbor(aCell);
                        break;
                    case 1: // go right
                        connectToLeftNeighbor(aCell);
                        break;
                    case 2: // go up
                        connectToLowerNeighbor(aCell);
                        break;
                    case 3: // go down
                        connectToUpperNeighbor(aCell);
                        break;
                }
            }
        }
    }

    /**
     * Get random cell of the maze.
     */
    public Cell getRandomCell() {
        Cell randomCell = mazeCells.get((int) (Math.random() * (numberOfCells)));
        randomCell.markAsVisited();
        return randomCell;
    }

    /**
     * Check if all cells of the maze have been visited already
     */
    public boolean allCellsVisited() {
        boolean allVisited = true;
        for (Cell cell : mazeCells) {
            if (!cell.wasVisited()) {
                allVisited = false;
            }
        }
        return allVisited;
    }

    // Connecting neighbors, by deleting walls between them.

    public void connectToLeftNeighbor(Cell cell) {
        cell.setHasLeftWall(false);
        getLeftNeighbor(cell).setHasRightWall(false);
    }

    public void connectToRightNeighbor(Cell cell) {
        cell.setHasRightWall(false);
        getRightNeighbor(cell).setHasLeftWall(false);
    }

    public void connectToUpperNeighbor(Cell cell) {
        cell.setHasUpperWall(false);
        getUpperNeighbor(cell).setHasLowerWall(false);
    }

    public void connectToLowerNeighbor(Cell cell) {
        cell.setHasLowerWall(false);
        getLowerNeighbor(cell).setHasUpperWall(false);
    }

    // Check if the cell lies on the border of the maze.

    public boolean checkIfCellIsOnLeftBorder(Cell cell) {
        if (cell.getCellNumber() % size == 0) {
            return true;
        }
        return false;
    }

    public boolean checkIfCellIsOnRightBorder(Cell cell) {
        if ((cell.getCellNumber() + 1) % size == 0) {
            return true;
        }
        return false;
    }

    public boolean checkIfCellIsOnUpperBorder(Cell cell) {
        if (cell.getCellNumber() < size) {
            return true;
        }
        return false;
    }

    public boolean checkIfCellIsOnLowerBorder(Cell cell) {
        if (cell.getCellNumber() > (numberOfCells - size - 1)) {
           return true;
       }
       return false;
    }

    // Neighbor selection - if the cell lies on the border, select opposite neighbor.

    public Cell getRandomNeighbor(Cell cell) {
        int randomDirection = (int) (Math.random() * 4);

        switch (randomDirection) {
            case 0:
                return getLeftNeighbor(cell);
            case 1:
                return getRightNeighbor(cell);
            case 2:
                return getUpperNeighbor(cell);
            case 3:
                return getLowerNeighbor(cell);
        }
        return null;
    }

    public Cell getLeftNeighbor(Cell cell) {
        Cell leftNeighbor;
        if(checkIfCellIsOnLeftBorder(cell)) {
            return getRightNeighbor(cell);
        } else {
            leftNeighbor = mazeCells.get(cell.getCellNumber() - 1);
        }
        lastChosenDirection = 0;
        return leftNeighbor;
    }

    public Cell getRightNeighbor(Cell cell) {
        Cell rightNeighbor;
        if(checkIfCellIsOnRightBorder(cell)) {
            return getLeftNeighbor(cell);
        } else {
            rightNeighbor = mazeCells.get(cell.getCellNumber() + 1);
        }
        lastChosenDirection = 1;
        return rightNeighbor;
    }

    public Cell getUpperNeighbor(Cell cell) {
        Cell upperNeighbor;
        if(checkIfCellIsOnUpperBorder(cell)) {
            return getLowerNeighbor(cell);
        } else {
            upperNeighbor = mazeCells.get(cell.getCellNumber() - size);
        }
        lastChosenDirection = 2;
        return upperNeighbor;
    }

    public Cell getLowerNeighbor(Cell cell) {
        Cell lowerNeighbor;
        if(checkIfCellIsOnLowerBorder(cell)) {
            return getUpperNeighbor(cell);
        } else {
            lowerNeighbor = mazeCells.get(cell.getCellNumber() + size);
        }
        lastChosenDirection = 3;
        return lowerNeighbor;
    }

    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < size; row++) {
            for (int i = 0; i < size; i++) {
                result = result + mazeCells.get(i + row * size).printFirstRow();
            }
            result = result + "\n";
            for (int i = 0; i < size; i++) {
                result = result + mazeCells.get(i + row * size).printSecondRow();
            }
            result = result + "\n";
            for (int i = 0; i < size; i++) {
                result = result + mazeCells.get(i + row * size).printThirdRow();
            }
            result = result + "\n";
        }
        return result;
    }
}
