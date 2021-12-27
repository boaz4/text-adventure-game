package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class pen implements Item {

    boolean isAnchored = false;

    @Override
    public String getItemDescription() {
        return "This is a pen!";
    }


    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Write");
    }

}
