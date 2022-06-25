package PathfindingGUI;

import Layouts.BlankLayout;
import Layouts.MazeLayout;
import Layouts.WallLayout;
import Pathfinders.AStar;
import Pathfinders.BestFirst;
import Pathfinders.Dijkstra;
import Pathfinders.PathfindingStrategy;
import PathfindingGUI.Presets.SliderPreset;

import javax.swing.*;
import java.util.ArrayList;

/* GUIController handles all logic between GUI and pathfinder's. Provides all operations for the interface within the
* GUI that need to interact with PathfindingStratergy interface.
*/
public class GUIController {

    GUI gui;

    // storing and retrieving elements
    GUIElementHashMap elementHashMap;

    // key input for switching cell selecting mode which is used for mouse events over cells
    KeyOperation keyOperation;

    // logic behind cells and grid
    GridController gridController;

    // Strategy pattern for pathfinding algorithms allowing them to be used interchangeably
    PathfindingStrategy pathfinder;

    // slider to set pathfinder speed
    SliderPreset sliderPreset;

    // used to callback for pathfinder at fixed intervals (speed selected by slider)
    Timer pathfindingTask;

    public GUIController() {
        createGUI();
        retrieveGUIElements();
        assignControls();

        // load A star pathfinder as default
        loadAStar();
    }

    private void createGUI() {
        gui = new GUI();
    }

    // get key gui elements
    private void retrieveGUIElements() {
        elementHashMap = gui.getElements();
        gridController = gui.getGridController();
        sliderPreset = elementHashMap.getSlider();
    }

    // assign user input controls to entire application
    private void assignControls() {
        keyOperation = new KeyOperation(this, elementHashMap.getModeArea());
        ButtonListeners.assignButtonListeners(this, elementHashMap.getAllButtons());
    }

    // GUI operations

    public void start() {
        // if no start end nodes then do not start OR pathfinder is already running do not start
        if (!pathfinder.initialise(gridController))
            return;

        // stop accepting user input
        keyOperation.setGridActive(false);
        // create a timer to create a callback to pathfinder
        createPathfindingTimer();
        pathfindingTask.start();
    }

    public void stop() {
        pathfindingTask.restart();
        pathfindingTask.stop();
        // accept user input
        keyOperation.setGridActive(true);
    }

    public void blankLayout() {
        gridController.setCellLayout(new BlankLayout());
    }

    public void mazeLayout() {
        gridController.setCellLayout(new MazeLayout());
    }

    public void wallLayout() {
        gridController.setCellLayout(new WallLayout());
    }

    public void loadAStar() {
        pathfinder = new AStar();
    }

    public void loadDijkstra() {
        pathfinder = new Dijkstra();
    }

    public void loadBestFirst() {
        pathfinder = new BestFirst();
    }

    private void createPathfindingTimer() {
        pathfindingTask = new Timer(sliderPreset.getSpeed(), (e1) -> {
            // if no path is found color checked cells
            if (!pathfinder.findPath()) {
                updateChecked(pathfinder.getCheckedCells());
            }
            else {
                // if path found draw the path back and stop pathfinder
                drawPath(pathfinder.getPath());
                pathfindingTask.stop();
            }
            // set delay to slider
            pathfindingTask.setDelay(sliderPreset.getSpeed());
        });
    }

    // update all cells colors checked by pathfinder
    private void updateChecked(ArrayList<Cell> checkCells) {
        for (Cell cell : checkCells) {
            if (cell.getState() == CellStates.Blank)
                cell.setChecked();
        }
    }

    // update all cell colors in path
    private void drawPath(ArrayList<Cell> pathCells) {
        for (Cell cell : pathCells) {
            cell.setPath();
        }
    }
}
