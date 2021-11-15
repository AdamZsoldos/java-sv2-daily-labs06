package day01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PositiveNumberContainer pnc = new PositiveNumberContainer();
        double d;

        while (true) {
            System.out.print("Enter a number: ");
            d = scanner.nextDouble();
            scanner.nextLine();
            if (d <= 0) break;
            pnc.addNumber(d);
        }

        System.out.println(pnc.getNumbers());
    }
}
