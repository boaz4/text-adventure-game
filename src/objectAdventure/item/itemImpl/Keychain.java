/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectAdventure.item.itemImpl;
import java.util.List;
import objectAdventure.item.Item;

/**
 *
 * @author matt arceo
 */
public class Keychain implements Item {
    
    boolean isAnchored = true;

    /**
     * Description of the item.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This keychain will manifest into one's deepest desire...";
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
        return List.of("Chain","Pendant","Keyring");
    }
}
