package PathfindingGUI;

import PathfindingGUI.Presets.AbstractGUIElement;

import java.util.ArrayList;

/* PanelBehaviour allows panels to extend different behaviours that can act upon the GUI elements they encapsulate.
*/
public abstract class PanelBehaviour {

    // amount of elements panel has
    ArrayList<AbstractGUIElement> elements = new ArrayList<AbstractGUIElement>();

    // extending classes override this method to implement desired functionality.
    public abstract void handleElement(AbstractGUIElement element);
}
