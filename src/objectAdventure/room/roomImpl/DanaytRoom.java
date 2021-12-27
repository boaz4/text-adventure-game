package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Box;
import objectAdventure.room.AbstractRoom;

public class DanaytRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public DanaytRoom() {
        // The room ID must be set.
        super(16);

        super.setDescription("Whats in the box!");
        
        super.addItem(new Box());  
        
    }

    @Override
    public String getRoomAuthor() {
        return "Danayt Teklu";
    }


}