
package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Fountain;
import objectAdventure.room.AbstractRoom;

/**
 * @author Dcowan2
 */
public class AlluringRoom extends AbstractRoom {

    public AlluringRoom() {

        super(18);

        super.setDescription("This room is so inviting. What's the harm in sitting down and resting for a while?");

        super.addItem(new Fountain());

    }

    @Override
    public String getRoomAuthor() {
        return "Daniel Cowan";
    }


}