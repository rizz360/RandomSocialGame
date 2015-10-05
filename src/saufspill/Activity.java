package saufspill;

import java.util.ArrayList;
import java.util.Random;


public class Activity {
    
    private Random newRandom = new Random();
    private String name;
    private Boolean activated;
    private ArrayList<String> ActionList = new ArrayList();
    
    public Activity(String newName) {
        activated = true;
        name = newName;
        //ActionHandler.getInstance().addActivity(this);
    }
    
    public Activity addAction(String newAction) {
        ActionList.add(newAction);
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRandomAction() {
        String currAction = ActionList.get(newRandom.nextInt(ActionList.size()));
        //currAction.replace("xxx", ActionHandler.getInstance().getRandomPlayer());
        return getName() + ":\n" + currAction.replace("xxx", ActionHandler.getInstance().getRandomPlayer());
    }
    
    public void setState(Boolean state) {
        activated = state;
    }
    
    public Boolean isActive() {
        return activated;
    }
    
}
