package Pathfinders;

import PathfindingGUI.Cell;
import PathfindingGUI.GridController;

import java.util.ArrayList;

/* Encapsulate a Pathfinding algorithm within this interface allowing them to be used interchangably.
 */
public interface PathfindingStrategy {

    boolean initialise(GridController controller);

    boolean findPath();

    boolean isActive();

    ArrayList<Cell> getCheckedCells();

    ArrayList<Cell> getPath();
}
