package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.bagOfOldCoins;
import objectAdventure.room.AbstractRoom;

/**
 * @author Andrew Noonan
 */
public class anoona1Room extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public anoona1Room() {
        // The room ID must be set.
        super(19);

        super.setDescription("An old, damp room. It's quite remarkably unremarkable.");
        
        super.addItem(new bagOfOldCoins());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Andrew Noonan";
    }


}
