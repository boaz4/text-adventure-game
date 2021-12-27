package objectAdventure.room.roomImpl;
import objectAdventure.room.AbstractRoom;
import objectAdventure.item.itemImpl.Window;
import objectAdventure.item.itemImpl.TrainCarSeats;
import objectAdventure.item.itemImpl.Statue;


/**
 * @author Noah Shannon, COSC436
 */
public class TrainCarRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public TrainCarRoom() {
        // The room ID must be set.
        super(1);

        super.setDescription("This is the second room of the game. \n You see windows on the left and right of the train car. \n Train car seats are on the left and right hand sides of the roof of the car. \n There is nobody here and in the middle of the train car lies a statue.....");
        
        super.addItem(new Window()); 
        super.addItem(new TrainCarSeats());
        super.addItem(new Statue());
        
    }

    @Override
    public String getRoomAuthor() {
        return "Noah Shannon";
    }


}
