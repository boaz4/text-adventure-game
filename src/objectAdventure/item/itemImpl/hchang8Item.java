package objectAdventure.item.itemImpl;

import java.util.List;

import objectAdventure.item.Item;

public class hchang8Item implements Item{

	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return "This is Hanna's item";
	}

	@Override
    public boolean isTransferable() {
        return true;
    } 
    
	 @Override
	    public List<String> getAliasList() {
	        return List.of("hchang8Item", "hannasItem", "pen");
	    }
	
	
}