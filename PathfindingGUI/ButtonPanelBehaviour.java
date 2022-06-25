package PathfindingGUI;

import PathfindingGUI.Presets.AbstractButtonElement;
import PathfindingGUI.Presets.AbstractGUIElement;

import javax.swing.*;

/* ButtonPanelBehaviour allows a SubControlPanel to toggle selection between a single active button
*/
public class ButtonPanelBehaviour extends PanelBehaviour {

    // number of selected button
    int selectedIndex = 0;

    @Override
    public void handleElement(AbstractGUIElement element) {
        // add button to elements
        elements.add(element);

        // add callback to every button
        ((JButton) element.component).addActionListener((e) -> {
            handleButtonSelection(elements.indexOf(element));
        });
    }

    // call back to all child buttons of a SubControlPanel
    public void handleButtonSelection(int selection) {
        for (int i = 0; i < elements.size(); i++) {
            AbstractButtonElement abstractButtonCast = (AbstractButtonElement) elements.get(i);

            // if this button was clicked set it as selected and continue
            if (i == selection) {
                abstractButtonCast.setSelected();
                selectedIndex = i;
                continue;
            }
            // set rest to unselected
            abstractButtonCast.setUnselected();
        }
    }
}
