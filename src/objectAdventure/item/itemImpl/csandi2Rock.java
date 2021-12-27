package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;
import objectAdventure.pattern.Observable;
import objectAdventure.pattern.Observer;

import java.util.List;

public class csandi2Rock implements Item, Observable<Boolean> {

    private boolean isAnchored = false;
    private boolean isPlayerHoldingCsandi2Rock = false;
    private String descString;

    public csandi2Rock() {
        this.descString = "Cole's rock.";
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
        return List.of("Rock", "Cole's rock");
    }


    @Override
    public void interactionEvent(ItemInteraction ie) {
        switch (ie) {
            case DROP:
                System.out.println("Cole's rock has been dropped!");
                isPlayerHoldingCsandi2Rock = false;
                break;

            case TAKE:
                System.out.println("Cole's rock has been taken!");
                isPlayerHoldingCsandi2Rock = true;
                break;

            case USE:
                if (isPlayerHoldingCsandi2Rock) {
                    this.descString = "A rock that belongs to Cole.";
                }
                break;

            case INSPECT:
                if (isPlayerHoldingCsandi2Rock) {
                    this.descString = "A thoroughly used rock.";
                }
                break;
        }
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
