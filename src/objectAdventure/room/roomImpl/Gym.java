package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Basketball;
import objectAdventure.room.AbstractRoom;

/**
 * @author Andrew Flemming
 */
public class Gym extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public Gym() {
        // The room ID must be set.
        super(3);

        super.setDescription("This is the gym to play basketball.");
        
        super.addItem(new Basketball());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Andrew Flemming";
    }


}
