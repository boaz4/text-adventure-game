package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;
import objectAdventure.pattern.Observer;

import java.util.List;

public class DemoItem implements Item {

    private boolean isAnchored = false;
    private String descString;

    public DemoItem() {
        this.descString = "An item for demonstration purposes.";
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
        return List.of("Sample", "Demo", "Mysterious thing");
    }

}
