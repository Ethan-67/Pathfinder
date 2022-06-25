package PathfindingGUI;

import PathfindingGUI.Presets.AbstractGUIElement;

/* Factory functional interface implemented by GUIElementFactory
*/
public interface Factory {
    AbstractGUIElement createGUIElement(GUIElementsEnum GUIElement, String name);
}
