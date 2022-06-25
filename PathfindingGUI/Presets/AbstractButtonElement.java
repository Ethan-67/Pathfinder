package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* AbstractButtonElement is extended by all buttons by presets, provides methods to buttons to change manipulate button
* when selected and unselected.
*/
public abstract class AbstractButtonElement extends AbstractGUIElement {

    private boolean selected = false;

    //@Override
    public void daw(JFrame window) {
        window.add(component);
        component.setVisible(true);
    }

    public void setSelected() {
        selected = true;
        component.setBackground(Color.blue);
    }

    public void setUnselected() {
        selected = false;
        component.setBackground(Color.gray);
    }

    public boolean isSelected() {
        return selected;
    }
}
