package objectAdventure.structure;

import objectAdventure.item.Item;

import java.util.Optional;

public interface ItemPossessor {
    /**
     * Add a single item to the thing which can possess items.
     *
     * @param item The item to add to the room.
     */
    void addItem(Item item);

    /**
     * Remove a single item from thing which can possess items.
     *
     * @param item The item to add to the room.
     * @return true if the item was successfully removed from the room, false otherwise.
     */
    Optional<Item> removeItem(Item item);
}
