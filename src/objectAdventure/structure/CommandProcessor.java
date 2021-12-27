package objectAdventure.structure;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * <p>
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOTICE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</p>
 * This class is intended to be improved upon by utilizing the "Command" and a "Chain of
 * Responsibility" patterns!!! The big case statement with many different function calls is exactly
 * what we want to avoid!!!
 * <p>
 * Aside from Directions and a few helpful exceptions (noted in "showCommands()"), all commands are
 * two words (verb noun).
 *
 * @author Adam J. Conover.
 */
public class CommandProcessor {

    private static void showCommands() {
        System.out.println("NOTE: Item names may be one or more words.");
        System.out.println("\tDROP <item name>");
        System.out.println("\tDROP ALL");
        System.out.println("\tGET <item name>");
        System.out.println("\tGET ALL");
        System.out.println("\tINSPECT <item name>");
        System.out.println("\tSHOW ALL");
        System.out.println("\tSHOW INVENTORY");
        System.out.println("\tSHOW ITEMS");
        System.out.println("\tSHOW ROOM");
        System.out.println("\tSHOW LEGEND");
        System.out.println("\tTELEPORT <room id>");
        System.out.println("\tUSE <item name>");
        System.out.println();
        System.out.println("Single Letter Commands:");
        System.out.println("\tN | S | E | W <Movement>");
        System.out.println("\tI (SHOW PLAYER INVENTORY)");
        System.out.println("\tL (SHOW ROOM DESCRIPTION & ROOM ITEMS)");
        System.out.println("\tT <room id>");
        System.out.println("\t? [or 'HELP'] - This List");
    }

    public static void processCommand(String inputLine, GameController controller) throws UnknownCommandException {
        if (inputLine.startsWith("?") || inputLine.contains("HELP")) {
            showCommands();
            return;
        }

        // Process single letter commands.
        if (inputLine.length() == 1) {
            // Only care about the first character
            Character firstChar = inputLine.toUpperCase().charAt(0);

            switch (firstChar) {
                case 'I':
                    Command_ShowInventory(controller);
                    break;
                case 'L':
                    Command_ShowRoomDescription(controller);
                    Command_ShowRoomItems(controller);
                    break;
                default:
                    // Get the Direction object from the user's input.
                    Direction.fromLexeme(inputLine).ifPresentOrElse(
                            controller::movePlayer,
                            () -> out.println("Not a valid direction"));
            }

            // Process Two Word Input.
        } else {
            // TEMPORARY COMMANDS BEFORE BEING BROKEN OFF INTO A BETTER COMMAND PROCESSOR USING A
            // CHAIN OF RESPONSIBILITY.

            /* TODO: Clean up this mess!!!! Originally split on spaces to create an array for
             * command purposes, but then needed to put the remainder of the array back together to
             * accommodate item names that were more than one word. So now we have a situation where
             * the string is broken up into an array but then the remainder of the array is
             * reassembled back into a string. It works, but isn't very elegant... Plus, this whole
             * thing was designed to be refactored into using the "command pattern", but should
             * still be cleaned up first.
             */
            // Split on the space.
            String[] command = inputLine.toUpperCase().split("\\s+");

            if (command.length < 2) {
                throw new UnknownCommandException("Unknown command format.  See \"Help\" (?).");
            }

            // Break apart the command, assuming "noun verb" format
            String verb = command[0];
            String noun // A hack since so many item aliases are more than one word.
                    = Arrays.stream(command).skip(1).collect(Collectors.joining(" "));

            // TODO: Again... This is a TEMPORARY solution (intended for refactoring).
            switch (verb) {
                case "SHOW":
                    switch (noun) {
                        case "ITEMS":
                            Command_ShowRoomItems(controller);
                            break;
                        case "ROOM":
                            Command_ShowRoomDescription(controller);
                            break;
                        case "INV":
                        case "INVENTORY":
                            Command_ShowInventory(controller);
                            break;
                        case "ALL":
                            Command_ShowRoomItems(controller);
                            Command_ShowRoomDescription(controller);
                            Command_ShowInventory(controller);
                            break;
                        case "LEGEND":
                            Command_ShowLegend(controller);
                            break;
                        default:
                            throw new UnknownCommandException(
                                    String.format("I don't see any %s to inspect.", noun));
                    }
                    break;

                case "GET":
                    switch (noun) {
                        case "ALL":
                            Command_TakeAllItems(controller);
                            break;
                        default:
                            Command_TakeItem(controller, noun);
                    }
                    break;

                case "DROP":
                    switch (noun) {
                        case "ALL":
                            Command_DropAll(controller);
                            break;
                        default:
                            Command_DropItem(controller, noun);
                    }
                    break;

                case "USE":
                    Command_UseItem(controller, noun);
                    break;

                case "INSPECT":
                    Command_InspectItem(controller, noun);
                    break;

                case "T":
                case "TELEPORT":
                    try {
                        Command_Teleport(controller, Integer.parseInt(noun));
                    } catch (NumberFormatException e) {
                        throw new UnknownCommandException("Teleportation failed to room: " + noun);
                    }

                    break;

                default:
                    throw new UnknownCommandException("I don't understand: " + inputLine);
            }

            controller.incMoveNumber();
        }
    }

    private static void Command_DropItem(GameController controller, String noun) {
        String result = controller.dropItemToRoom(noun);
        System.out.println(result);
    }

    private static void Command_DropAll(GameController controller) {
        boolean result = controller.dropAllItemsToRoom();

        var msg = result ? "You have dropped until you could drop no more." : "Nothing to drop.";
        System.out.println(msg);
    }

    private static void Command_TakeItem(GameController controller, String noun) {
        String result = controller.takeItemFromRoom(noun);
        System.out.println(result);
    }

    private static void Command_TakeAllItems(GameController controller) {
        boolean result = controller.takeAllItemsFromRoom();

        var msg = result ? "You have greedily taken everything you could lift!" : "How does one take nothing?";
        System.out.println(msg);
    }

    private static void Command_ShowRoomDescription(GameController controller) {
        System.out.println("Description:");
        System.out.println(controller.getRoomDescription());
    }

    private static void Command_ShowRoomItems(GameController controller) {
        System.out.println("You see:");
        System.out.println(controller.getItemDescriptions());
    }

    private static void Command_ShowInventory(GameController controller) {
        System.out.println("Inventory:");
        System.out.println(controller.getPlayerInventoryDescription());
    }

    private static void Command_Teleport(GameController controller, int room) {
        if (controller.DEBUG_JumpToRoom(room)) {
            System.out.println("Teleported to room: " + room);
        } else {
            System.out.println("Teleportation to non-existent locations is not yet supported.");
        }
    }

    private static void Command_UseItem(GameController controller, String noun) {
        String response = controller.useItem(noun);
        System.out.println(response);
    }

    private static void Command_InspectItem(GameController controller, String noun) {
        String response = controller.inspectItem(noun);
        System.out.println(response);
    }

    private static void Command_ShowLegend(GameController controller) {
        String allRoomContents = controller.DEBUG_ShowAllRoomContents();
        System.out.println(allRoomContents);
    }

    /**
     * Simple exception for Unknown Commands.
     */
    public static class UnknownCommandException extends RuntimeException {

        public UnknownCommandException(String inputLine) {
            super(inputLine);
        }
    }
}
