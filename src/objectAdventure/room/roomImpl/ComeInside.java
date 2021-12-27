package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Key;
import objectAdventure.room.AbstractRoom;

/**
 * @author Gideon Giorgis, COSC436
 */
public class ComeInside extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public ComeInside() {
        // The room ID must be set.
        super(6);

        super.setDescription("Wrong Key Bud");
        
        super.addItem(new Key());  
        
    }

    @Override
    public String getRoomAuthor() {
        return "Gideon G. Giorgis";
    }


}