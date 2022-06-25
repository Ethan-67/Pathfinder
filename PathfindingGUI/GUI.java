package PathfindingGUI;

import PathfindingGUI.Presets.*;

/* Handles adding graphical components to GUI
 */
public class GUI {

    public ConcreteWindow window;

    private GUIElementFactory elementFactory;

    private GUIElementHashMap guiElements;

    private GridController gridController;

    public GUI()
    {
        guiElements = new GUIElementHashMap();
        elementFactory = new GUIElementFactory(guiElements);
        constructGUI();
    }

    private void constructGUI()
    {
        // create window
        constructWindow();
        // handle creation of main GUI panels
        AbstractPanelElement gridPanel = createGridPanel();
        AbstractPanelElement contentPanel = createContentPanel();
        // add panels to the window
        addGridContentPanelToWindow(gridPanel, contentPanel);
        setVisible(true);
    }

    private void constructWindow()
    {
        window = new ConcreteWindow("Window");
    }

    private AbstractPanelElement createGridPanel() {
        GridPanel gridPanel = (GridPanel) elementFactory.createGUIElement(GUIElementsEnum.GridPanel,
                "Grid Panel");

        gridController = new GridController(gridPanel);
        gridController.addCellsToPanel();
        return gridPanel;
    }

    private AbstractPanelElement createContentPanel() {
        ContentPanel contentPanel = (ContentPanel) elementFactory.createGUIElement(GUIElementsEnum.ContentPanel,
                "Content Panel");
        addControls(contentPanel);
        return contentPanel;
    }

    // create all sub control panels and add them to the content panel
    private void addControls(AbstractPanelElement contentPanel)
    {
        SubControlPanel modePanel = createModeSubPanel();
        SubControlPanel startStopPanel = createStartStopSubPanel();
        SubControlPanel layoutPanel = createLayoutSubPanel();
        SubControlPanel algorithmPanel = createAlgorithmSubPanel();
        SubControlPanel infoPanel = createInfoSubPanel();

        contentPanel.addChild(modePanel);
        contentPanel.addChild(startStopPanel);
        contentPanel.addChild(layoutPanel);
        contentPanel.addChild(algorithmPanel);
        contentPanel.addChild(infoPanel);
    }

    // ModeSubPanel created with a slider to set pathfinder speed and mode area text which shows user what mode they are
    // in
    private SubControlPanel createModeSubPanel() {
        SubControlPanel modePanel = (SubControlPanel) elementFactory.createGUIElement(GUIElementsEnum.SubControlPanel,
                "Slider Panel");
        modePanel.setRowAndColumn(1, 1);
        modePanel.setBehaviour(new StaticPanelBehaviour());

        SliderPreset speedSlider = (SliderPreset) elementFactory.createGUIElement(GUIElementsEnum.SliderPreset,
                "Slider");
        TextPreset modeArea = (TextPreset) elementFactory.createGUIElement(GUIElementsEnum.TextPreset, "Mode text");
        modeArea.setText(CellStates.Blank.toString());

        modePanel.addChild(speedSlider);
        modePanel.addChild(modeArea);
        return modePanel;
    }

    // StartStopPanel controls are start button to start pathfinding and stop button to stop pathfinding
    private SubControlPanel createStartStopSubPanel() {
        SubControlPanel startStopPanel = (SubControlPanel) elementFactory.createGUIElement(GUIElementsEnum.SubControlPanel,
                "Start Stop Button Panel");
        startStopPanel.setRowAndColumn(2, 1);
        startStopPanel.setBehaviour(new ButtonPanelBehaviour());

        ButtonPresetGray startButton = (ButtonPresetGray) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetGray,
                "Start");

        ButtonPresetGray stopButton = (ButtonPresetGray) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetGray,
                "Stop");

        startStopPanel.addChild(startButton);
        startStopPanel.addChild(stopButton);
        return startStopPanel;
    }

    // LayoutSubPanel has controls for each layout available which are Blank, Wall and Maze
    private SubControlPanel createLayoutSubPanel() {
        SubControlPanel layoutPanel = (SubControlPanel) elementFactory.createGUIElement(GUIElementsEnum.SubControlPanel,
                "Layout Button Panel");
        layoutPanel.setRowAndColumn(3, 1);
        layoutPanel.setBehaviour(new ButtonPanelBehaviour());

        ButtonPresetMedium layoutBlankButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "Blank");

        ButtonPresetMedium layoutMazeButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "Maze");

        ButtonPresetMedium layoutWallButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "Wall");

        layoutPanel.addChild(layoutBlankButton);
        layoutPanel.addChild(layoutMazeButton);
        layoutPanel.addChild(layoutWallButton);
        return layoutPanel;
    }

    // AlgorithmSubPanel have controls for all pathfinders which consists of A*, Dijkstra and Best-First
    private SubControlPanel createAlgorithmSubPanel() {
        SubControlPanel algorithmPanel = (SubControlPanel) elementFactory.createGUIElement(GUIElementsEnum.SubControlPanel,
                "Algorithm Panel");
        algorithmPanel.setRowAndColumn(4, 1);
        algorithmPanel.setBehaviour(new ButtonPanelBehaviour());

        ButtonPresetMedium aStarAlgorithmButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "A*");

        ButtonPresetMedium dijkstraButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "Dijkstra");

        ButtonPresetMedium bestFirstButton = (ButtonPresetMedium) elementFactory.createGUIElement(GUIElementsEnum.ButtonPresetMedium,
                "Best First");

        algorithmPanel.addChild(aStarAlgorithmButton);
        algorithmPanel.addChild(dijkstraButton);
        algorithmPanel.addChild(bestFirstButton);
        return algorithmPanel;
    }

    // InfoSubPanel shows text presets of how to control states of application
    private SubControlPanel createInfoSubPanel() {
        SubControlPanel infoPanel = (SubControlPanel) elementFactory.createGUIElement(GUIElementsEnum.SubControlPanel,
                "Controls info panel");
        infoPanel.setRowAndColumn(6, 1);
        infoPanel.setBehaviour(new StaticPanelBehaviour());

        TextPreset wallInfo = (TextPreset) elementFactory.createGUIElement(GUIElementsEnum.TextPreset, "Wall text");
        wallInfo.setText("Press W + hover for walls");

        TextPreset startInfo = (TextPreset) elementFactory.createGUIElement(GUIElementsEnum.TextPreset, "Start text");
        startInfo.setText("Press S + click for starting point");

        TextPreset endInfo = (TextPreset) elementFactory.createGUIElement(GUIElementsEnum.TextPreset, "End text");
        endInfo.setText("Press E + click for end point");

        infoPanel.addChild(wallInfo);
        infoPanel.addChild(startInfo);
        infoPanel.addChild(endInfo);
        return infoPanel;
    }

    private void addGridContentPanelToWindow(AbstractPanelElement gridPanel, AbstractPanelElement contentPanel) {
        window.addChild(gridPanel);
        window.addChild(contentPanel);
    }

    public void setVisible(boolean visible)
    {
        window.setVisible(visible);
    }

    public GUIElementHashMap getElements() {
        return guiElements;
    }

    public GridController getGridController() {
        return gridController;
    }
}
