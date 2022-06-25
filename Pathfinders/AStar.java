package Pathfinders;

import PathfindingGUI.Cell;
import PathfindingGUI.CellStates;
import PathfindingGUI.GridController;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/* AStar implementation, calculates a heuristic value for each node comprised of the distance of the current cell being
* checked to start node + the distance from current node to destination node. When a node has been checked, it will be
* added to a closed list so it cannot be checked again.
*/
public class AStar implements PathfindingStrategy {

    GridController controller;

    Cell start;

    Cell end;

    Cell currentNode;

    PriorityQueue<Cell> openList;

    ArrayList<Cell> closedList;

    ArrayList<Cell> cellList;

    ArrayList<Cell> checkedCells;

    // initialise operation for algorithm, create open, closed and cell Lists. Also obtain start and end cells.
    @Override
    public boolean initialise(GridController controller) {
        this.controller = controller;

        this.cellList = controller.getCellList();

        this.start = controller.getStart();
        this.end = controller.getEnd();

        openList = new PriorityQueue<Cell>();
        closedList = createClosedList();

        start.setHeuristicScore(calculateHScore(start));
        openList.add(start);

        // if start and end nodes are node present return false so algorithm will not run.
        if (start != null && end != null)
            return true;
        return false;
    }

    // queries the neighbours to the current cell, updates checked nodes list to color, returns a boolean whether the
    // algorithm should continue
    @Override
    public boolean findPath() {
        // reset checked cells
        checkedCells = new ArrayList<Cell>();

        // get cell with lowest heuristic value
        currentNode = openList.poll();
        // remove cell from open list and add to closed list
        openList.remove(currentNode);
        closedList.add(currentNode);

        // return true if destination is found or there are no cells left to check
        if (currentNode == end || !isActive()) {
            return true;
        }

        // iterate through the neighbours of the current cell
        for (Cell cell : getChildrenToCurrent()) {
            // if cell is a wall or has already been checked continue
            if (closedList.contains(cell))
                continue;

            // add to checked cells to update color
            checkedCells.add(cell);

            // calculate temp score for current path to this node
            int newScore = calculateFScore(cell);
            // if the cell is not already in open list then set path to neighbouring cell and add to open list
            if (!openList.contains(cell)) {
                cell.setHeuristicScore(calculateFScore(cell));
                cell.setPrevious(currentNode);
                openList.add(cell);
            } // if cell is already in open list then check if this new paths score is better then the one already found
            else if (newScore < cell.getHeuristicScore()) {
                // if path is better then append score and previous node and re add to open list
                openList.remove(currentNode);
                cell.setHeuristicScore(newScore);
                cell.setPrevious(currentNode);
                openList.add(currentNode);
            }
        }
        // return false if there are still other nodes to check or the end node has not been found
        return false;
    }

    @Override
    public boolean isActive() {
        if (start == currentNode)
            return true;
        return !openList.isEmpty();
    }

    @Override
    public ArrayList<Cell> getCheckedCells() {
        return checkedCells;
    }

    // returns all previous nodes from the end cell used when path is found to color path cells
    @Override
    public ArrayList<Cell> getPath() {
        ArrayList<Cell> path = new ArrayList<Cell>();
        while (currentNode.getPrevious() != null) {
            if (currentNode.getCoordinate().equals(start.getCoordinate()))
                break;
            path.add(currentNode.getPrevious());
            currentNode = currentNode.getPrevious();
        }
        return path;
    }

    // used to get the neighbouring cells to current cell, returns cells above, below, left and right of current cell
    private ArrayList<Cell> getChildrenToCurrent() {
        ArrayList<Cell> neighbours = new ArrayList<Cell>();

        for (int i = 0; i < 4; i++) {
            Point pointToCheck = null;
            switch (i) {
                case 0: pointToCheck = new Point(currentNode.getCoordinate().x - 1, currentNode.getCoordinate().y);
                    break;
                case 1: pointToCheck = new Point(currentNode.getCoordinate().x + 1, currentNode.getCoordinate().y);
                    break;
                case 2: pointToCheck = new Point(currentNode.getCoordinate().x, currentNode.getCoordinate().y + 1);
                    break;
                case 3: pointToCheck = new Point(currentNode.getCoordinate().x, currentNode.getCoordinate().y - 1);
            }

            // remove points that will be out of bounds
            if (pointToCheck.x < 0 || pointToCheck.x > GridController.gridValue
                    || pointToCheck.y < 0 || pointToCheck.y > GridController.gridValue) {
                continue;
            }

            // iterate through cell list to retrieve cells that correspond with neighbouring coordinates
            for (Cell cell : cellList) {
                if (cell.getCoordinate().equals(pointToCheck) && cell.getState() != CellStates.Wall) {
                    neighbours.add(cell);
                    break;
                }
            }
        }

        return neighbours;
    }

    // create initial closed list by adding wall cell so they will not be queried.
    private ArrayList<Cell> createClosedList() {
        ArrayList<Cell> closed = new ArrayList<Cell>();
        for (Cell cell : cellList) {
            if (cell.getState() == CellStates.Wall) {
                closed.add(cell);
            }
        }
        return closed;
    }

    // calculate whole heuristic score of a node, Gscore corresponds to distance from start to the node being queried
    // Hscore corresponds to distance from current node to the destination
    private int calculateFScore(Cell node) {
        return calculateGScore(node) + calculateHScore(node);
    }

    // calculate distance from queried node to the start to be used as a heuristic
    private int calculateGScore(Cell node) {
        int score = 0;
        Cell temp = node.clone();
        while (temp.getPrevious() != null) {
            score++;
            temp = temp.getPrevious();
        }
        return score;
    }

    // compute manhattan distance from node to end
    private int calculateHScore(Cell node) {
        return Math.abs(end.getCoordinate().x - node.getCoordinate().x) +
                Math.abs(end.getCoordinate().y - node.getCoordinate().y);
    }
}

/*

 */
