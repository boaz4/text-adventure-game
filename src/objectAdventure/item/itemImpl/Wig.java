/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import java.util.List;


/**
 *
 * @author rmenen1
 */
public class Wig implements Item {
    
    boolean isAnchored = false;
    
     /**
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a poppin' wig!";
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
        return List.of("wig", "Wig");
    }
    
}
