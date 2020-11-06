package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.handleAction();
    }

    final Scanner scanner = new Scanner(System.in);
    int water;
    int money;
    int milk ;
    int coffeeBeans;
    int cups;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void handleAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        String action = scanner.nextLine();

        while (true) {
            switch (action) {
                case "buy":
                    buy();
                    break;

                case "fill":
                    fill();
                    break;

                case "take":
                    take();
                    break;

                case "remaining":
                    coffeeMachineState();
                    break;

                case "exit":
                    exit();
                    break;
            }
            handleAction();
        }

    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        setMoney(0);
    }


    public void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        setWater(this.water + scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        setMilk(this.milk + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        setCoffeeBeans(coffeeBeans + scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        setCups(cups + scanner.nextInt());
    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String action = scanner.nextLine();

        switch (action) {
            case "1":
                makeEspresso();
                break;

            case "2":
                makeLatte();
                break;

            case "3":
                makeCappuccino();
                break;
            case "back":
                handleAction();
                break;

        }
    }

    public void checkResources(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cupsNeeded, int cost) {
        int waterRequired = this.water - waterNeeded;
        int milkRequired = this.milk - milkNeeded;
        int coffeeBeansRequired = this.coffeeBeans - coffeeBeansNeeded;
        int cupsRequired = this.cups - cupsNeeded;

        if (waterRequired < 0) {
            System.out.println("Sorry, not enough water!");
        }

        if (milkRequired < 0) {
            System.out.println("Sorry, not enough milk!");
        }

        if (coffeeBeansRequired < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        }

        if (cupsRequired < 0) {
            System.out.println("Sorry, not enough cups!");
        }

        if (waterRequired > 0 && milkRequired > 0 && coffeeBeansRequired > 0 && cupsRequired >0) {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= waterNeeded;
            this.milk -= milkNeeded;
            this.coffeeBeans -= coffeeBeansNeeded;
            this.cups -= cupsNeeded;
            this.money += cost;
        }
    }

    public void makeCappuccino() {
        checkResources(200, 100, 12,1,6);
    }

    public void makeLatte() {
        checkResources(350, 75, 20, 1, 7);
    }

    public void makeEspresso() {
        checkResources(250, 0, 16, 1, 4);
    }

    public void coffeeMachineState() {
        System.out.println("\nThe coffee machine has: \n" +
                this.water + " of water\n" +
                this.milk + " of milk\n" +
                this.coffeeBeans + " of coffee beans\n" +
                this.cups + " of disposable cups\n" +
                "$" + this.money + " of money\n");

    }

    public static void exit() {
        System.exit(1);
    }
}