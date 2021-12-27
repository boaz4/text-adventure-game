package objectAdventure.item.itemImpl;

import java.util.List;
import objectAdventure.item.Item;

//import java.util.List;

/**
 *
 * @author lana
 */
public class Cauldron implements Item {
    
    boolean isAnchored = true;

    
    @Override
    public String getItemDescription() {
        return "It looks like something purple is brewing in the cauldron";
    }
    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }
    @Override
    public List<String> getAliasList() {
        return List.of("Cauldron","Pot", "Kettle");
    }
    
}
