package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Flute;
import objectAdventure.room.AbstractRoom;

/**
 * @author Stephanie Prem
 */
public class MusicRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public MusicRoom() {
        // The room ID must be set.
        super(2);

        super.setDescription("This is room 2 - the Music Room! A room full of instruments. \nYou can see a flute near the entrance.");
        
        super.addItem(new Flute());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Stephanie Prem";
    }


}

