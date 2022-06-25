package PathfindingGUI.Presets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

/* SliderPreset is a slider which allows the speed of the pathfinder to be set. Works by adding a callback when the
* slider is changed which then sets a speed value to keep track of the current speed.
*/
public class SliderPreset extends AbstractGUIElement {

    private int speed;

    public SliderPreset(String name) {
        createComponent(name);
        modifyConstraints();
        addChangeCallback();
    }

    private void createComponent(String name) {
        component = new JSlider(0, 100);
        component.setName(name);
        JSlider sliderCast = (JSlider) component;
        sliderCast.setPaintTicks(false);
    }

    private void modifyConstraints() {
        getConstraints().weightx = 0.05f;
        getConstraints().weighty = 0.05f;
    }

    private void addChangeCallback() {
        ((JSlider) component).addChangeListener((ChangeEvent e) -> {
            setSpeed(((JSlider) e.getSource()).getValue());
        });
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
