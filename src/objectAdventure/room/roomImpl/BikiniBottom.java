package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Rod;
import objectAdventure.room.AbstractRoom;

/**
 * @author mmarra3
 */
public class BikiniBottom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public BikiniBottom() {
        // The room ID must be set.
        super(21);

        super.setDescription("The room is underwater. In the distance you can see the Krusty Krab.");
        
        super.addItem(new Rod());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Monssef Marrakchi";
    }


}