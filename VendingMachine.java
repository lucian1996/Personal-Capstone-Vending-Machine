import java.text.DecimalFormat;
import java.util.*;

public class VendingMachine {
    List<Product> products = new ArrayList<>();
    DecimalFormat dollarFormat = new DecimalFormat ("$0.00");
    int balance = 0;
    boolean chips;
    boolean candy;
    boolean drink;
    boolean gum;

    public void buildVendingMachine(Scanner fileScanner) {
        while (fileScanner.hasNextLine()) {
            String fileInput = fileScanner.nextLine();
            String[] productInformation = fileInput.split("\\|");

            String itemCode = productInformation[0];
            String productName = productInformation[1];
            String category = productInformation[3];
            String price = productInformation[2];
            double pricePrototype = Double.parseDouble(productInformation[2]) * 100;
            int cents = (int)(pricePrototype);
            Product product = new Product(itemCode, productName, category, price, cents);
            products.add(product);
        }
    }

    public void getStock() {
        for (Product product : products) {
            System.out.printf("%s | %-20s | $ %s | Stock: %s%n", product.getItemCode(), product.getProductName(), product.getPrice(), product.getStock());
        }
        System.out.print("\n");
    }

    public void feedMoney(int deposit) {
        this.balance = this.balance + (deposit * 100);
    }

    public void purchase(String purchaseInput) {
        for (Product product : products) {
            if (product.getItemCode().equals(purchaseInput)) {
                if (balance >= product.getCents()) {
                    product.decreaseStock();
                    this.balance = balance - product.getCents();
                    if (product.getCategory().equals("Chip")) {
                        chips = true;
                    } else if (product.getCategory().equals("Candy")) {
                        candy = true;
                    } else if (product.getCategory().equals("Drink")) {
                        drink = true;
                    } else if (product.getCategory().equals("Gum")){
                        gum = true;
                    }
                }
            }
        }
    }

    public void finalizeTransaction() {
        if (chips) {
            System.out.println("Crunch Crunch, Yum!");
        } else if (candy) {
            System.out.println("Munch Munch, Yum!");
        } else if (drink) {
            System.out.println("Glug Glug, Yum!");
        } else if (gum) {
            System.out.println("Chew Chew, Yum!");
        }
    }

    public String balanceToDollar() {
        double dollar = balance / 100.0;
        return dollarFormat.format(dollar);
    }

}
