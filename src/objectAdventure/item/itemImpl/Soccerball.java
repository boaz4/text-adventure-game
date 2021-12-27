package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;

import objectAdventure.pattern.Observable;
import objectAdventure.pattern.Observer;


import java.util.List;

public class Soccerball implements Item, Observable<Boolean>  {

    private boolean isAnchored = true;
    private boolean isPlayerHoldingBall = false;
    private String descString;

    public Soccerball() {
        this.descString = "This is a soccer ball. Go score a goal with it.";
    }
    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return this.descString;
    }

    /**
     * Item Can be picked up and moved.
     *
     * @return True
     */

    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Soccer ball","ball","Fútbol");
    }



    @Override
    public void interactionEvent(ItemInteraction ie) {
        switch (ie) {
            case DROP:
                System.out.println("DEMO: The ball has been dropped!");
                isPlayerHoldingBall = false;
                break;

            case TAKE:
                System.out.println("DEMO: The ball has been taken!");
                isPlayerHoldingBall = true;
                break;

            case USE:
                if (isPlayerHoldingBall) {
                    this.descString = "A soccer ball that can be used to juggle with your feet or score goals.";
                }
                break;

            case INSPECT:
                if (isPlayerHoldingBall) {
                    this.descString = "A new soccer ball";
                }
                break;
        }

        // Notify all observers that something about me has (potentially) changed!
        notifyObservers();
    }
    
    @Override
    public void addObserver(Observer<Boolean> o) {
        // Method exists here just as an example and is not yet implemented.
        
    }

    @Override
    public void removeObserver(Observer<Boolean> o) {
        // Method exists here just as an example and is not yet implemented.
    }

    @Override
    public void notifyObservers() {
        // Method exists here just as an example and is not yet implemented.

        // For example: 
        // This method would notify any observers of the current state of: isPlayerHolding
    }

}