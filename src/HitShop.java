import Buoi2.Item;
import model.CartItem;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    static final ArrayList<CartItem> cart = new ArrayList<>();

    static final Product P01 = new Product("P01", "Áo thun", 150000, 20);
    static final Product P02 = new Product("P02", "Bình nước", 50000, 10);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> System.out.println("Thoát khỏi menu.");
                case 1 -> readAndAddItem(scanner);
                case 2 -> readAndRemoveItem(scanner);
                case 3 -> printCart();
                case 4 -> calculateTotalPrice();
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại !");
            }

        } while (choice != 0);
    }

    static void readAndAddItem(Scanner sc) {

        System.out.println("=====SẢN PHẨM HIỆN CÓ=====");
        System.out.println(P01.getId() + " | " + P01.getName());
        System.out.println(P02.getId() + " | " + P02.getName());

        System.out.print("Nhập mã sản phẩm muốn thêm vào: ");

        String inputId = sc.nextLine();

        if (!inputId.equals("P01") && !inputId.equals("P02")) {
            System.out.println("Không tìm thấy mặt hàng");
            return;
        }

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());

        if (quantity <= 0) {
            System.out.println("Số lượng sản phẩm không hợp lệ!");
            return;
        }

        Product product = inputId.equals("P01") ? P01 : P02;
        addItem(product, quantity);
    }

    static void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        cart.add(item);
    }

    static void readAndRemoveItem(Scanner sc) {

        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống !");
            return;
        }

        printCart();
        System.out.print("Nhập số thứ tự mặt hàng muốn xoá: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index > cart.size()) {
            System.out.println("Không tìm thấy mặt hàng!");
            return;
        }

        removeItem(index);
    }

    static void removeItem(int index) {
        cart.remove(index);
        System.out.println("Xoá sản phẩm thành công!");
    }

    static void printCustomer() {
        System.out.println(currentCustomer.toString());
    }

    static void printItems() {
        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống !");
            return;
        }

        System.out.println("=====GIỎ HÀNG CỦA BẠN===== ");

        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            Product product = item.getProduct();

            System.out.printf("%d. %s | %s | %.1f | SL: %d | Thành tiền: %.1f%n", i + 1, product.getId(), product.getName(), product.getPrice(), item.getQuantity(), item.getTotal());
        }
    }

    static void printCart() {
        printCustomer();
        printItems();
    }

    static void calculateTotalPrice() {

        double total = 0;
        for (CartItem i : cart) {
            total += i.getTotal();
        }

        System.out.println("Tổng tiền trong giỏ hàng của bạn: " + total);
    }

    static void printMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xoá mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
}
