package PathfindingGUI;

import PathfindingGUI.Presets.AbstractPanelElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* Cell allows provides an area for pathfinder to traverse within the GridPanel. It handles what state a cell should
* become by using the selection which is modified externally. Implements Comparable so cell's can be used in a
* PriorityQueue in a pathfinder.
*/
public class Cell extends AbstractPanelElement implements Comparable<Cell> {

    // selection changed externally, used whenever an mouse event happens to a cell to change the cell's state
    static CellStates selection;

    // accept input allows cells to not be modified when the pathfinder is running
    static boolean acceptInput = true;

    private GridController controller;

    // current state of cell
    private CellStates currentState;

    private Point coordinate;

    // previous cell to get to this one, used to remember a path
    private Cell previous;

    // used by pathfinder to select which cell to traverse next depending on it's tactic
    private int heuristicScore;


    Cell(GridController controller, int x, int y) {
        this.controller = controller;
        createGUI();
        updateComponent(x, y);
        addMouseListener();
    }

    // graphical part of cell
    private void createGUI() {
        component = new JPanel();
        component.setBackground(Color.lightGray);
    }

    // used to update logic of cell
    private void updateComponent(int x, int y) {
        coordinate = new Point(x, y);
        currentState = CellStates.Blank;
        selection = CellStates.Wall;
        component.setName("Cell | position: " + x + " ," + y);
        heuristicScore = Integer.MAX_VALUE;
    }

    // add a listener to cell which changes cell's state dependent on selection and if cell is accepting input
    private void addMouseListener() {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (selection == CellStates.Wall && acceptInput) {
                    setWall();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (selection == CellStates.Start && acceptInput) {
                    setStart();
                }
                else if (selection == CellStates.End && acceptInput) {
                    setEnd();
                }
                else if (selection == CellStates.Blank && acceptInput){
                    setClear();
                }
            }
        });
    }

    // getters and setters

    public CellStates getState() {
        return currentState;
    }

    public Cell getPrevious() {
        return previous;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public int getHeuristicScore() {
        return heuristicScore;
    }

    public void setClear() {
        component.setBackground(Color.lightGray);
        currentState = CellStates.Blank;
        setHeuristicScore(Integer.MAX_VALUE);
        setPrevious(null);
    }

    public void setWall() {
        component.setBackground(Color.darkGray);
        currentState = CellStates.Wall;
    }

    public void setStart() {
        controller.clearStart();
        component.setBackground(Color.BLUE);
        currentState = CellStates.Start;
    }

    public void setEnd() {
        controller.clearEnd();
        component.setBackground(Color.RED);
        currentState = CellStates.End;
    }

    public void setChecked() {
        component.setBackground(Color.YELLOW);
    }

    public void setPath() {
        component.setBackground(Color.MAGENTA);
    }

    public void setHeuristicScore(int score) {
        this.heuristicScore = score;
    }

    public void setPrevious(Cell cell) {
        previous = cell;
    }

    public Cell clone() {
        Cell clone = new Cell(this.controller, this.coordinate.x, this.coordinate.y);
        clone.setPrevious(this.previous);
        return clone;
    }

    // allows cells to be used in priority queue in a pathfinder if cells override this method
    @Override
    public int compareTo(Cell o) {
        if (this.heuristicScore > o.getHeuristicScore())
            return 1;
        else if (this.heuristicScore < o.getHeuristicScore())
            return -1;
        else
            return 0;
    }
}