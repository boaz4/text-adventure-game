package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;
import java.util.List;

public class Shotgun implements Item {

    boolean isAnchored = false;

    public String getItemDescription(){
        return "This shotgun can blow yo brains out. Don't get trigger happy with it!";
    }

    public boolean isTransferable(){
        return !isAnchored;
    }

    public List<String> getAliasList(){
        return List.of("Shotgun", "Shoot");
    }



}
