package org.alexslo.task02;
/**
 *Model class represents the component
 *  of MVC design pattern.
 *  It perform function of storing data, state of game
 *  and generate`s statistics.
 */

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Integer> userAttempts;
    private int secretNumber;
    private int minimum;
    private int maximun;
    View view;

    Model() {
        userAttempts = new ArrayList<>();
        view = new View();
    }

    int getMin() {
        return minimum;
    }

    int getMax() {
        return maximun;
    }

    void setMin(int minimum) {
        this.minimum = minimum;
    }

    void setMax(int maximun) {
        this.maximun = maximun;
    }

    void setSecretNumber(int number) {
        this.secretNumber = number;
    }

    int getSecretNumber() {
        return this.secretNumber;
    }

    /**
     * Method check if user has guessed the number or is he higher\lower then the answer(secret number)
     * Rewrites minimum and maximum according to the user input to reduce the scope of his search
     *
     * @param userAnswer
     * @return game status
     */

    public GameStatus doMove(int userAnswer) {
        //Equal
        if (userAnswer == getSecretNumber()) {            //if user's answer equals with given number
            addToAttempts(userAnswer);             //add user answer to user's attempts list
            return GameStatus.GUESSED;             //user won!
        }
        //More
        else if (userAnswer > getSecretNumber()) {      //if user's answer more than given number
            if (userAnswer < getMax())
                setMax(userAnswer);                //set new value max (less for 1 than user input)
            addToAttempts(userAnswer);
            return GameStatus.MORE;
        }
        //Less
        else if (userAnswer < getSecretNumber()) {      //if user's answer less then given number
            if (userAnswer > getMin())
                setMin(userAnswer);               //set new value of min (more for 1 than user input)
            addToAttempts(userAnswer);
            return GameStatus.LESS;
        }
        return null;
    }

    private void addToAttempts(int lastAttempt) {
        userAttempts.add(lastAttempt);
    }

    /**
     * Method return user`s attempts as String list
     *
     * @return
     */

    public String getAttemptsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Integer attempts : userAttempts) {
            sb.append(attempts);
            sb.append(", ");
        }
        sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" ") + 1);
        return sb.toString();
    }

    /**
     * Methos show statistic to user taking into account his attempts to guess the number
     *
     * @param gameState
     */
    public void showStatistics(GameStatus gameState) {
        //Equals
        if (gameState == GameStatus.GUESSED) {    // if user has guessed the given number
            view.printfCommandFromMap("Correct", getSecretNumber());
            view.printCommandFromMap("Attempts");
            view.printUserAttempts(getAttemptsAsString());
        }
        //More
        else if (gameState == GameStatus.MORE) {   //if user's answer more than given number
            view.printCommandFromMap("High");
            view.printUserAttempts(getAttemptsAsString());
        }
        //Less
        else if (gameState == GameStatus.LESS) {   //if user's answer less then given number
            view.printCommandFromMap("Low");
            view.printUserAttempts(getAttemptsAsString());
        }
    }
}
