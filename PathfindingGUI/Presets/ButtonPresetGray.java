package PathfindingGUI.Presets;

import PathfindingGUI.Presets.AbstractButtonElement;

import javax.swing.*;
import java.awt.*;

public class ButtonPresetGray extends AbstractButtonElement {

    public ButtonPresetGray(String name)
    {
        component = new JButton();
        component.setBackground(Color.gray);
        component.setName(name);
        ((JButton) component).setText(name);
    }

    private void modifyConstraints() {
        GridBagConstraints constraints = getConstraints();

        constraints.gridwidth = 2;
        constraints.gridheight = 1;
    }
    public void changeSpace(int row, int col) {
        GridBagConstraints constraints = getConstraints();

        constraints.gridx = col;
        constraints.gridy = row;
    }
}
