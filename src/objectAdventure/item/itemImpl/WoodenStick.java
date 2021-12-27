package objectAdventure.item.itemImpl;

import java.util.List;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;

public class WoodenStick implements Item {

    private boolean isPlayerHolding = false;
    private boolean isAnchored = false;
    private String descString;

    public WoodenStick() {
        this.descString = "A wooden stick on the ground.";
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
        return List.of("Stick", "Beam", "Wood");
    }

    @Override
    public void interactionEvent(ItemInteraction ie) {
        switch(ie) {
            case USE:
                if(isPlayerHolding) {
                    System.out.println("This will be of use later.");
                }
                break;

            case DROP:
                System.out.println("DROP case: The stick has been dropped.");
                isPlayerHolding = false;
                break;

            case INSPECT:
                System.out.println("This seems to be a broken piece from the ladder.");
                break;

            case TAKE:
                System.out.println("TAKE case: The stick has been taken.");
                isPlayerHolding = true;
                break;
        }
    }
}
