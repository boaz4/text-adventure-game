package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

/**
 * @author Andrew Noonan
 */
public class bagOfOldCoins implements Item {

    boolean isAnchored = true;

    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "A bag of old, now worthless coins.";
    }

    /**
     * return true if item can be picked up and moved.
     * return false if item cannot be picked up and moved. 
     *
     * @return False
     */
    @Override
    public boolean isTransferable() {
        return !true;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("bagOfCoins", "oldCoinBag", "oldCoins");
    }

}