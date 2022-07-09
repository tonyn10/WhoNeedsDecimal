import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String response = "y";    // continue?
        while(response.equalsIgnoreCase("y")) {
            runDecimalToBinary();
//            runBinaryToDecimal();
//            runDecimalToHex();
//            runHexToDecimal();
            System.out.print("Continue (y/n)? ");
            response = input.nextLine().trim();
        }
        input.close();
    }

    private static void runDecimalToBinary() {
        System.out.print("Enter number: ");
        Integer num = null;
        while (num == null) {
            try {
                num = Integer.parseInt(input.nextLine().trim());    // parseInt throws NumberFormatException if int is too large
            } catch (NumberFormatException e) {
                System.out.print("Not a proper number. Try again: ");
            }
        }
        System.out.println("Binary: " + Binary.getBinary(num));
    }

    private static void runBinaryToDecimal() {
        System.out.print("Enter a binary: ");
        String binary = input.nextLine().trim();
        while(!Binary.isBinary(binary)) {
            System.out.print("Not a proper binary. Try again: ");
            binary = input.nextLine().trim();
        }
        System.out.println("Decimal: " + Binary.getDecimal(binary));
    }

    private static void runDecimalToHex() {
        System.out.print("Enter number: ");
        Integer num = null;
        while (num == null) {
            try {
                num = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Not a proper number. Try again: ");
            }
        }
        System.out.println("Hex: " + Hex.getHex(num));
    }

    private static void runHexToDecimal() {
        System.out.print("Enter a hexadecimal: ");
        String hex = input.nextLine().trim();
        while(!Hex.isHex(hex)) {
            System.out.print("Not a proper hexadecimal. Try again: ");
            hex = input.nextLine().trim();
        }
        System.out.println("Decimal: " + Hex.getDecimal(hex));
    }
}