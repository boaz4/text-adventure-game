package objectAdventure.room.roomImpl;

import objectAdventure.room.AbstractRoom;
import objectAdventure.item.itemImpl.Shotgun;

public class samsroom extends AbstractRoom {

    public samsroom() {

        super(27);

        super.setDescription("You are im my room. I will greet you with a shotgun... you want it?");

        super.addItem(new Shotgun());

    }

    @Override
    public String getRoomAuthor(){
        return "Sam Efesoa";
    }
}
