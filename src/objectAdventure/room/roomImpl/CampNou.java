package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Soccerball;
import objectAdventure.room.AbstractRoom;
import objectAdventure.pattern.Observer;


/**
 * @author Boaz Alemseged, COSC436
 */
public class CampNou extends AbstractRoom implements Observer<Boolean> {

    private static final int id = 12;
    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public CampNou(final int id) {
        // The room ID must be set.
        super(id);

        super.setDescription("Welcome to the Camp Nou, this is where FC Barcalona play. You can play soccer in this room.");
        
        
        
    }

    CampNou()
    {
        this(id);
    }
    
    public static CampNou newInstance() {
        CampNou room = new CampNou();
        Soccerball ball = new Soccerball();

        room.addItem(ball);      
        ball.addObserver(room);  

        return room;
    }


    @Override
    public String getRoomAuthor() {
        return "Boaz D. Alemseged";
    }

    @Override
    public void update(Boolean value) {
        System.out.println("Item Updates room with: " + value);
    }

}