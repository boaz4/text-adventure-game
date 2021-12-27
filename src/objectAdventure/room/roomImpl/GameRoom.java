package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.pen;
import objectAdventure.room.AbstractRoom;


public class GameRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public GameRoom() {
        // The room ID must be set.
        super(13);

        super.setDescription("You have entered the Game Room");
        
        super.addItem(new pen());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Abdulla Aldhaheri";
    }


}
