package saufspill;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ActionHandler {
    
    private static ActionHandler HighActions = null;
    
    private ArrayList<Activity> Activities = new ArrayList();
    private ArrayList<Activity> ActiveActivities = new ArrayList();
    private Random newRandom = new Random();
    
    private ActionHandler() {
        initActivities();
    }
    
    public static ActionHandler getInstance() {
        if(HighActions==null) HighActions = new ActionHandler();
        return HighActions;
    }
    
    public Activity addActivity(Activity newActivity) {
        Activities.add(newActivity);
        return newActivity;
    }
    
    public String getRandomPlayer() {
        String test = GUIHandler.getInstance().getMainGUI().getRandomPlayer();
        if(test==null) return null;
        return test;
    }
    
    
    private void initActivities() {
        
        addActivity(new Activity("Joker"))
                .addAction("On your next turn you can chose someone else to do your activity")
                .addAction("You skip this turn")
                ;
        
        addActivity(new Activity("TruthLove"))
                .addAction("Who was your ugliest partner and why?")
                .addAction("Who do you love?")
                .addAction("Who's the sexiest person that you know?")
                .addAction("Message your love and tell him/her the truth")
                .addAction("Have you ever cheated on your partner/one of your exes?")
                ;
        
        addActivity(new Activity("TruthSex"))
                .addAction("If you were homosexual, which of your friends would you find the hottest")
                .addAction("Have you catched your parents during 'the act', tell the story")
                .addAction("What's the worst thing about being your gender?")
                .addAction("Name 5 things that you love to hear during sex")
                .addAction("How often do you masterbate per week?")
                ;
        
        addActivity(new Activity("TruthFunny"))
                .addAction("Tell us the dumbest nightmare that has actually scared you")
                .addAction("Do you take a look at the toilet before you flush?")
                .addAction("Did you have strange habbits as a child, if yes which?")
                .addAction("If you could have anyone here in the room to be your slave, who would it be and what would you make them do?")
                .addAction("What is the stupidest thing you've done on your own free will?")
                .addAction("What is the stupidest thing you've done because someone dared you to?")
                .addAction("Have you ever made an ass of yourself in front of someone you were interested in?")
                .addAction("What's the most embarrassing thing that has ever happened to you?")
                ;
        
        addActivity(new Activity("TruthCasual"))
                .addAction("Describe yourself at age of 30")
                .addAction("What's the worst memory of your childhood")
                .addAction("What's the favorite attribute about xxx")
                .addAction("What commercial would you like to be in")
                .addAction("When was the last time you lied, and why?")
                .addAction("Tell the group your greatest secret")
                .addAction("What's your greatest regret?")
                .addAction("Tell the group something you have never told anybody else")
                .addAction("If you had 24 hours to live, what would you do?")
                .addAction("If you were invisible, what would be the first thing you do?")
                .addAction("If you could have one super-power, which would it be and why?")
                .addAction("If you could be born again would choose to be a different gender?")
                .addAction("What's a phrase that someone can say, and you instantly know that you won't like them?")
                ;
        
//==============================================================================        
        
        addActivity(new Activity("DareSex"))
                .addAction("Touch yourself erotically for 10 seconds")
                .addAction("Kiss and suck a beer bottle as if you were giving a blowjob")
                .addAction("Swap your shirt with xxx")
                .addAction("Get a love bite by xxx (anywhere)")
                .addAction("If your in a public place, run across the room and scream 'I WANT TO FUCK'")
                .addAction("Let somebody eat something from your body")
                .addAction("Chose a person, with whom you simulate your favorite sex-postion")
                .addAction("Fake an orgasm for 10 seconds")
                .addAction("Remove one part of your clothing")
                .addAction("Draw the most dirty thing that comes in your mind")
                .addAction("Kiss someone of the same gender")
                ;
        
        addActivity(new Activity("DareFunny"))
                .addAction("Wear a selfmade turban for 5 turns")
                .addAction("Call your parents and ask them whether it's okay for you to leave the country for 2 days")
                .addAction("Talk in a fake accent for 3 rounds")
                .addAction("Hop around like a rabbit")
                .addAction("Let an ice cube melt in your pants")
                .addAction("Have a loud discussion with a wall for 60 seconds")
                .addAction("High-Five everyone in the room")
                .addAction("Get spanked by xxx")
                .addAction("Carry xxx across the room (at least 15 seconds)")
                .addAction("Spin around 10 times and then walk in a straight line singing a child-song")
                .addAction("Tie your shoes together and walk as fast as you can across the room for 60 seconds")
                .addAction("Let the group chose a contact from your phone. You have to call that person and moan in the microphone for 10 seconds")
                .addAction("Simulate a death scene")
                .addAction("Bite your big toe")
                .addAction("Go with a person of your choice to the toilet and trade all of your cloths")
                .addAction("Try to itch your armpit with your big toe")
                .addAction("Make-out with a pillow or something compareable for a 60 seconds")
                .addAction("Run across the room for 60 seconds and simulate a plane")
                .addAction("Let xxx set your facebook status")
                .addAction("Make loud fart noices for 60 seconds")
                ;
        
        addActivity(new Activity("DareCasual"))
                .addAction("Say two really nice things about each player")
                .addAction("For guys: Get some Make-Up / For girls: Remove your make-up")
                .addAction("Get a snack and eat it out of xxx's hands, without using your own hands")
                .addAction("Hum the title melody from a movie of your choice. The group has to recoginze it.")
                ;
    
        addActivity(new Activity("DareDrinking"))
                .addAction("Drink one shot")
                .addAction("Drink a whole bottle of soda at once")
                ;
        
        addActivity(new Activity("DareDisgusting"))
                .addAction("Let xxx purpose you something disgusting to eat")
                .addAction("Let xxx chose a drink for you, which you have to drink")
                ;
        
        /*
        
        addActivity(new Activity("Test"))
                .addAction("blablabla " + "xxx")
               ;
        */ 
        
        
        refreshActiveActivities();
    }
    
    public void refreshActiveActivities() {         //Should be called at the beginning and everytime the settings change
        ActiveActivities.clear();
        for(Activity temp : Activities) {
            if(temp.isActive()) ActiveActivities.add(temp);
        }
    }
    
    public Vector<String> getActivityList() {
        Vector<String> tempV = new Vector();
        for(Activity tempA : Activities) {
            tempV.add(tempA.getName());
        }
        return tempV;
    }
    
    public void setActivityStates(int[] ActiveIndices) {
        
        if(ActiveIndices.length==0) return;
        
        for(Activity temp : Activities) {
            temp.setState(false);
        }
        
        for(int j=0; j<ActiveIndices.length;j++) {
            Activities.get(ActiveIndices[j]).setState(true);
            System.out.println(Activities.get(ActiveIndices[j]).getName() + " activated!");
        }
        
        refreshActiveActivities();
        
        System.out.println("");
        
    }
    
    public String getRandomActivity() {
        return ActiveActivities.get(newRandom.nextInt(ActiveActivities.size())).getRandomAction();
    }
    
    
    
}
