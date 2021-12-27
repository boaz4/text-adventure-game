package objectAdventure.room;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;
import objectAdventure.player.playerImpl.DefaultPlayer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRoom implements Room {
    // The ID of the Room
    protected final Integer roomId;
    // The List of Items in the room
    final List<Item> itemList;
    // The Description of the Room.
    private String description;

    /**
     * Constructor for the abstract room.
     *
     * @param roomId
     */
    public AbstractRoom(int roomId) {
        this.roomId = roomId;
        this.itemList = new LinkedList<>();
    }

    /**
     * @return The description of the room.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description of the room.
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The RoomID
     */
    @Override
    public Integer getRoomId() {
        return this.roomId;
    }

    /**
     * Not yet Used. (Stub for players to be able to interact with items.)
     *
     * @param interaction Interaction Object Describing how we want to interact with the object.
     * @param player      The player interacting with the object.
     */
    public void processInteraction(ItemInteraction interaction, DefaultPlayer player) {
        System.out.println("There is nothing yet to do in this room with: " + interaction);
    }

    /**
     * Adds an item to the room.
     *
     * @param item
     */
    @Override
    public void addItem(Item item) {
        this.itemList.add(item);
    }

    /**
     * Returns a copy of the item List.
     *
     * @return The items in the room.
     */
    @Override
    public List<Item> getItems() {
        return Collections.unmodifiableList(itemList);
    }

    /**
     * Removes an item from the room.
     *
     * @return The items in the room.
     */
    @Override
    public Optional<Item> removeItem(Item item) {
        if (item.isTransferable()) {
            this.itemList.remove(item);
            return Optional.of(item);
        }
        return Optional.empty();
    }
}
