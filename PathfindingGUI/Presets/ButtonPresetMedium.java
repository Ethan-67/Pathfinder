package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

public class ButtonPresetMedium extends AbstractButtonElement {

    public ButtonPresetMedium(String name) {
        component = new JButton();
        component.setBackground(Color.gray);
        component.setName(name);
        ((JButton) component).setText(name);
    }
}
