package objectAdventure.item.itemImpl;

import objectAdventure.item.Item;

import java.util.List;

public class ExplosiveBarrel implements Item {

    boolean isAnchored = false;

    @Override
    public String getItemDescription() {
        return "Barrel of highly sensitive explosive material. It's often conveniently placed next to hordes of enemies.";
    }

    @Override
    public boolean isTransferable() {
        return !isAnchored;
    }

    @Override
    public List<String> getAliasList() {
        return List.of("Explosive Barrel","Barrel");
    }

}
