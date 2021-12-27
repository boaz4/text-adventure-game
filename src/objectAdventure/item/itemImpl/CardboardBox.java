package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class CardboardBox implements Item {

    boolean isAnchored = false;

    /**
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
         return "A cardboard box, you could probably fit under it once assembled.";
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
        return List.of("Cardboard Box","Cardboard","Cardboard_Box");
    }

}
