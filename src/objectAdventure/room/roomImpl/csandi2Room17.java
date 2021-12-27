package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.csandi2Rock;
import objectAdventure.pattern.Observer;
import objectAdventure.room.AbstractRoom;

/**
 * A room for testing purposes.
 *
 * @author Adam J. Conover, COSC436
 */
public class csandi2Room17
        extends AbstractRoom
        implements Observer<Boolean> {

    private static final int ROOM_ID = 17;
    private final String DESC
            = "This is Cole's room. "
            + "Why are you in his room?";

    /**
     * Constructor accepting a room ID.
     *
     * @param id
     */
    public csandi2Room17(final int id) {
        super(id);
        super.setDescription(DESC);

        /**
         * Note that passing "this" out of a constructor is generally a bad practice, and a "Factory
         * Method" or even "Builder Pattern" is better suited for situations where this necessary.
         *
         * For a description of the potential problem see: see:
         * http://www.javapractices.com/topic/TopicAction.do?Id=252
         *
         * In the "Examples" repository, I created a demo of one of the potential issues.
         * svn://cosc436svn.xyz:65436/Examples/trunk/src/MiscJavaCodeExamples/LeakyConstructor
         */
//        GameInstructions gameInstructions = new GameInstructions();
//        super.itemList.add(gameInstructions);
//        gameInstructions.addObserver(this);
    }

    /**
     * Default constructor with room-default ID.
     */
    csandi2Room17() {
        this(ROOM_ID);
    }

    /**
     * Factory method to create the room.
     *
     * @return The new room object.
     */
    public static csandi2Room17 newInstance() {
        csandi2Room17 room = new csandi2Room17();

        csandi2Rock csandi2Rock = new csandi2Rock();

        room.addItem(csandi2Rock);      // add to ourselves before...
        csandi2Rock.addObserver(room);  // ...  adding Ourselves to the item.

        return room;
    }

    @Override
    public String getRoomAuthor() {
        return "Cole Sandifer";
    }

    @Override
    public void update(Boolean value) {
        System.out.println("Item Updates room with: " + value);
    }
}
