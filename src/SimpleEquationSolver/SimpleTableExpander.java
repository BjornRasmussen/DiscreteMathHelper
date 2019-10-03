package SimpleEquationSolver;

import java.util.Scanner;

public class SimpleTableExpander {

    public static void main(String[] args) {
        System.out.println("Equation looks like this: AX + BY = D, where X, and Y are not known.");
        System.out.println("Enter A:");
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        System.out.println("Now enter B:");
        long b = input.nextLong();
        input.close();


        MagicTable table = new MagicTable(a, b);


        printTable(table);
    }

    private static void printTable(MagicTable table) {
        long x = table.getFinalX();
        long y = table.getFinalY();
        long rem = table.getFinalRemainder();
        long a = table.getIniitialA();
        long b = table.getIniitialB();
        long[][] array = table.getTable();
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j][i] + " | ");
            }
            System.out.println();
        }
        System.out.println("\n" + a + "*" + x + " + " + b + "*" + y + "  =  " + rem + "\n");

    }
}
