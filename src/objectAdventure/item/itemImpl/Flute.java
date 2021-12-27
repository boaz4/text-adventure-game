package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import java.util.List;

/**
 * @author Stephanie Prem
 */
public class Flute implements Item{

    boolean isAnchored = true;

    /**
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a flute!";
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
        return List.of("Flute","Play","Instrument");
    }

}
