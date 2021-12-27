package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.GameInstructions;
import objectAdventure.pattern.Observer;
import objectAdventure.room.AbstractRoom;

/**
 * A room for testing purposes.
 *
 * @author Adam J. Conover, COSC436
 */
public class SecretTestingRoom
        extends AbstractRoom
        implements Observer<Boolean> {

    private static final int ROOM_ID = 99;
    private final String DESC
            = "This is just a room for testing. "
            + "Nothing to see Here. (Or is there???)";

    /**
     * Constructor accepting a room ID.
     *
     * @param id
     */
    public SecretTestingRoom(final int id) {
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
    SecretTestingRoom() {
        this(ROOM_ID);
    }

    /**
     * Factory method to create the room.
     *
     * @return The new room object.
     */
    public static SecretTestingRoom newInstance() {
        SecretTestingRoom room = new SecretTestingRoom();

        GameInstructions gameInstructions = new GameInstructions();

        room.addItem(gameInstructions);      // add to ourselves before...
        gameInstructions.addObserver(room);  // ...  adding Ourselves to the item.

        return room;
    }

    @Override
    public String getRoomAuthor() {
        return "Adam J. Conover";
    }

    @Override
    public void update(Boolean value) {
        System.out.println("Item Updates room with: " + value);
    }
}
