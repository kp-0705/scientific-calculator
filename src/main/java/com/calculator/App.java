package com.calculator;
import java.util.Scanner;
public class App {

    public static double squareRoot(double x)
    {
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) return -1;
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double x) {
        return Math.log(x);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double num = sc.nextDouble();
                    System.out.println("Result: " + squareRoot(num));
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println("Result: " + factorial(n));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double ln = sc.nextDouble();
                    System.out.println("Result: " + naturalLog(ln));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = sc.nextDouble();
                    System.out.println("Result: " + power(base, exp));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
