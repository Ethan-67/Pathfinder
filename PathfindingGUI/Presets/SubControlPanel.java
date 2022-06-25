package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* SubControlPanel encapsulates GUI elements, placed inside of a ContentPanel and allows functionality to set
* it's own row and column externally
*/
public class SubControlPanel extends AbstractPanelElement {
    public SubControlPanel(String name) {
        component = new JPanel();
        component.setBackground(Color.lightGray);
        component.setName(name);

        // parent method
        setLayoutToGridBag();
        modifyConstraints();
    }

    private void modifyConstraints() {
        GridBagConstraints constraints = getConstraints();
        constraints.weightx = 0.05f;
        constraints.weighty = 0.05f;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
    }

    public void setRowAndColumn(int row, int column) {
        GridBagConstraints constraints = getConstraints();
        constraints.gridy = row;
        constraints.gridx = column;
    }
}
