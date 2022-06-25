package PathfindingGUI.Presets;

import PathfindingGUI.PanelBehaviour;

import java.awt.*;

/* AbstractPanelElement is extended by all panel elements in GUI. Allows panels to select their own behaviour,
*
*/
public abstract class AbstractPanelElement extends AbstractGUIElement {

    public PanelBehaviour behaviour;

    public void setLayoutToGridBag() {
        component.setLayout(new GridBagLayout());
    }

    public void addChild(AbstractGUIElement element) {
        component.add(element.component, element.getConstraints());

        if (behaviour != null)
            behaviour.handleElement(element);
    }

    public void setBehaviour(PanelBehaviour newBehaviour) {
        this.behaviour = newBehaviour;
    }

}
