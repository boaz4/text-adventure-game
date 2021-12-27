package objectAdventure.room.roomImpl;

import objectAdventure.item.Item;
import objectAdventure.room.AbstractRoom;


// NOTE FROM INSTRUCTOR:  Since "Computer" was not "svn add"ed to the repository, this class 
// is in error. this is just a temprary fix to allow your code to compile as is.



public class NamRoom extends AbstractRoom {

    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public NamRoom() {
        // The room ID must be set.
        super(15);

        super.setDescription("Do not enter wthout knocking.");
        
        
        
// NOTE FROM INSTRUCTOR:  Since "Computer" was not "svn add"ed to the repository, this class 
// is in error. this is just a temprary fix to allow your code to compile as is.    
        // super.addItem(new computer());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Namthi Nguyen";
    }


}
