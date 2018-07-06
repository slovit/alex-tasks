package org.alexslo.task02;
/**
 * Class component of the pattern MVC
 * Responsible for displaying the string information in to the console for the user
 * @author Slobodianyk Alexander
 */

import java.util.HashMap;
import java.util.Map;

public class View {

    private Map<String, String> commands;

    /**
     * Constructor that put all needed String output commands into map
     */
    public View() {
        commands = new HashMap<>();
        commands.put("Greeting", "Hi,the point of this game is that you need to guess certain number between some borders\n ");
        commands.put("Enter borders", "Please, print `yes` if you want to specify the boundaries " +
                "between which you need to guess the number.\n" +
                "Or, print `no` to skip borders");
        commands.put("Min", "Please, enter minimum border :");
        commands.put("Max", "Please, enter maximum border :");
        commands.put("Start", "Ok, let`s start the game! Good luck!");
        commands.put("Not_valid", "`%s` is not a valid number.\n");
        commands.put("Correct", "Correct! Congratulations!\nThis number is: %d\n");
        commands.put("Not_Positive", "Please, enter a positive number :");
        commands.put("Positive", "You have entered a positive number : %d.\n");
        commands.put("Low", "Too low. Try again. Your attempts:\n");
        commands.put("High", "Too high. Try again. Your attempts:\n");
        commands.put("GiveAnswer", "Please, print answer `yes`| `no` to continue! ");
        commands.put("Input_int_val", "Try to guess an integer value between ( %d | %d )\n");
        commands.put("Wrong_input", "Wrong input! Repeat, please!");
        commands.put("Attempts", "Your attempts: ");
        commands.put("Step_number", "Attempt № %d.\n");
    }

    //  Overloading print methods for certain cases
    public void printCommandFromMap(String context) {
        System.out.println(commands.get(context));
    }

    public void printfCommandFromMap(String context, int input) {
        System.out.printf(commands.get(context), input);
    }

    public void printfCommandFromMap(String context, String input) {
        System.out.printf(commands.get(context), input);
    }

    public void printfCommandFromMap(String context, int input, int input1) {
        System.out.printf(commands.get(context), input, input1);
    }

    public void printUserAttempts(String attempts) {
        System.out.println(attempts);
    }
}

