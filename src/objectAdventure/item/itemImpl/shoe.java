package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

/**
 * @author ddiaz8
 */
public class shoe implements Item {

    boolean isAnchored = true;

    @Override
    public String getItemDescription() {
        return "This is one stinky shoe with no shoe laces.";
    }

    @Override
    public boolean isTransferable() {
        return isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("shoe", "sneaker");
    }

}
