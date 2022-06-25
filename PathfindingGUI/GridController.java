package PathfindingGUI;

import Layouts.GridCellLayout;
import PathfindingGUI.Presets.GridPanel;

import java.awt.*;
import java.util.ArrayList;

/* GridController handles all the logic necessary to create and store the cells used by the PathfindingStratergy
*/
public class GridController {
    // how many row and columns of cells created
    public static final int gridValue = 50;
    // graphical grid panel component
    private GridPanel panel;
    private ArrayList<Cell> cellList;

    public GridController(GridPanel gridPanel) {
        createCellGrid();
        setPanel(gridPanel);
    }

    // create all instances of cells and set their rows and columns relative to GridPanel
    private void createCellGrid() {
        cellList = new ArrayList<Cell>();

        for (int row = 0; row < gridValue; row++) {
            for (int col = 0; col < gridValue; col++) {
                Cell cell = new Cell(this, row, col);

                GridBagConstraints cellConstraints = cell.getConstraints();
                cellConstraints.gridx = col;
                cellConstraints.gridy = row;

                cellConstraints.fill = GridBagConstraints.BOTH;

                cellConstraints.weightx = 1f;
                cellConstraints.weighty = 1f;

                cellList.add(cell);
            }
        }

        Cell.selection = CellStates.Blank;
    }

    // set cell layout
    public void setCellLayout(GridCellLayout layout) {
        clearGrid();
        mapLayoutToCells(layout);
    }

    // clear all cell states
    private void clearGrid() {
        for (Cell cell : cellList) {
            cell.setClear();
        }
    }

    // takes in GridCellLayout which provides an array list of Point's for cell's that should be walls
    private void mapLayoutToCells(GridCellLayout layout) {
        ArrayList<Point> wallCoords = layout.getLayout(gridValue);

        for (int i = 0; i < wallCoords.size(); i++) {
            for (Cell cell : cellList) {
                if (cell.getCoordinate().equals(wallCoords.get(i))) {
                    cell.setWall();
                }
                else if (layout.getStart(gridValue).equals(cell.getCoordinate())) {
                    // set start cell
                    clearStart();
                    cell.setStart();
                }
                else if (layout.getEnd(gridValue).equals(cell.getCoordinate())) {
                    // set end cell
                    clearEnd();
                    cell.setEnd();
                }
            }
        }
    }

    public void addCellsToPanel() throws NullPointerException {
        panel.addCellsToPanel(cellList);
    }

    // clear start and clear end methods are called whenever a new start cell is created
    public void clearStart() {
        for (Cell cell : cellList) {
            if (cell.getState() == CellStates.Start) {
                cell.setClear();
                return;
            }
        }
    }

    public void clearEnd() {
        for (Cell cell : cellList) {
            if (cell.getState() == CellStates.End) {
                cell.setClear();
                return;
            }
        }
    }

    public ArrayList<Cell> getCellList() {
        return this.cellList;
    }

    public GridPanel getPanel() {
        return panel;
    }

    public Cell getStart() {
        for (Cell cell : cellList) {
            if (cell.getState() == CellStates.Start) {
                return cell;
            }
        }
        return null;
    }

    public Cell getEnd() {
        for (Cell cell : cellList) {
            if (cell.getState() == CellStates.End) {
                return cell;
            }
        }
        return null;
    }

    public void setPanel(GridPanel panel) {
        this.panel = panel;
    }
}
