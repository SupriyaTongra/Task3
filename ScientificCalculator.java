import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Scientific Calculator!");

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square Root (√)");
            System.out.println("6. Exponentiation (^)");
            System.out.println("7. Exit");

            int choice = getValidChoice(scanner);

            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            }

            double result;

            switch (choice) {
                case 1:
                    result = getValidNumber(scanner, "Enter first number: ") + getValidNumber(scanner, "Enter second number: ");
                    break;
                case 2:
                    result = getValidNumber(scanner, "Enter first number: ") - getValidNumber(scanner, "Enter second number: ");
                    break;
                case 3:
                    result = getValidNumber(scanner, "Enter first number: ") * getValidNumber(scanner, "Enter second number: ");
                    break;
                case 4:
                    double divisor;
                    do {
                        divisor = getValidNumber(scanner, "Enter the divisor (non-zero): ");
                    } while (divisor == 0);
                    result = getValidNumber(scanner, "Enter the dividend: ") / divisor;
                    break;
                case 5:
                    result = Math.sqrt(getValidNumber(scanner, "Enter the number to find the square root of: "));
                    break;
                case 6:
                    result = Math.pow(getValidNumber(scanner, "Enter the base: "), getValidNumber(scanner, "Enter the exponent: "));
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    continue;
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static int getValidChoice(Scanner scanner) {
        int choice = 0;
        boolean isValid = false;

        while (!isValid) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 7) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid numerical value.");
                scanner.next(); // Consume the invalid input
            }
        }

        return choice;
    }

    private static double getValidNumber(Scanner scanner, String prompt) {
        double number = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid numerical value.");
                scanner.next(); // Consume the invalid input
            }
        }

        return number;
    }
}
