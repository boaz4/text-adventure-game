package objectAdventure.structure;

import objectAdventure.item.Item;
import objectAdventure.item.ItemInteraction;
import objectAdventure.player.PlayerCharacter;
import objectAdventure.room.NoSuchRoomException;
import objectAdventure.room.Room;
import objectAdventure.room.RoomList;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

/**
 * All the "Player Interactions" of the game are routed through this class.
 * <p>
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOTICE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>
 * <p>
 * This class is intended to be improved upon by utilizing the "Command" and a "Chain of
 * Responsibility" patterns!!! THERE ARE MANY REFACTORING OPPORTUNITIES HERE!!!
 *
 * @author Adam J. Conover, COSC436
 */
public class GameController {

    private final GameMap gameMap;
    private final RoomList rooms;
    private final PlayerCharacter player;
    private int moveNumber;

    /**
     * @param player The player object.
     */
    public GameController(PlayerCharacter player) {
        this.player = player;
        this.gameMap = new GameMap();
        this.rooms = RoomList.newInstance();

        this.player.setCurrentRoom(0);
        this.moveNumber = 1;
    }

    /**
     * @return the Description of the room
     */
    public String getRoomDescription() {
        return getRoomDescription(getPlayer().getCurrentRoomId());
    }

    /**
     * @param roomId the room to describe
     * @return the description of the room
     */
    public String getRoomDescription(Integer roomId) {
        try {
            var theRoom = rooms.getRoom(roomId);
            var roomDescription = new StringBuilder();

            // Build room description.
            roomDescription.append(theRoom.getDescription()).append('\n');

            // Show the exists from the room
            roomDescription.append("You can see the exits to the: ");

            // Creates a comma delimited list of the exists
            var directionList = gameMap.getExitConnections(roomId)
                    .keySet()
                    .stream()
                    .map(Direction::toString)
                    .collect(joining(", "));

            roomDescription.append(directionList);

            return roomDescription.toString();
        } catch (NoSuchRoomException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Increment the move number with every applicable move
     */
    public void incMoveNumber() {
        moveNumber++;
    }

    /**
     * Item descriptions for current room if room is not specified.
     *
     * @return Item Description.
     */
    public String getItemDescriptions() {
        try {
            return getItemDescriptions(rooms.getRoom(getPlayer().getCurrentRoomId()));
        } catch (NoSuchRoomException e) {
            return "No items in a non-existent room.";
        }
    }

    /**
     * Player Inventory String.
     *
     * @return a comma delimited list of player inventory items.
     */
    public String getPlayerInventoryDescription() {
        List<Item> inv = player.getInventory();

        if (inv.size() > 0) {
            return inv.stream().map(Item::getItemDescription).collect(Collectors.joining("\n"));
        } else {
            return "You are empty handed.";
        }
    }

    /**
     * Gets the item descriptions.
     *
     * @param theRoom the room with the items.
     * @return a string containing the item descriptions.
     */
    public String getItemDescriptions(Room theRoom) {
        StringBuilder roomDescription = new StringBuilder();

        // Add items to the description if they exist.
        if (!theRoom.getItems().isEmpty()) {
            theRoom.getItems().forEach(theItem
                    -> roomDescription.append(MessageFormat.format("   {0}\n", theItem.getItemDescription()))
            );
        } else {
            roomDescription.append("   Nothing of interest.");
        }

        return roomDescription.toString();
    }

    /**
     * @param dir The direction to move the player.
     */
    public void movePlayer(Direction dir) {
        var currentRoom = getPlayer().getCurrentRoomId();
        var exits = this.gameMap.getExitConnections(currentRoom);

        if (!exits.containsKey(dir)) {
            out.printf("Ouch... you ran right into a wall! (There is no exit to the %s.)\n", dir.toString());
        } else {
            final var newRoomId = exits.get(dir);

            if (gameMap.doesExist(newRoomId)) {
                getPlayer().setCurrentRoom(newRoomId);
            } else {
                out.printf(
                        "Sorry, A route to this room does not yet exist. "
                                + "The Game Map may need to be updated\n");
            }
        }

        incMoveNumber();
    }

    /**
     * Get a list of just the exit directions.
     *
     * @return a list of Direction Instances.
     */
    public List<Direction> getExitDirections() {
        var directionSet = this.gameMap
                .getExitConnections(player.getCurrentRoomId())
                .keySet();

        return new ArrayList<>(directionSet);
    }

    /**
     * Gets the player object.
     *
     * @return the player object
     */
    public PlayerCharacter getPlayer() {
        return player;
    }

    /**
     * Gets the current move number.
     *
     * @return the current move number
     */
    public int getMoveNumber() {
        return moveNumber;
    }

    /**
     * Set the current move number.
     *
     * @param moveNumber sets the current move number
     */
    protected void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    /**
     * TODO: Temporary pick up all items that are allowed to be obtained. This is just a temporary
     * method to get the first item from the room.
     *
     * @return true if items were obtainable, false otherwise.
     */
    public boolean takeAllItemsFromRoom() {
        var room = rooms.getRoom(getPlayer().getCurrentRoomId());
        int itemCount = 0;

        Set<Item> items = room.getItems().stream()
                .filter(Item::isTransferable)
                .collect(Collectors.toSet());

        // The room has an ite,
        for (var item : items) {
            player.addItem(item);
            room.removeItem(item);
            item.interactionEvent(ItemInteraction.TAKE);
            itemCount++;
        }

        return itemCount > 0;
    }

    /**
     * TODO: Temporary pick up all items that are allowed to be obtainable. This is just a temporary
     * method to get the first item from the room.
     *
     * @return true if items were droppable, false otherwise.
     */
    public boolean dropAllItemsToRoom() {
        var room = rooms.getRoom(getPlayer().getCurrentRoomId());
        int itemCount = 0;

        // Make copy of list first, because we can't iterate over a list we are also removing from!
        // The room has an item
        for (var item : new ArrayList<>(player.getInventory())) {
            player.removeItem(item);
            room.addItem(item);
            item.interactionEvent(ItemInteraction.DROP);
            itemCount++;
        }

        return itemCount > 0;
    }

    /**
     * This is really only for debugging purposes, so we can jump to any room.However, it could be
     * repurposed to allow teleportation... for example.
     *
     * @param roomId the new "current room" of the player.
     * @return true if success, false otherwise
     */
    public boolean DEBUG_JumpToRoom(Integer roomId) {
        if (gameMap.doesExist(roomId)) {
            getPlayer().setCurrentRoom(roomId);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Debug call to show the contents of all rooms. (Delegate Method)
     *
     * @return formatted string listing the complete contents of the room.
     */
    public String DEBUG_ShowAllRoomContents() {
        return this.rooms.DEBUG_GetAllMapContents();
    }

    /**
     * @return Debugging player info
     */
    public String getPlayerInfo() {
        return player.toString();
    }

    /**
     * @return Debugging Room Info
     */
    public String getRoomInfo() {
        try {
            var theRoom = rooms.getRoom(getPlayer().getCurrentRoomId());
            var roomDescription = new StringBuilder();

            roomDescription.append("Room ID: ")
                    .append(theRoom.getRoomId())
                    .append(", Room Author: ")
                    .append(theRoom.getRoomAuthor());

            return roomDescription.toString();

        } catch (NoSuchRoomException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Take a single item from the room
     *
     * @param noun The item to be taken.
     * @return A String (for now) describing the result of the action. (This would be refactored
     * into a set of possible replies.)
     */
    public String takeItemFromRoom(String noun) {
        var room = rooms.getRoom(getPlayer().getCurrentRoomId());

        // The room has an item
        for (Item item : room.getItems()) {
            for (String alias : item.getAliasList()) {
                if (noun.equalsIgnoreCase(alias)) {
                    if (item.isTransferable()) {
                        transferItem(room, player, item);
                        item.interactionEvent(ItemInteraction.TAKE);
                        return String.format("You picked up the %s.", alias);
                    } else {
                        return String.format("Despite your valiant attempts, the %s is unmovable.", alias);
                    }
                }
            }
        }

        return String.format("I see no '%s' here!!!", noun);
    }

    /**
     * Mainly just an example us using a high-level interface.
     * @implNote moves item from --> to
     * @param from
     * @param to
     * @param item
     */
    static private void transferItem(ItemPossessor from, ItemPossessor to, Item item) {
        from.removeItem(item);
        to.addItem(item);
    }

    /**
     * Drop a single item to the room
     *
     * @param noun The item to be taken.
     * @return A String (for now) describing the result of the action. (This would be refactored
     * into a set of possible replies.)
     */
    public String dropItemToRoom(String noun) {
        var room = rooms.getRoom(getPlayer().getCurrentRoomId());

        for (var item : player.getInventory()) {
            for (String alias : item.getAliasList()) {
                if (noun.equalsIgnoreCase(alias)) {
                    transferItem(player, room, item);
                    item.interactionEvent(ItemInteraction.DROP);
                    return String.format("You dropped the %s.", alias);
                }
            }
        }

        return String.format("I see no '%s' here!!!", noun);
    }

    /**
     * Use an item in the players inventory. NOTE this is mainly a "stub" with minimal
     * functionality, just so the appropriate event can be sent to the item.
     *
     * @param noun The item to be taken.
     * @return A String (for now) describing the result of the action. (This would be refactored
     * into a set of possible replies.)
     */
    public String useItem(String noun) {
        for (var item : player.getInventory()) {
            for (String alias : item.getAliasList()) {
                if (noun.equalsIgnoreCase(alias)) {
                    item.interactionEvent(ItemInteraction.USE);
                    return String.format("Used: %s", item.getClass().getSimpleName()); //TODO: Should return the result of the interaction.
                }
            }
        }

        return "You cannot use that which you do not posses!";
    }

    /**
     * Inspect an item in the players inventory. NOTE this is mainly a "stub" with minimal
     * functionality, just so the appropriate event can be sent to the item.
     *
     * @param noun The item to be inspected.
     * @return true if the item existed, false otherwise.
     */
    public String inspectItem(String noun) {
        for (var item : player.getInventory()) {
            for (String alias : item.getAliasList()) {
                if (noun.equalsIgnoreCase(alias)) {
                    item.interactionEvent(ItemInteraction.INSPECT);
                    return String.format("Inspected: %s", item.getClass().getSimpleName()); //TODO: Should return the result of the interaction.
                }
            }
        }

        return String.format("Your inspection reveals that you possess no '%s'!!!", noun);
    }

}
