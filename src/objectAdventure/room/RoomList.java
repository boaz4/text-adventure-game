package objectAdventure.room;

import objectAdventure.room.roomImpl.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Adam J. Conover, COSC436
 */
public class RoomList {

    private static final Logger LOG = Logger.getLogger(RoomList.class.getName());
    private final Map<Integer, Room> roomList = new TreeMap<>();

    private RoomList() {
        // Force usage of factory method.
    }

    /**
     * Factory method for construction to allow for complete construction of the RoomList Object
     * before adding any rooms to it.
     *
     * @return a fully constructed room list object
     */
    public static RoomList newInstance() {
        RoomList rooms = new RoomList();
        rooms.initRooms();
        return rooms;
    }

    /**
     * Show the contents of all rooms in the game.
     *
     * @return formatted string listing the complete contents of the room.
     */
    public String DEBUG_GetAllMapContents() {
        StringBuilder sb = new StringBuilder();

        sb.append("Game Contents:\n");
        for (var room : roomList.values()) {
            sb.append(String.format("\tRoom %02d: %s\n", room.getRoomId(), room.getClass().getSimpleName()));
            for (var item : room.getItems()) {
                sb.append(String.format("\t\tItem: %s\n", item.getClass().getSimpleName()));
            }
        }

        return sb.toString();
    }

    /**
     * @param roomId the ID of the room to retrieve.
     * @return The room object from the ID.
     * @throws NoSuchRoomException thrown if the room does not exist.
     */
    public Room getRoom(int roomId) throws NoSuchRoomException {

        final var room = roomList.get(roomId);
        if (room == null) {
            throw new NoSuchRoomException(roomId);
        } else {
            return room;
        }
    }

    /**
     * Add a Room Object to the map.
     *
     * @param room The room object being added to the map.
     */
    public void addRoom(Room room) {
        Integer roomId = room.getRoomId();

        if (roomId == null) {
            System.err.printf("Cannot add room %d. It has no ID!!!", roomId);
        } else {
            roomList.put(roomId, room);
            LOG.log(Level.CONFIG, "Added room {0}: {1}", new Object[]{roomId, room});
        }
    }

    /**
     * Initialization method for all rooms in the game. Technically, dynamic loading would be
     * better, but this is much easier to understand. (Dynamic class loading introduces many
     * additional considerations.)
     *
     * While two "instantiation" techniques are shown below, either can be used for now. (The normal
     * constructor is probably most are familiar with most, but we'll look at the difference.)
     */
    void initRooms() {

        addRoom(new StartRoom());
        addRoom(SecretTestingRoom.newInstance()); // using a factory method instead.
        // TODO: Add the factory method to the abstract base class

        addRoom(new StartRoom());
        addRoom(SecretTestingRoom.newInstance()); // using a factory method instead.
        // TODO: Add the factory method to the abstract base class

        // **** SAMPLE ROOMS **** (Do not edit)
        addRoom(new StartRoom()); // using a normal constructor
        addRoom(SecretTestingRoom.newInstance()); // EXAMPLE of using a factory method instead... which will be dicussed later.

        // **** EDIT ONLY BELOW THIS POINT! ***
     
        /*        
        // NOTE: These are without corresponding rooms/items, probably the result of forgetting to
        // use "svn add" on newly added files. They can be moved below this comment section once
        // the rooms/items are added. Note that *some* IDE's *automatically* "add" new source files
        // to version control, while others do not; the best way to check is by running "svn status"
        // before performing ANY commit.
        
        addRoom(new hchang8Room());
        addRoom(new mlazar7room());
        addRoom(csandi2Room17.newInstance());
         */


        ////////////////////////////////////////////////////////
        addRoom(new CampNou());
        addRoom(new justinRoom28());
        addRoom(new samsroom());
        addRoom(new TrainCarRoom());
        addRoom(new ShadowMosesIsland());
        addRoom(new MusicRoom());
        addRoom(new Gulag());
		addRoom(new GameRoom());
    }

}
