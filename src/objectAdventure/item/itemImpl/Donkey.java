/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectAdventure.item.itemImpl;


import objectAdventure.item.Item;

import java.util.List;

public class Donkey implements Item{
    
    
      boolean isAnchored = false;

    /**
     * THIS IS JUST A SAMPLE.
     *
     * @return The item description.
     */
    @Override
    public String getItemDescription() {
        return "This is a annoying talking donkey";
    }

    /**
     * Item Can be picked up and moved.
     *
     * @return True
     */
    @Override
    public boolean isTransferable() {
        return false;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("talking","small", "smart", "kind");
    }

}

    
    

