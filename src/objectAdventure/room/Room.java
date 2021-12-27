package objectAdventure.room;

import objectAdventure.item.Item;
import objectAdventure.structure.ItemPossessor;

import java.util.List;

/**
 * A general Interface to all rooms.
 *
 * @author Adam J. Conover, COSC436
 */
public interface Room extends ItemPossessor {

    /**
     * Gets the room author information.
     *
     * @return The Author of the room
     */
    default String getRoomAuthor() {
        return "The author wishes to remain anonymous.";
    }

    /**
     * Gets a description of the room.
     *
     * @return Description of the room
     */
    default String getDescription() {
        return "This room does not yet have a description.";
    }

    /**
     * @return the Assigned ID of the room.
     */
    Integer getRoomId();

    /**
     * @return A list of any items found in the room
     */
    List<Item> getItems();

}
