package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Lamp;
import objectAdventure.room.AbstractRoom;

/**
 * @author Adam J. Conover, COSC436
 */
public class StartRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public StartRoom() {
        // The room ID must be set.
        super(0);

        super.setDescription("This is the main room of the game.");
        
        super.addItem(new Lamp());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Adam J. Conover";
    }


}
