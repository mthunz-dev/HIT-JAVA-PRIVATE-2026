package model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Số lượng sản phẩm không hợp lệ!");
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }


    public String getDescription() {
        return product.getDescription() + " | SL: " + quantity + " | Thành tiền: " + getTotal();
    }
}