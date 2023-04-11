import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Interface {
    static Scanner input = new Scanner(System.in);
    static VendingMachine user = new VendingMachine();
    static boolean mainMenu = true;
    static boolean purchaseMenu = true;


    public static void main(String[] args) {
        File inputFile = new File("VendingMachine.csv");
        try (Scanner fileScanner = new Scanner(inputFile)) {
            user.buildVendingMachine(fileScanner);
            System.out.println("build Complete.");
        } catch (FileNotFoundException e) {
            System.out.println("build Failed.");
        }

        while (mainMenu) {
            getMainMenu();
            String mainMenuOption = input.next();
            switch (mainMenuOption) {
                case "1" :  //  Get Stock
                    user.getStock();
                    break;
                case "2" :  //  Purchase Menu
                    while (purchaseMenu) {
                        getPurchaseMenu();
                        String purchaseMenuInput = input.next();
                        switch (purchaseMenuInput) {
                            case "1" :  //  Add Funds
                                System.out.println("Deposit Bills:");
                                int deposit = Integer.parseInt(input.next());
                                user.feedMoney(deposit);
                                break;
                            case "2" :  //  Purchase
                                user.getStock();
                                System.out.println("Select Product:");
                                String purchaseInput = input.next();
                                user.purchase(purchaseInput);
                                break;
                            case "3" :  //  Finalize Transaction
                                user.finalizeTransaction();
                                purchaseMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                    purchaseMenu = true;
                    break;
                case "3" :  //  Exit
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void getMainMenu() {
        String[] displayOptions = new String[4];
        displayOptions[0] = "-- Main Menu --";
        displayOptions[1] = "(1) Display Products";
        displayOptions[2] = "(2) Purchase";
        displayOptions[3] = "(3) Exit";

        System.out.println("Current Balance: " + user.balanceToDollar());
        for (String option : displayOptions) {
            System.out.println(option);
        }
    }

    public static void getPurchaseMenu() {
        String[] displayOptions = new String[4];
        displayOptions[0] = "-- Purchase Menu --";
        displayOptions[1] = "(1) Feed Money";
        displayOptions[2] = "(2) Purchase";
        displayOptions[3] = "(3) Finalize Transaction";

        System.out.println("Current Balance: " + user.balanceToDollar());
        for (String option : displayOptions) {
            System.out.println(option);
        }
    }

}
