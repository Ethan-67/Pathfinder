package Pathfinders;

import PathfindingGUI.Cell;
import PathfindingGUI.CellStates;
import PathfindingGUI.GridController;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/* Dijkstra pathfinding implementation, adds all traversable cells into a priority queue, and chooses the node with
* the smallest distance to the start as the next node to check.
*/
public class Dijkstra implements PathfindingStrategy {

    GridController controller;

    ArrayList<Cell> cellList;

    ArrayList<Cell> checkedCells;

    Cell start;

    Cell end;

    Cell current;

    PriorityQueue<Cell> openList;

    // initialise operation for algorithm, create open, closed and cell Lists. Also obtain start and end cells.
    @Override
    public boolean initialise(GridController controller) {
        this.controller = controller;

        this.cellList = controller.getCellList();

        this.start = controller.getStart();
        this.end = controller.getEnd();

        openList = new PriorityQueue<Cell>();

        // add all traversable cells into the openlist which will be the nodes to be chosen from
        for (Cell cell : cellList) {
            if (cell.getState() != CellStates.Wall || cell.getState() != CellStates.End)
                openList.add(cell);
        }

        // set the start to have the lowest score so it will be chosen first (all other nodes are seeded with
        // Integer.max value)
        start.setHeuristicScore(0);
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

        // retrieve lowest scored cell and remove from open list so it will not be retrieved again
        current = openList.poll();
        openList.remove(current);

        // return true if destination is found or there are no cells left to check
        if (current.getState() == CellStates.End || !isActive()) {
            return true;
        }

        // iterate through the neighbours of the current cell
        for (Cell cell : getChildrenToCurrent(current)) {
            // add neighbour to checked cells to update color
            checkedCells.add(cell);

            // obtain a temporary score for neighbour by computing distance of neighbour to start node
            int tempDist = current.getHeuristicScore() + 1;
            // if path is better then one currently scored (or lower than initial value) save this path instead
            if (tempDist < cell.getHeuristicScore()) {
                // update new previous node and score
                cell.setHeuristicScore(tempDist);
                cell.setPrevious(current);
                // reset queue position by removing and re-adding cell
                openList.remove(cell);
                openList.add(cell);
            }
        }
        // return false if there are still other nodes to check or the end node has not been found
        return false;
    }

    @Override
    public boolean isActive() {
        if (start == current)
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
}
