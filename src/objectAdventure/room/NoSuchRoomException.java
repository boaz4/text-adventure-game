package objectAdventure.room;

import static java.text.MessageFormat.format;

/**
 * A general exception for a room not existing.  This should not be thrown in normal operations.
 *
 * @author Adam J. Conover, COSC436
 */
public class NoSuchRoomException extends RuntimeException {

    /**
     * @param roomId the ID of the offending room.
     */
    public NoSuchRoomException(Integer roomId) {
        super(format("The Room id={0} does not exist.", roomId));
    }

}
