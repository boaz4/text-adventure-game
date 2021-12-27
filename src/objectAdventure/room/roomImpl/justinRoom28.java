package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Hatchet;
import objectAdventure.room.AbstractRoom;

/**
 * @author jcance1
 */
public class justinRoom28 extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public justinRoom28() {
        // The room ID must be set.
        super(28);

        super.setDescription("The room is dimly lit and the walls are covered in blood. In the corner you see a hatchet.");
        
        super.addItem(new Hatchet());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Justin Cancel";
    }


}