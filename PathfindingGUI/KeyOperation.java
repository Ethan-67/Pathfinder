package PathfindingGUI;

import PathfindingGUI.Presets.TextPreset;

import javax.swing.*;
import java.awt.event.ActionEvent;

/* KeyBindOperation utilises action maps to allow input from the keyboard to select what state cells should get within
* the GridPanel.
*/
public class KeyOperation {
    // controller to get gridcontroller
    private GUIController controller;

    // mode area is the text preset that changes with input from keyboard to show user what cell selection they are in
    private TextPreset modeArea;

    KeyOperation(GUIController controller, TextPreset modeArea) {
        this.controller = controller;
        this.modeArea = modeArea;
        // create changes in state when user presses a key
        createOperations();
    }

    private void createOperations() {
        placeWall();
        placeStart();
        placeEnd();
    }

    // handles creating an action with a callback to the action which sets cell selection to wall, which the cells
    // themselves listen to
    private void placeWall() {
        // create event CellStates.wall when W is released (release only occurs once when key is pressed/held down)
        controller.gridController.getPanel().component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released W"), CellStates.Wall);

        // add a callback whenever this CellStates.Wall event has occurred
        controller.gridController.getPanel().component.getActionMap().put(CellStates.Wall, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch between blank or wall state
                if (Cell.selection != CellStates.Wall) {
                    Cell.selection = CellStates.Wall;
                    modeArea.setText(CellStates.Wall.toString());
                }
                else {
                    Cell.selection = CellStates.Blank;
                    modeArea.setText(CellStates.Blank.toString());
                }

            }
        });

    }

    private void placeStart() {
        // when S is released create a CellStates.Start event
        controller.gridController.getPanel().component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released S"), CellStates.Start);

        // add a callback to set state to start or to blank depending on current state
        controller.gridController.getPanel().component.getActionMap()
                        .put(CellStates.Start, new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (Cell.selection != CellStates.Start) {
                                    Cell.selection = CellStates.Start;
                                    modeArea.setText(CellStates.Start.toString());
                                }
                                else {
                                    Cell.selection = CellStates.Blank;
                                    modeArea.setText(CellStates.Blank.toString());
                                }

                            }
                        });
    }

    private void placeEnd() {
        // when E key is released create CellStates.End event
        controller.gridController.getPanel().component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released E"), CellStates.End);

        // end state callback
        controller.gridController.getPanel().component.getActionMap()
                        .put(CellStates.End, new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (Cell.selection != CellStates.End) {
                                    Cell.selection = CellStates.End;
                                    modeArea.setText(CellStates.End.toString());
                                } else {
                                    Cell.selection = CellStates.Blank;
                                    modeArea.setText(CellStates.Blank.toString());
                                }
                            }
                        });
    }

    // used when pathfinder is active to stop changing state of cells whilst running pathfinding
    public void setGridActive(boolean active) {
        Cell.acceptInput = active;
    }
}
