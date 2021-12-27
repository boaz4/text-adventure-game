package objectAdventure.item;

import objectAdventure.Main;

import java.util.Collections;
import java.util.List;

/**
 * This is mainly just a placeholder for the moment, but items will have "functionality" in the
 * future.
 *
 * @author Adam J. Conover, COSC436
 */
public interface Item {

    /**
     * Generate the description of an item.
     *
     * @return A simple item description
     */
    String getItemDescription();

    /**
     * Can the item be picked up and relocated.
     *
     * @return return true if the item can be moved.
     */
    default boolean isTransferable() {
        return false;
    }

    /**
     * Short Names lists for use in picking up and removing items.
     *
     * @return A list containing the aliases (short names) for an item.
     */
    default List<String> getAliasList() {
        return Collections.unmodifiableList(List.of());
    }

    /**
     * For refactoring...
     * <p>
     * TODO: change interactionEvent to return a status result of the interaction.
     *
     * @param ie The item interaction that occurred.
     */
    default void interactionEvent(ItemInteraction ie) {
        if (Main.SHOW_DEBUG_INFO){
            System.out.println("DEBUG: " + ie);
        }
    }

}
