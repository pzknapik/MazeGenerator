public class Cell {

    private int cellNumber;
    private boolean visited;
    private boolean hasUpperWall;
    private boolean hasLowerWall;
    private boolean hasLeftWall;
    private boolean hasRightWall;

    public Cell (int cellNumber) {
        this.cellNumber = cellNumber;
        visited = false;
        hasLeftWall = true;
        hasRightWall = true;
        hasUpperWall = true;
        hasLowerWall = true;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void markAsVisited() {
        visited = true;
    }

    public boolean wasVisited() {
        return visited;
    }

    public boolean hasLeftWall() {
        return hasLeftWall;
    }

    public boolean hasRightWall() {
        return hasRightWall;
    }

    public boolean hasUpperWall() {
        return hasUpperWall;
    }

    public boolean hasLowerWall() {
        return hasLowerWall;
    }

    public void setHasLeftWall(boolean hasLeftWall) {
        this.hasLeftWall = hasLeftWall;
    }

    public void setHasRightWall(boolean hasRightWall) {
        this.hasRightWall = hasRightWall;
    }

    public void setHasUpperWall(boolean hasUpperWall) {
        this.hasUpperWall = hasUpperWall;
    }

    public void setHasLowerWall(boolean hasLowerWall) {
        this.hasLowerWall = hasLowerWall;
    }

    // Cell printing

    public String printFirstRow() {
        String result = "+";
        if (hasUpperWall)
            result = result + "---";
        else
            result = result + "   ";
        result = result + "+";
        return result;
    }

    public String printSecondRow() {
        String result = "";
        if (hasLeftWall)
            result = result + "|";
        else
            result = result + " ";
        if (visited)
            result = result + "   ";
        else
            result = result + " # ";
        if (hasRightWall)
            result = result + "|";
        else
            result = result + " ";
        return result;
    }

    public String printThirdRow() {
        String result = "";
        result = result + "+";
        if (hasLowerWall)
            result = result + "---+";
        else
            result = result + "   +";
        return result;
    }

    public String printCell() {
        return printFirstRow() + "\n" + printSecondRow() + "\n" + printThirdRow();
    }
}
