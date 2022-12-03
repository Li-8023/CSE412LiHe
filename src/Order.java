public class Order {
//cart_item
    private int cart_id;
    private int product_id;
    private int amount;
    private int quantity;
    private double totalPrice;

    @Override
    public String toString() {
        return "Order{" +
                "cart_id=" + cart_id +
                ", product_id=" + product_id +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Order(int cart_id, int product_id, int amount, int quantity, double totalPrice) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.amount = amount;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCart_id() {
        return cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}
