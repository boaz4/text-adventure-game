package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class Rod implements Item {

    boolean isAnchored = true;

    /**
     * my example
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a Jellyfish Rod!";
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
        return List.of("Rod","Jellyfish_Rod","longrod");
    }

}