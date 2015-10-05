
package saufspill;



public class GUIHandler {
    
    private static GUIHandler HighGUIHandler = null;
    private GUI mainGUI;
    private GUI_Settings settingsGUI;
    
    private GUIHandler() {
        
    }
    
    public void init() {
        mainGUI = new GUI();
        mainGUI.setVisible(true);
        
        settingsGUI = new GUI_Settings();
        settingsGUI.setVisible(false);
        
        loadActivities();
        settingsGUI.getCategorySettings().setSelectionInterval(0, settingsGUI.getCategorySettings().getModel().getSize()-1);
        
    }
    
    public static GUIHandler getInstance() {
        if (HighGUIHandler == null) HighGUIHandler = new GUIHandler();
        return HighGUIHandler;
    }
    
    private void loadActivities() {
        settingsGUI.getCategorySettings().setListData(ActionHandler.getInstance().getActivityList());
    }
    
    public void setActivityState(int[] newState) {
        ActionHandler.getInstance().setActivityStates(newState);
    }
    
    public GUI getMainGUI() {
        return mainGUI;
    }
    
    public GUI_Settings getSettingsGUI() {
        return settingsGUI;
    }
    


}
