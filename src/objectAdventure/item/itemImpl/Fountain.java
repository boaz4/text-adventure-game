package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class Fountain implements Item {

    boolean isAnchored = true;

    /**
     * my example
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "All of a sudden you feel parched, and this fountains water looks so cold...";
    }


    @Override
    public boolean isTransferable() {
        return isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Water Fountain", "Water", "Bowl, Bath, Well, Font");
    }
}
