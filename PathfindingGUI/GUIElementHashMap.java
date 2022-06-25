package PathfindingGUI;

import PathfindingGUI.Presets.*;

import java.util.ArrayList;
import java.util.HashMap;

/* GUIElementHashMap handles storing and retrieving all GUI elements by adding additional functionality to a hashmap
*/
public class GUIElementHashMap {

    // store all GUI elements in hashmap
    private HashMap<String, AbstractGUIElement> guiElementHashMap;
    // store all currently available keys for each preset
    private ArrayList<Integer> currentKeys;

    public GUIElementHashMap() {
        guiElementHashMap = new HashMap<String, AbstractGUIElement>();
        currentKeys = new ArrayList<Integer>();

        // foreach preset add a initial key value
        for (GUIElementsEnum elementsEnum : GUIElementsEnum.values()) {
            currentKeys.add(-1);
        }
    }

    // add elements to hashmap
    public void put(GUIElementsEnum key, AbstractGUIElement value) {
        // increment corresponding current key for value being passed
        currentKeys.set(key.ordinal(), (currentKeys.get(key.ordinal()))+1);

        // create a string to contain the name of element and the number of current keys for that element
        String stringKey = key.toString();
        stringKey += currentKeys.get(key.ordinal());

        guiElementHashMap.put(stringKey, value);
    }

    public void remove(String key) {
        guiElementHashMap.remove(key);
    }

    public int size() {
        return guiElementHashMap.size();
    }

    public ArrayList<AbstractGUIElement> getAllValues() {
        return (ArrayList<AbstractGUIElement>) guiElementHashMap.values();
    }

    public void print() {
        System.out.println();
        for (AbstractGUIElement element : guiElementHashMap.values()) {
            System.out.println(element.component.getName());
        }
        System.out.println();
    }

    // returns all buttons currently stored in hashmap
    public ArrayList<AbstractButtonElement> getAllButtons() {
        ArrayList<AbstractButtonElement> buttonList = new ArrayList<AbstractButtonElement>();
        for (AbstractGUIElement guiElement : guiElementHashMap.values()) {
            if (guiElement instanceof AbstractButtonElement) {
                buttonList.add((AbstractButtonElement) guiElement);
            }
        }
        return buttonList;
    }


    public GridPanel getGridPanel() {
        return (GridPanel) guiElementHashMap.get("GridPanel0");
    }

    public SliderPreset getSlider() {
        return (SliderPreset) guiElementHashMap.get("SliderPreset0");
    }

    public TextPreset getModeArea() {
        return (TextPreset) guiElementHashMap.get("TextPreset0");
    }
}
