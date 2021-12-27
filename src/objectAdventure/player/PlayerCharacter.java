package objectAdventure.player;

import objectAdventure.item.Item;
import objectAdventure.structure.ItemPossessor;

import java.util.List;

/**
 * @author Adam J. Conover, COSC436
 */
public interface PlayerCharacter extends ItemPossessor {


    /**
     * @return the currentRoom
     */
    int getCurrentRoomId();

    /**
     * @return the inventory
     */
    List<Item> getInventory();

    /**
     * @return the playerName
     */
    String getPlayerName();
    
    /**
     * @param currentRoom the currentRoom to set
     */
    void setCurrentRoom(int currentRoom);

}
