package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.Collections;

import java.util.List;

public class FreezeGun implements Item {

    boolean isAnchored = false;

    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This Gun was taken after the defeat of Mr. Freeze, it can encase anything it shoots at to ice, they may come in handy!";
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
        return List.of("FreezeGun", "Ice Weapon", "Ice Blaster");
    }

}
