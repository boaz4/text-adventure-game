package objectAdventure.item.itemImpl;

import java.util.List;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;

public class WeakLock implements Item {

    private boolean isAnchored = true;
    private String descString;

    public WeakLock() {
        this.descString = "A lock, preventing you from going upstairs.";
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
        return List.of("Lock", "Padlock");
    }

    @Override
    public void interactionEvent(ItemInteraction ie) {
        // Unimplemented
    }
}
