package Buoi1;

import java.util.Scanner;

public class RectangleCalculator {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width, height;

        do {
            System.out.print("Nhap chieu dai: ");
            height = sc.nextDouble();

            if (height <= 0) System.out.println("Chieu dai phai la so duong !");

        } while (height <= 0);

        do {
            System.out.print("Nhap chieu rong: ");
            width = sc.nextDouble();

            if (width <= 0) System.out.println("Chieu rong phai la so duong !");

        } while (width <= 0);


        System.out.println("Chieu dai: " + height);
        System.out.println("Chieu rong: " + width);
        System.out.println("Chu vi: " + calPerimeter(height, width));
        System.out.println("Dien tich: " + calArea(height, width));

        sc.close();
    }

    public static double calPerimeter(double width, double height) {
        return 2 * (width + height);
    }

    public static double calArea(double width, double height) {
        return width * height;
    }

}
