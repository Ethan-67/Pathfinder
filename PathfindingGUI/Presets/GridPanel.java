package PathfindingGUI.Presets;

import PathfindingGUI.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/* GridPanel positioned to right of window, creates a panel and allows cells to be added to the panel.
*/
public class GridPanel extends AbstractPanelElement {
    public GridPanel(String name) {
        createComponent(name);
        modifyConstraints();
        setLayoutToGridBag();
    }

    private void createComponent(String name) {
        component = new JPanel();
        component.setBackground(Color.black);
        component.setMinimumSize(new Dimension(450, 800));
        component.setName(name);
    }

    private void modifyConstraints() {
        GridBagConstraints constraints = getConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.55f;
        constraints.weighty = 0.5f;
        constraints.gridx = 1;
        constraints.gridy = 0;

        constraints.gridwidth = 3;
        constraints.gridheight = GridBagConstraints.REMAINDER;
    }

    public void addCellsToPanel(ArrayList<Cell> cellList) {
        for (Cell cell : cellList) {
            component.add(cell.component, cell.getConstraints());
        }
    }
}
