package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;
import objectAdventure.pattern.Observable;
import objectAdventure.pattern.Observer;

import java.util.List;

public class GameInstructions implements Item, Observable<Boolean> {

    private boolean isAnchored = false;
    private boolean isPlayerHoldingMap = false;
    private String descString;

    public GameInstructions() {
        this.descString = "A GameMap (Actual Image located in Game source folder).";
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
        return List.of("Map", "GameMap");
    }

    /**
     * The game controller notified the item that is has been interacted with.
     * <p>
     * NOTE: From naming perspective the class called *ItemInteraction* should really be called
     * *InteractionEvent* and the method being overridden should be called *handleItemInteraction()*.
     * <p>
     * However, I don't want to actually change it now because that would break anyone's code that
     * is already relying on those names. Global project refactoring is nice, but you can't refactor
     * code that isn't under your control!
     * <p>
     * <p>
     * NOTE: This method acts EXACTLY like the "setValue" in the Observer Example (in the Examples
     * code)... just a method being called that potentially changes and object in some way that
     * another object is interested in.
     * <p>
     * In fact, the Item could easily be BOTH an Observer AND Observable (observing events which it
     * then forwards on to its own observers)! But, because EVERY item receives the exact same
     * information, make it an "observer" of the game controller is unnecessary. The observer
     * pattern makes most sense when only some Objects are observable and others are not or
     * Observable items are observed by many other kinds of objects.
     *
     * @param ie The ItemInteraction info. The actual parameter is an enum (singleton) value of one
     *           of the following:<br>
     *           <br>
     *           ItemInteraction.DROP -- When the player types "drop [item]"<br>
     *           ItemInteraction.TAKE -- When the player types "get [item]"<br>
     *           ItemInteraction.USE -- When the player types "use [item]"<br>
     *           ItemInteraction.INSPECT -- When the player types "inspect [item]"<br>
     */
    @Override
    public void interactionEvent(ItemInteraction ie) {
        switch (ie) {
            case DROP:
                System.out.println("DEMO: The map has been dropped!");
                isPlayerHoldingMap = false;
                break;

            case TAKE:
                System.out.println("DEMO: The map has been taken!");
                isPlayerHoldingMap = true;
                break;

            case USE:
                if (isPlayerHoldingMap) {
                    this.descString = "A map which appears to have been refolded with great frustration.";
                }
                break;

            case INSPECT:
                if (isPlayerHoldingMap) {
                    this.descString = "A thoroughly inspected map.";
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
