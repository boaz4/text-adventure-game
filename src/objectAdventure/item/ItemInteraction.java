package objectAdventure.item;

/**
 * Set of item interactions.
 *
 * @author Adam J. Conover, COSC436
 */
public enum ItemInteraction {
    TAKE("Get"), DROP("Drop"), INSPECT("Inspect"), USE("Use");
    private final String commandString;

    ItemInteraction(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return "Verb{" + "commandString=" + commandString + '}';
    }
}
