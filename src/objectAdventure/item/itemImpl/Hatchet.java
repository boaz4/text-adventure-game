package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

/**
 * @author jcance1
 */
public class Hatchet implements Item {

    boolean isAnchored = true;

    @Override
    public String getItemDescription() {
        return "The edge of the blade is chipped and the handle is worn.";
    }

    @Override
    public boolean isTransferable() {
        return isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Hatchet","Axe");
    }

}