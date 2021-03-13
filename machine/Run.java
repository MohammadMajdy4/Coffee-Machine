/**
 *
 */
package machine;

/**
 * @author MohammadMagdy
 *
 */

import machine.CoffeeMachine;

import java.util.*;

public class Run {

    final static Scanner input = new Scanner(System.in);
    final static CoffeeMachine coffeeMachine = new CoffeeMachine();

    // main method
    public static void main(String[] args) {

        boolean isRunning = true;
        while (isRunning) {
            // print the main menu :
            coffeeMachine.menu();
            // getting the choice of the user :
            String userInput = input.next();
            // passing his / her choice to the method choseAnOption("...")
            // the method performs the action and return true if the chosen action wasn't exit
            // if the action is exit then it returns false
            isRunning = chooseAnOption(userInput);

        }
    }

    // Getting the chosen menu option and calling its function
    public static boolean chooseAnOption(String option) {
        switch (option.toLowerCase()) {

            case "buy":
                coffeeMachine.buyACoffeeMessage();
                String chooseACoffee = input.next();
                coffeeMachine.buy(chooseACoffee);
                break;

            case "fill":
            {
                System.out.println("Write how many ml of water do you want to add:");
                int water = input.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = input.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int coffee = input.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = input.nextInt();
                coffeeMachine.fill(water, milk, coffee, cups);
            }
            break;

            case "take":
                coffeeMachine.take();
                break;

            case "remaining":
                coffeeMachine.remaining();
                break;

            case "exit":
                return false;
        }
        return true;
    }


}
