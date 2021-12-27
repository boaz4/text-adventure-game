package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.CardboardBox;

import objectAdventure.room.AbstractRoom;

/**
 * @author Jackson K. Bonvissuto
 */
public class ShadowMosesIsland extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public ShadowMosesIsland() {
        // The room ID must be set.
        super(5);

        super.setDescription("Shadow Moses Island, a nuclear weapons disposal facility... There might be a Metal Gear housed here.");
       
        super.addItem(new CardboardBox());
        
    }

    @Override
    public String getRoomAuthor() {
        return "Jackson K. Bonvissuto";
    }


}
