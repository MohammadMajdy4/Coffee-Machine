package machine;

/**
 * @author MohammadMagdy
 *
 */

public class CoffeeMachine {

    // arrays with default ingredients and price for each coffee
    // water, milk, coffee, cups, money
    final int[] espresso   = {250, 0, 16, 1, 4};
    final int[] latte      = {350, 75, 20, 1, 7};
    final int[] cappuccino = {200, 100, 12, 1, 6};

    // default ingredients, money and cups, and amount of each that every machine start with :
    int water        = 400;   // default amount of water in milliliters
    int milk         = 540;   // default amount of milk in milliliters
    int coffee       = 120;   // default amount of coffee in grams
    int disposalCups = 9;     // default amount of cups
    int money        = 550;   // default amount of money in $

    // array of the above ingredients to make it easy to loop on them
    int[] iArrayIngredients = {water, milk, coffee, disposalCups, money};

    // enumeration with ingredients' names
    enum Ingredients {
        WATER, MILK, COFFEE, CUPS, MONEY
    }

    // constructor with default values above (default constructor)
    public CoffeeMachine() {}

    // a method with the main menu options
    public void menu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }


    // a method with the coffee choices to buy
    public void buyACoffeeMessage() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    // a method to buy your coffee
    // first this method check if there is enough coffee
    // then check the returned string if enough then buy the coffee
    // else print a message with shortage of the returned ingredient
    public void buy(String option) {
        String shortage;
        switch (option.toLowerCase()) {
            case "1":
                shortage = enough("espresso");
                if (shortage.equals("isEnough")) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyEspresso();
                } else {
                    System.out.println("Sorry, not enough " + shortage);
                }
                break;

            case "2":
                shortage = enough("latte");
                if (shortage.equals("isEnough")) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyLatte();
                } else {
                    System.out.println("Sorry, not enough " + shortage);
                }
                break;

            case "3":
                shortage = enough("cappuccino");
                if (shortage.equals("isEnough")) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyCappuccino();
                } else {
                    System.out.println("Sorry, not enough " + shortage);
                }
                break;
            case "back":
                // do nothing (it will return automatically in main method after the break statement)
                break;
        }
    }


    // a method to fill the machine with extra water, milk, and coffee :
    public void fill(int water, int milk, int coffee, int disposalCups) {
        this.water        += water;
        this.milk         += milk;
        this.coffee 	  += coffee;
        this.disposalCups += disposalCups;
        // update the array of ingredients
        updateIngredients();
    }

    // a method to print a message with all remaining ingredients
    public void remaining() {
        System.out.println
                ("The coffee machine has:\n"
                        + this.water        + " of water\n"
                        + this.milk         + " of milk\n"
                        + this.coffee       + " of coffee beans\n"
                        + this.disposalCups + " of disposable cups\n"
                        + "$" + this.money  + " of money");
    }

    // a method to withdraw revenues from the machine
    public void take() {
        System.out.printf("I gave you $%d\n",this.money);
        this.money = 0;
        // update the array of ingredients
        updateIngredients();
    }

    // a method for checking if there is enough ingredients to make a cup of coffee
    // this method returns a string with the ingredient that is not sufficient
    // if there are enough ingredients this method returns a String "isEnough"
    public String enough(String coffee) {
        if (coffee.toLowerCase().equals("espresso")) {
            for (int i = 0; i < espresso.length; i++) {
                if (espresso[i] > iArrayIngredients[i]) {
                    return Ingredients.values()[i].toString().toLowerCase();
                }
            }
        } else if (coffee.toLowerCase().equals("latte")) {
            for (int i = 0; i < latte.length; i++) {
                if (latte[i] > iArrayIngredients[i]) {
                    return Ingredients.values()[i].toString().toLowerCase();
                }
            }
        } else if (coffee.toLowerCase().equals("cappuccino")) {
            for (int i = 0; i < cappuccino.length; i++) {
                if (cappuccino[i] > iArrayIngredients[i]) {
                    return Ingredients.values()[i].toString().toLowerCase();
                }
            }
        }
        return "isEnough";
    }

    // cappuccino : reduce the ingredients used in making coffee
    public void buyCappuccino() {
        this.water        -= cappuccino[0];
        this.milk         -= cappuccino[1];
        this.coffee       -= cappuccino[2];
        this.disposalCups -= cappuccino[3];
        this.money        += cappuccino[4];
        updateIngredients();
    }

    // espresso : reduce the ingredients used in making coffee
    public void buyEspresso() {
        this.water        -= espresso[0];
        this.milk         -= espresso[1];
        this.coffee       -= espresso[2];
        this.disposalCups -= espresso[3];
        this.money        += espresso[4];
        updateIngredients();
    }

    // latte : reduce the ingredients used in making coffee
    public void buyLatte() {
        this.water        -= latte[0];
        this.milk         -= latte[1];
        this.coffee       -= latte[2];
        this.disposalCups -= latte[3];
        this.money        += latte[4];
        updateIngredients();
    }

    // updating the array of ingredients :
    public void updateIngredients() {
        iArrayIngredients[0] = this.water;
        iArrayIngredients[1] = this.milk;
        iArrayIngredients[2] = this.coffee;
        iArrayIngredients[3] = this.disposalCups;
        iArrayIngredients[4] = this.money;
    }
}