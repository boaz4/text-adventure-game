package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class Statue implements Item {

    boolean isAnchored = false;

    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a statue of an eye...you feel a cold chill from it.";
    }

    /**
     * return true if item can be picked up and moved.
     * return false if item cannot be picked up and moved. 
     *
     * @return False
     */
    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Statue","Poll");
    }

}
