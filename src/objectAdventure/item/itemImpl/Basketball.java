package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class Basketball implements Item {

    boolean isAnchored = true;

    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a basketball!";
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
        return List.of("Basketball","B-ball","Rock");
    }

}
