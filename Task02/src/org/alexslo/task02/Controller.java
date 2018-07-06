package org.alexslo.task02;
/**
 * Controller class component of the pattern MVC
 * Operates with all available methods and classes for the correct operation of the program
 *
 * @author Slobodianyk Alexander
 */

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;
    private ValueChecker vChecker;

    //Constructor
    public Controller() {
        model = new Model();
        view = new View();
        vChecker = new ValueChecker();
    }

    /**
     * Working method that includes all the operations
     */
    public void startGame() {
        GameStatus gameStatus = GameStatus.START;
        view.printCommandFromMap("Greeting");
        view.printCommandFromMap("Enter borders");
        scanner = new Scanner(System.in);
        //Setting borders
        setBordersForRandomFunc();
        int stepsCount = 0;
        view.printCommandFromMap("Start");
        while (gameStatus != GameStatus.GUESSED) {
            view.printfCommandFromMap("Step_number", ++stepsCount);
            view.printfCommandFromMap("Input_int_val", model.getMin(), model.getMax());
            int userAnswer = vChecker.getUserInputPlusCheck(scanner);
            gameStatus = model.doMove(userAnswer);
            model.showStatistics(gameStatus);
        }
    }

    /**
     * Function that random a certain integer number between given borders
     *
     * @param min minimum border
     * @param max maximum border
     * @return random integer
     */
    public int rand(int min, int max) {
        int random = (int) ((Math.random() * (max - min)) + min);
        model.setMin(min);
        model.setMax(max);
        return random;
    }

    /**
     * Function that random a certain integer number between constant borders
     *
     * @return random integer
     */
    public int rand() {
        Global_consts consts = new Global_consts();
        int random = (int) ((Math.random() * (consts.CONST_MAX - consts.CONST_MIN) + consts.CONST_MIN));
        model.setMax(consts.CONST_MAX);
        model.setMin(consts.CONST_MIN);
        return random;
    }

    /**
     * Method launches the rand function, depending on whether the user entered the minimum and maximum or not
     * Sets secret number
     */
    public void setBordersForRandomFunc() {
        if (vChecker.isEnterBorders(scanner)) {
            view.printCommandFromMap("Min");
            model.setMin(vChecker.getUserInputPlusCheck(scanner));
            view.printCommandFromMap("Max");
            model.setMax(vChecker.getUserInputPlusCheck(scanner));
            model.setSecretNumber(rand(model.getMin(), model.getMax()));
        } else
            model.setSecretNumber(rand());
    }
}
