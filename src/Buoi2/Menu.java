package Buoi2;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    static final ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> System.out.println("Thoát khỏi menu.");
                case 1 -> readAndAddItem(scanner);
                case 2 -> readAndDeleteItem(scanner);
                case 3 -> printCart();
                case 4 -> calculateTotalPrice();
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại !");
            }

        } while (choice != 0);
    }

    static void readAndAddItem(Scanner sc) {

        System.out.print("Nhập tên sản phẩm muốn thêm vào: ");
        String name = sc.nextLine();
        System.out.print("Nhap giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Item item = new Item(name, price, quantity);
        items.add(item);
        System.out.println("Thêm mặt hàng thành công!");
    }

    static void readAndDeleteItem(Scanner sc) {
        System.out.print("Nhập số thứ tự mặt hàng muốn xoá: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index > items.size()) {
            System.out.println("Số thứ tự không hợp lệ!");
            return;
        }

        items.remove(index);
        System.out.println("Xoá sản phẩm thành công!");
    }

    static void printCart() {

        if (items.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống !");
            return;
        }

        System.out.println("Gio hang cua ban: ");

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n", i + 1, item.getName(), item.getPrice(), item.getQuantity(), item.getTotalPrice());
        }
    }

    static void calculateTotalPrice() {

        double total = 0;
        for (Item i : items) {
            total += i.getTotalPrice();
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
