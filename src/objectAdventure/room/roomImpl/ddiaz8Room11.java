package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.shoe;
import objectAdventure.room.AbstractRoom;

/**
 * @author ddiaz8
 */
public class ddiaz8Room11 extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public ddiaz8Room11() {
        // The room ID must be set.
        super(11);

        super.setDescription("Welcome to Room 11! This is where you find your missing smelly shoe.");
        
        super.addItem(new shoe());  
        
    }

    @Override
    public String getRoomAuthor() {
        return "Daniella Diaz, ddiaz8";
    }


}
