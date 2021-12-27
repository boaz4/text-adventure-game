/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectAdventure.room.roomImpl;
import objectAdventure.room.AbstractRoom;
import objectAdventure.item.itemImpl.*;

/**
 *
 * @author matt arceo
 */
public class WhateverYouLike extends AbstractRoom {
    
    /**
     * Constructor for the room, it must be constructed with an ID!!!
     */
    public WhateverYouLike() {
        // The room ID must be set.
        super(20);

        super.setDescription("This room will turn into anything you think of. "
                + "Watch your thoughts...but there is a keychain in the middle of the room.");
        
        super.addItem(new Keychain());   
        
    }

    @Override
    public String getRoomAuthor() {
        return "Matt Arceo";
    }
}
