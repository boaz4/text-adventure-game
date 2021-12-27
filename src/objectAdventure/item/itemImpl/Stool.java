package objectAdventure.item.itemImpl;

import java.util.List;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;

public class Stool implements Item {

    private boolean isPlayerHolding = false;
    private boolean isAnchored = false;
    private String descString;

    public Stool() {
        this.descString = "A wooden stool.";
    }

    public String getItemDescription() {
        return this.descString;
    }

    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Stool", "Footstool");
    }

    @Override
    public void interactionEvent(ItemInteraction ie) {
        switch(ie) {
            case USE:
                if(isPlayerHolding) {
                    System.out.println("You set the stool down for a moment and sit. It's nice to rest your feet.");
                }
                break;

            case DROP:
                System.out.println("DROP case: The stool has been dropped.");
                isPlayerHolding = false;
                break;

            case INSPECT:
                System.out.println("This could be used to reach something.");
                break;

            case TAKE:
                System.out.println("TAKE case: The stool has been taken.");
                isPlayerHolding = true;
                break;
        }
    }
}
