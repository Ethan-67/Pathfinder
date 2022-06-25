package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* AbstractGUIElement is extended by all GUI elements used in the application (only JFrame does not extend this).
* provides child classes access to a JComponent and overrideable constraints to provide to GridBagLayout
*
*/
public abstract class AbstractGUIElement {

    public JComponent component;

    private GridBagConstraints constraints;

    // creates default constraints all gui element can use and can override to be specific
    AbstractGUIElement() {
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);
    }

    public void draw(JFrame window)
    {
        window.add(component, constraints);
        component.setVisible(true);
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public void setName(String name) {
        component.setName(name);
    }
}
