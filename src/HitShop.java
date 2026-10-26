import java.util.Scanner;

public class HitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productName;
        double price;
        int quantity;
        double totalPrice;
        final double VAT_RATE = 0.10;
        final int SHIPPING_FEE = 20000;

        System.out.print("Nhap ten mat hang: ");
        productName = sc.nextLine();

        System.out.print("Nhap don gia: ");
        price = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        quantity = sc.nextInt();

        totalPrice = price * quantity * (1 + VAT_RATE) + SHIPPING_FEE;

        System.out.println("Thong tin mat hang vua nhap: ");
        System.out.println("Mat hang: " + productName);
        System.out.println("Don gia: " + price);
        System.out.println("So luong: " + quantity);
        System.out.println("Thanh tien: " + (int)totalPrice);
    }
}
