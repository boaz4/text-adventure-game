package objectAdventure.structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.List.of;
import static objectAdventure.structure.Direction.*;

/**
 * The map of all rooms.
 *
 * @author Adam J. Conover, COSC436
 */
public class GameMap {

    // The order that the connections are specified in the adjacency lists.
    private static final Direction[] CONNECTION_ORDER = {NORTH, EAST, SOUTH, WEST, UP, DOWN};

    // The map containing the room adjacency information.
    private final Map<Integer, List<Integer>> map = new TreeMap<>();

    /**
     * Construct adjacency lists of all rooms in the map. (N, E, S, W, U, D)
     * <p>
     * (Chose not to use an arbitrary direction list to keep things simpler).
     */
    GameMap() {
        map.put(0, of(9, 16, 22, 99, -1, -1));
        map.put(1, of(-1, 2, -1, -1, -1, -1));
        map.put(2, of(-1, 3, 7, 1, -1, -1));
        map.put(3, of(-1, -1, 9, 2, -1, -1));
        map.put(4, of(-1, 5, -1, -1, -1, -1));
        map.put(5, of(-1, -1, 12, 4, -1, -1));
        map.put(6, of(-1, 7, -1, -1, -1, -1));
        map.put(7, of(2, -1, -1, 6, -1, -1));
        map.put(8, of(-1, 9, 15, -1, -1, -1));
        map.put(9, of(3, 10, 0, 8, -1, -1));
        map.put(10, of(-1, 11, -1, 9, -1, -1));
        map.put(11, of(-1, 12, 17, 10, -1, -1));
        map.put(12, of(5, -1, 18, 11, -1, -1));
        map.put(13, of(-1, 14, -1, -1, -1, -1));
        map.put(14, of(-1, 15, 20, 13, -1, -1));
        map.put(15, of(8, -1, -1, 14, -1, -1));
        map.put(16, of(-1, 17, 23, 0, -1, -1));
        map.put(17, of(11, -1, 24, 16, -1, -1));
        map.put(18, of(12, -1, -1, -1, -1, -1));
        map.put(19, of(-1, 20, 26, -1, -1, -1));
        map.put(20, of(14, 21, -1, 19, -1, -1));
        map.put(21, of(-1, 22, 28, 20, -1, -1));
        map.put(22, of(0, -1, 29, 21, -1, -1));
        map.put(23, of(16, -1, -1, -1, -1, -1));
        map.put(24, of(17, 25, 30, -1, -1, -1));
        map.put(25, of(-1, -1, 31, 24, -1, -1));
        map.put(26, of(19, -1, -1, -1, -1, -1));
        map.put(27, of(-1, 28, -1, -1, -1, -1));
        map.put(28, of(21, -1, -1, 27, -1, -1));
        map.put(29, of(22, 30, -1, -1, -1, -1));
        map.put(30, of(24, -1, -1, 29, -1, -1));
        map.put(31, of(25, -1, -1, -1, -1, -1));
        map.put(99, of(-1, 0, -1, -1, -1, -1));
    }

    /**
     * Mostly for debugging, but check to see if a room with a given id exists in on the map.
     *
     * @param roomId The room ID to query.
     * @return <code>true</code> if the room (roomId) exists, <code>false</code> otherwise.
     */
    public boolean doesExist(int roomId) {
        return map.containsKey(roomId);
    }

    /**
     * Get a list of all the exit connections from a given room.
     * <p>
     * NOTE: This was done "dynamically" (direction set recalculated with every move) to allow for
     * less complexity in altering the map dynamically. For example, finding secret passages, etc.
     * <p>
     * However, the room connection/direction mappings could easily be built during the construction
     * of this class. In the absence of adding another "Wrapper Class" the signature of the main
     * TreeMap would then be...
     * <p>
     * Map&lt;Integer, Map&lt;Direction, Integer&gt;&lt; map ...
     *
     * @param roomId the roomID being queried for connections.
     * @return A map with the direction as the key and the connected room as the value.
     */
    public Map<Direction, Integer> getExitConnections(Integer roomId) {

        var roomList = this.map.get(roomId);

        // Can't use "var" (must be explicitly typed), since the compiler can't just guess the 
        // type bounds of a newly created map.
        Map<Direction, Integer> connections = new HashMap<>();

        // Build a list of connections by 
        for (var i = 0; i < Direction.values().length; i++) {
            var destRoomId = roomList.get(i);

            if (destRoomId >= 0) {
                connections.put(CONNECTION_ORDER[i], destRoomId);
            }
        }

        return connections;
    }

    /**
     * Gets the list of connections in the map for dynamic modification.
     *
     * @param roomId The Id of the target room
     * @return the REFERENCE to the list in the connections map.  Any changes to this list will reflect in the global map!
     */
    public List<Integer> getExitList(Integer roomId) {
        return this.map.get(roomId);
    }

}
