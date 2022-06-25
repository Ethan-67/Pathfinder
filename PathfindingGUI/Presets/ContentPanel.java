package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* ContentPanel positioned to the left of the window, holds all SubControlPanels to provide all buttons and functionality
* to GUI.
*/
public class ContentPanel extends AbstractPanelElement {

    public ContentPanel(String name) {
        component = new JPanel();
        component.setPreferredSize(new Dimension(550, 800));
        component.setBackground(Color.lightGray);
        component.setName(name);

        modifyConstraints();
        setLayoutToGridBag();
    }

    // modify own constraints
    private void modifyConstraints() {
        GridBagConstraints constraints = getConstraints();

        constraints.fill = GridBagConstraints.BOTH;

        constraints.weightx = 0.05f;
        constraints.weighty = 0.05f;
        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridwidth = 1;
        constraints.gridheight = GridBagConstraints.REMAINDER;
    }
}
