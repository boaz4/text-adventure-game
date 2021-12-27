package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Parachute;
import objectAdventure.room.AbstractRoom;

/**
 * @author Fola O. Alonge, falong2
 */
public class Gulag extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public Gulag() {
        // The room ID must be set.
        super(30);

        super.setDescription("You have been sent to the gulag cuz you suck. Aim better next time kid...");
        
        super.addItem(new Parachute());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Fola O. Alonge";
    }


}
