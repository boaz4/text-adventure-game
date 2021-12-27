/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectAdventure.room.roomImpl;

import objectAdventure.room.AbstractRoom;

import objectAdventure.item.itemImpl.Cauldron;


/**
 *
 * @author lana
 */
public class WitchDen extends AbstractRoom {
   
    public WitchDen() {
   
        super(29);

        super.setDescription("This is a witch's den. Proceed with caution.");
        
        super.addItem(new Cauldron());   
        
    } 
    
    @Override
    public String getRoomAuthor() {
        return "Alanah Bell";
    }
    
    
}
