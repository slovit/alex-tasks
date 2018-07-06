package org.alexslo.task02;
/**
 * This class is made to check if the values which input user is correct
 * and suit to the program condition
 *
 * @author Slobodianyk Alexander
 */

import java.util.Scanner;

public class ValueChecker {
    View view = new View();

    /**
     * Method get user`s input from console, check if it is correct and returns it
     *
     * @param scanner
     * @return
     */
    public int getUserInputPlusCheck(Scanner scanner) {
        int userInput;
        do {
            view.printCommandFromMap("Not_Positive");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                view.printfCommandFromMap("Not_valid", input);
            }
            userInput = scanner.nextInt();
        } while (userInput < 0);

        view.printfCommandFromMap("Positive", userInput);
        return userInput;
    }

    /**
     * Method check if user want to set borders or not
     *
     * @param scanner
     * @return boolean true\false answer
     */
    public boolean isEnterBorders(Scanner scanner) {
        boolean bordersStatus = false;
        while (scanner.hasNext()) {
            String userInput = scanner.next();
            if (userInput.equals("yes")) {
                bordersStatus = true;
                break;
            } else {
                if (userInput.equals("no"))
                    break;
            }
            view.printCommandFromMap("GiveAnswer");
        }
        return bordersStatus;
    }
}
