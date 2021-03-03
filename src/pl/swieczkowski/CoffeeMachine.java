package pl.swieczkowski;


import java.util.Scanner;

public class CoffeeMachine {
    public final static int WATER_FOR_ESPRESSO = 250;
    public final static int WATER_FOR_LATTE = 350;
    public final static int WATER_FOR_CAPPUCCINO = 200;

    public final static int MILK_FOR_LATTE = 75;
    public final static int MILK_FOR_CAPPUCCINO = 100;

    public final static int COFFEE_BEANS_FOR_ESPRESSO = 16;
    public final static int COFFEE_BEANS_FOR_LATTE = 20;
    public final static int COFFEE_BEANS_FOR_CAPPUCCINO = 12;

    public final static int ESPRESSO_PRICE = 4;
    public final static int LATTE_PRICE = 7;
    public final static int CAPPUCCINO_PRICE = 6;

    public static int moneyTaken = 550;
    public static int waterSupply = 400;
    public static int milkSupply = 540;
    public static int coffeeBeansSupply = 120;
    public static int disposableCups = 9;


    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        chooseOption();
    }

    private static void printSupplies() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", waterSupply);
        System.out.printf("%d of milk\n", milkSupply);
        System.out.printf("%d of coffee beans\n", coffeeBeansSupply);
        System.out.printf("%d of disposable cups\n", disposableCups);
        System.out.printf("%d of money\n", moneyTaken);
        System.out.println();
    }

    private static void printOptions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");

    }

    private static void chooseOption() {
        printOptions();
        String option = scanner.nextLine();

        String coffeeChoice;
        while (!option.equals("exit")) {
            switch (option) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    coffeeChoice = scanner.nextLine();
                    buyCoffee(coffeeChoice);
                    break;
                case "fill":
                    refillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printSupplies();
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    System.out.println("Unknown option");
                    break;
            }

            printOptions();
            option = scanner.nextLine();
        }
    }

    public static void buyCoffee(String coffeeChoice) {

        switch (coffeeChoice) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
            default:
                System.out.println("Unknown Option");
                break;
        }
    }

    private static void buyEspresso() {
        String lackIngredient;
        String message = "Sorry, not enough ";
        if (WATER_FOR_ESPRESSO > waterSupply) {
            lackIngredient = "water!";
            System.out.println(message + lackIngredient + "\n");
        } else if (COFFEE_BEANS_FOR_ESPRESSO > coffeeBeansSupply) {
            lackIngredient = "coffee beans!";
            System.out.println(message + lackIngredient + "\n");
        } else if (disposableCups <= 0) {
            lackIngredient = "cups!";
            System.out.println(message + lackIngredient + "\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            waterSupply -= WATER_FOR_ESPRESSO;
            coffeeBeansSupply -= COFFEE_BEANS_FOR_ESPRESSO;
            moneyTaken += ESPRESSO_PRICE;
            disposableCups--;
        }
    }

    private static void buyLatte() {
        String lackIngredient;
        String message = "Sorry, not enough ";
        if (WATER_FOR_LATTE > waterSupply) {
            lackIngredient = "water!";
            System.out.println(message + lackIngredient + "\n");
        } else if (MILK_FOR_LATTE > milkSupply) {
            lackIngredient = "milk!";
            System.out.println(message + lackIngredient + "\n");
        } else if (COFFEE_BEANS_FOR_LATTE > coffeeBeansSupply) {
            lackIngredient = "coffee beans!";
            System.out.println(message + lackIngredient + "\n");
        } else if (disposableCups <= 0) {
            lackIngredient = "cups!";
            System.out.println(message + lackIngredient + "\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            waterSupply -= WATER_FOR_LATTE;
            milkSupply -= MILK_FOR_LATTE;
            coffeeBeansSupply -= COFFEE_BEANS_FOR_LATTE;
            moneyTaken += LATTE_PRICE;
            disposableCups--;
        }
    }

    private static void buyCappuccino() {
        String lackIngredient;
        String message = "Sorry, not enough ";
        if (WATER_FOR_CAPPUCCINO > waterSupply) {
            lackIngredient = "water!";
            System.out.println(message + lackIngredient + "\n");
        } else if (MILK_FOR_CAPPUCCINO > milkSupply) {
            lackIngredient = "milk!";
            System.out.println(message + lackIngredient + "\n");
        } else if (COFFEE_BEANS_FOR_CAPPUCCINO > coffeeBeansSupply) {
            lackIngredient = "coffee beans!";
            System.out.println(message + lackIngredient + "\n");
        } else if (disposableCups <= 0) {
            lackIngredient = "cups!";
            System.out.println(message + lackIngredient + "\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            waterSupply -= WATER_FOR_CAPPUCCINO;
            milkSupply -= MILK_FOR_CAPPUCCINO;
            coffeeBeansSupply -= COFFEE_BEANS_FOR_CAPPUCCINO;
            moneyTaken += CAPPUCCINO_PRICE;
            disposableCups--;
        }
    }

    private static void refillMachine() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        waterSupply += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkSupply += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeansSupply += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += scanner.nextInt();
        scanner.nextLine();
        System.out.println();
    }

    private static void takeMoney() {
        System.out.printf("\nI gave you $%d\n", moneyTaken);
        System.out.println();
        moneyTaken = 0;
    }
}
