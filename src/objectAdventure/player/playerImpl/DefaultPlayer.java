package objectAdventure.player.playerImpl;

import objectAdventure.item.Item;
import objectAdventure.player.PlayerCharacter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

/**
 * The player is a "Creature" since the player is something that may exist within a room that is not
 * an inanimate object (Item).
 *
 * @author Adam J. Conover, COSC436
 */
public class DefaultPlayer implements PlayerCharacter {

    private final String playerName;
    private int currentRoom;
    private final List<Item> inventory;

    /**
     * Constructor for default player.
     *
     * @param playerName the name of the player
     */
    public DefaultPlayer(String playerName) {
        this.playerName = playerName;
        this.inventory = new LinkedList<>();
    }

    /**
     * @return the currentRoom
     */
    @Override
    public int getCurrentRoomId() {
        return currentRoom;
    }

    /**
     * @param currentRoom the currentRoom to set
     */
    @Override
    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * @return the inventory
     */
    @Override
    public List<Item> getInventory() {
        return unmodifiableList(inventory);
    }

    /**
     * @param item item to add to inventory
     */
    @Override
    public void addItem(Item item) {
        inventory.add(item);
    }

    /**
     * @param item item to remove from inventory.
     */
    @Override
    public Optional<Item> removeItem(Item item) {
        if (item.isTransferable()) {
            inventory.remove(item);
            return Optional.of(item);
        }
        return Optional.empty();
    }

    /**
     * @return the playerName
     */
    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "Player{" + "currentRoom=" + currentRoom + ", inventory=" + inventory + ", playerName=" + playerName + '}';
    }

}
