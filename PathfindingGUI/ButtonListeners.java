package PathfindingGUI;

import PathfindingGUI.Presets.AbstractButtonElement;

import javax.swing.*;
import java.util.ArrayList;

/* ButtonListeners assign a callback to GUIController dependent on which button has been pressed.
*/
public class ButtonListeners {

    // assign listeners
    public static void assignButtonListeners(GUIController controller, ArrayList<AbstractButtonElement> buttonList)
            throws RuntimeException {
        for (AbstractButtonElement button : buttonList) {
            JButton buttonComponent = (JButton) button.component;

            // add unique callback to each button
            if (buttonComponent.getText() == "Start") {
                buttonComponent.addActionListener((e) -> {
                    controller.start();
                });
            }
            else if (buttonComponent.getText() == "Stop") {
                buttonComponent.addActionListener((e) -> {
                    controller.stop();
                });
            }
            else if (buttonComponent.getText() == "Blank") {
                buttonComponent.addActionListener((e) -> {
                    controller.blankLayout();
                });
            }
            else if (buttonComponent.getText() == "Maze") {
                buttonComponent.addActionListener((e) -> {
                    controller.mazeLayout();
                });
            }
            else if (buttonComponent.getText() == "Wall") {
                buttonComponent.addActionListener((e) -> {
                    controller.wallLayout();
                });
            }
            else if (buttonComponent.getText() == "A*") {
                buttonComponent.addActionListener((e) -> {
                    controller.loadAStar();
                });
            }
            else if (buttonComponent.getText() == "Dijkstra") {
                buttonComponent.addActionListener((e) -> {
                    controller.loadDijkstra();
                });
            }
            else if (buttonComponent.getText() == "Best First") {
                buttonComponent.addActionListener((e) -> {
                    controller.loadBestFirst();
                });
            }
            else {
                throw new RuntimeException("ButtonNotFound");
            }
        }
    }
}
