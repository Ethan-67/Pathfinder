package PathfindingGUI;

import PathfindingGUI.Presets.AbstractGUIElement;

/* StaticPanelBehaviour supplied to fixed panels that should not exhibit any additional behaviour to their child elements
*/
public class StaticPanelBehaviour extends PanelBehaviour {
    @Override
    public void handleElement(AbstractGUIElement element) {
        // do nothing as no behaviour required
    }
}
