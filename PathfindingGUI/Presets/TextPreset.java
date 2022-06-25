package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* TextPreset places static JTextArea which can be modified externally.
*/
public class TextPreset extends AbstractGUIElement {
    public TextPreset(String name) {
        createComponent(name);
        modifyConstraints();
    }

    private void createComponent(String name) {
        component = new JTextArea();
        component.setName(name);
        ((JTextArea) component).setEditable(false);
        ((JTextArea) component).setFont(new Font("Serif", Font.ITALIC, 14));
    }

    private void modifyConstraints() {
        GridBagConstraints constraints = getConstraints();
        constraints.weightx = 0.8f;
        constraints.gridwidth = 3;
    }

    public void setText(String text) {
        ((JTextArea) component).setText(text);
    }
}
