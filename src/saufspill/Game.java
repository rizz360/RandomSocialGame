package saufspill;

import java.util.Random;

public class Game {
    
    private static Game HighGame = null;
    private int diceSize = 6;
    private Random myRandom = new Random();
    private String title = "Saufspill v0.5";
    
    private Game() {
    }
    
    public static Game getInstance() {
        if(HighGame==null) HighGame = new Game();
        return HighGame;
    }
    
    public void setDice(int newSize) {
        diceSize=newSize;
    }
    
    public void init() {
        //myGUI = new GUI();
        //myGUI.setVisible(true);
        GUIHandler.getInstance().init();
    }
    
    public int rollDice() {
        int newRandom = myRandom.nextInt(diceSize)+1;
        
        String currPlayer = GUIHandler.getInstance().getMainGUI().getAndSelectRandomPlayer();
        System.out.println("Current Player is: " + currPlayer);
        
        
        String currAction = ActionHandler.getInstance().getRandomActivity();
        System.out.println("Current Action is: " + currAction);
        GUIHandler.getInstance().getMainGUI().setCurrAction(currAction);
        System.out.println("");
        return newRandom;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void quit() {
        System.exit(0);
    }
}
    

