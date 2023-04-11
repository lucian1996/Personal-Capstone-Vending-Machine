public class Product {
    String itemCode;
    String productName;
    String category;
    String price;
    int cents;
    int stock;

    public Product(String itemCode, String productName, String category, String price, int cents) {
        this.itemCode = itemCode;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.cents = cents;
        this.stock = 5;
    }

    public void decreaseStock() {
        this.stock = stock - 1;
    }

    public String getItemCode() {
        return itemCode;
    }
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category;
    }
    public String getPrice() {
        return price;
    }
    public int getCents() {
        return cents;
    }
    public int getStock() {
        return stock;
    }

}
