package objectAdventure.room.roomImpl;


import objectAdventure.item.itemImpl.hchang8Item;

import objectAdventure.room.AbstractRoom;

public class hchang8Room extends AbstractRoom{
	public hchang8Room() {
		super(4);
		
		super.setDescription("This is the Hanna's room.");
        
        super.addItem(new hchang8Item());   
	}
    
	
	@Override
    public String getRoomAuthor() {
        return "Hanna Chang";
    }
}