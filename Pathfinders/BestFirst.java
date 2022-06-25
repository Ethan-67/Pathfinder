package Pathfinders;

import Pathfinders.PathfindingStrategy;
import PathfindingGUI.Cell;
import PathfindingGUI.CellStates;
import PathfindingGUI.GridController;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/* Best First Search implementation, calculates a heuristic value for a current node by checking the distance from
* current to destination node. The cell with the lowest distance is then chosen next. Keeps track of the nodes searched
* already through explored and unexplored lists.
*/
public class BestFirst implements PathfindingStrategy {

    PriorityQueue<Cell> unexplored;

    ArrayList<Cell> explored;

    ArrayList<Cell> checkedCells;

    GridController controller;

    ArrayList<Cell> cellList;

    Cell start;

    Cell end;

    Cell current;

    // initialise operation for algorithm, create open, closed and cell Lists. Also obtain start and end cells.
    @Override
    public boolean initialise(GridController controller) {
        this.controller = controller;

        this.cellList = controller.getCellList();

        this.start = controller.getStart();
        this.end = controller.getEnd();

        unexplored = new PriorityQueue<Cell>();
        explored = new ArrayList<Cell>();

        start.setHeuristicScore(calculateDistanceFromCurrentToEnd(start));

        unexplored.add(start);

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
        current = unexplored.poll();

        // return true if destination is found or there are no cells left to check
        if (current.getState() == CellStates.End || !isActive())
            return true;

        // if cell is a wall or has already been checked continue
        for (Cell neighbour : getChildrenToCurrent(current)) {
            // add cell to checked cells to update color
            checkedCells.add(neighbour);

            // calculate a temp score by calculating distance from neighbour to destination node.
            int tempScore = calculateDistanceFromCurrentToEnd(neighbour);
            // if cell has not been already checked set previous nodes to current and set it's score
            // also add to explored and unexplored lists
            if (!explored.contains(neighbour)) {
                neighbour.setHeuristicScore(tempScore);
                neighbour.setPrevious(current);
                explored.add(neighbour);
                unexplored.add(neighbour);
            }
            // else if this path is better then the one currently scored, update the neighbour with new path
            else if (tempScore < neighbour.getHeuristicScore()) {
                // reset position in priority queue
                unexplored.remove(neighbour);

                neighbour.setHeuristicScore(tempScore);
                neighbour.setPrevious(current);

                unexplored.add(neighbour);
            }
        }
        // return false if there are still other nodes to check or the end node has not been found
        return false;
    }

    @Override
    public boolean isActive() {
        if (start == current)
            return true;
        return !unexplored.isEmpty();
    }

    @Override
    public ArrayList<Cell> getCheckedCells() {
        return checkedCells;
    }

    // returns all previous nodes from the end cell used when path is found to color path cells
    @Override
    public ArrayList<Cell> getPath() {
        start.setPrevious(null);
        ArrayList<Cell> pathCells = new ArrayList<Cell>();
        while (end.getPrevious() != null) {
            pathCells.add(end.getPrevious());
            end = end.getPrevious();
        }
        return pathCells;
    }

    // used to get the neighbouring cells to current cell, returns cells above, below, left and right of current cell
    private ArrayList<Cell> getChildrenToCurrent(Cell currentNode) {
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

    // compute manhattan distance from node to end
    private int calculateDistanceFromCurrentToEnd(Cell node) {
        return Math.abs(end.getCoordinate().x - node.getCoordinate().x) +
                Math.abs(end.getCoordinate().y - node.getCoordinate().y);
    }
}
