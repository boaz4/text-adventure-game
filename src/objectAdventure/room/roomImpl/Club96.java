
package objectAdventure.room.roomImpl;

import objectAdventure.room.AbstractRoom; 
import objectAdventure.item.itemImpl.Wig;

/**
 *
 * @author rmenen1
 */
public class Club96 extends AbstractRoom {
    
    /**
     * Constructor
     */
    public Club96() {
        super(22);
        super.setDescription("Welcome to the 22nd room, Club96! Featuring Naomi Smalls and Valentina!");
        super.addItem(new Wig());
    }
    
    @Override
    public String getRoomAuthor() {
        return "Ronny Menendez";
    }
}
