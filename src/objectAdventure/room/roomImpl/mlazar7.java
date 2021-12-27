/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectAdventure.room.roomImpl;
import objectAdventure.item.itemImpl.Donkey;
import objectAdventure.room.AbstractRoom;
/**
 *

 */
public class mlazar7 extends AbstractRoom {
    
    public mlazar7(){
    
    super(24);

        super.setDescription("In a land.. far far away.");
        
        super.addItem(new Donkey());  
    
}
}

