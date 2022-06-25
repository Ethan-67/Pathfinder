package PathfindingGUI;

import PathfindingGUI.Presets.*;

import java.security.InvalidParameterException;

/* GUIElementFactory handles the creation of all GUI elements in application. Used in GUI class.
*/
public class GUIElementFactory implements Factory {

    // used to store and retrieve specific elements
    GUIElementHashMap guiElementHashMap;

    public GUIElementFactory(GUIElementHashMap guiElementHashMap) {
        this.guiElementHashMap = guiElementHashMap;
    }

    // create GUI element functions as a normal Factory except it automatically adds all constructed elements into the
    // guiElementHashMap instance
    @Override
    public AbstractGUIElement createGUIElement(GUIElementsEnum GUIElement, String name) throws InvalidParameterException {
        AbstractGUIElement constructedElement;
        switch (GUIElement)
        {
            case ContentPanel: constructedElement = new ContentPanel(name);
                break;
            case GridPanel: constructedElement = new GridPanel(name);
                break;
            case ButtonPresetGray: constructedElement = new ButtonPresetGray(name);
                break;
            case ButtonPresetMedium: constructedElement = new ButtonPresetMedium(name);
                break;
            case SubControlPanel: constructedElement = new SubControlPanel(name);
                break;
            case TextPreset: constructedElement = new TextPreset(name);
                break;
            case SliderPreset: constructedElement = new SliderPreset(name);
                break;
            default:
                throw new InvalidParameterException();
        }

        // add GUI element to hashmap so it can be stored and retrieve later if needed
        guiElementHashMap.put(GUIElement, constructedElement);
        return constructedElement;
    }
}
