package objectAdventure.room.roomImpl;

import objectAdventure.item.itemImpl.Stool;
import objectAdventure.item.itemImpl.WeakLock;
import objectAdventure.item.itemImpl.WoodenStick;
import objectAdventure.room.AbstractRoom;

public class Cabin extends AbstractRoom {

    private static final int ROOM_ID = 23;
    private final String DESC = "A small wooden cabin, almost falling apart. There is a broken ladder you cannot reach, leading to upstairs.";

    public Cabin(int id) {
        super(id);
        super.setDescription(DESC);
    }

    public Cabin() {
        this(ROOM_ID);
    }

    public static Cabin newInstance() {
        var cabin = new Cabin();
        var stool = new Stool();
        var stick = new WoodenStick();
        var lock = new WeakLock();

        cabin.addItem(stool);
        cabin.addItem(stick);
        cabin.addItem(lock);

        return cabin;
    }

    @Override
    public String getRoomAuthor() {
        return "Jared Nemith";
    }
}
