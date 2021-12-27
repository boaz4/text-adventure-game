package objectAdventure.room.roomImpl;
import objectAdventure.item.itemImpl.GameInstructions;
import objectAdventure.pattern.Observer;
import objectAdventure.room.AbstractRoom;

import java.util.Iterator;


public class BatCave extends AbstractRoom implements Observer<Boolean>, Iterable<String>
    {
        private static final int ROOM_ID = 11;

         /**
     * Constructor accepting a room ID.
     *
     * @param id
     */
        /**
         * Constructor for the room, it must be constructed with an ID!!!
         */
        public BatCave(final int id) {
            // The room ID must be set.
            super(id);
    
            super.setDescription("Welcome to the BatCave, tread lightly and with caution");
        }

        BatCave() {
            this(ROOM_ID);
        }
    
       public static BatCave newInstance() {
            BatCave room = new BatCave();
    
            GameInstructions gameInstructions = new GameInstructions();
    
            room.addItem(gameInstructions);      // add to ourselves before...
            gameInstructions.addObserver(room);  // ...  adding Ourselves to the item.
    
            return room;
        }

        @Override
        public String getRoomAuthor() {
            return "Nnamdi Mkpoku";
        }


        @Override
        public void update(Boolean value) {
            System.out.println("Item Updates room with: " + value);
        }
    
        @Override
        public Iterator<String> iterator() {
            // Not implemented yet, but could return an iterator that iterated though each of the Item Aliases
            // for all items in the room.
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    
