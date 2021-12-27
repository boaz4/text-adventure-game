package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.ExplosiveBarrel;
import objectAdventure.room.AbstractRoom;

/**
 * @author Adam J. Conover, COSC436
 */
public class Room14 extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public Room14() {
        // The room ID must be set.
        super(14);

        super.setDescription("Room filled with barrels.");
        
        super.addItem(new ExplosiveBarrel());
        super.addItem(new ExplosiveBarrel());  
        super.addItem(new ExplosiveBarrel());  
        
    }

    @Override
    public String getRoomAuthor() {
        return "Jacob Weagly";
    }


}
