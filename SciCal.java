import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SciCal {
    private double memoryValue = 0;
    private boolean isRadians = true;

    public static void main(String[] args) {
        SciCal calculator = new SciCal();
        calculator.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scientific Calculator");
            System.out.println("1. Basic Operations (+, -, *, /)");
            System.out.println("2. Trigonometric Functions (sin, cos, tan)");
            System.out.println("3. Memory Functions (M+, M-, MR)");
            System.out.println("4. Area and Volume Calculations");
            System.out.println("5. Logarithmic and Power Functions (log, exp, pow)");
            System.out.println("6. Change Angle Mode (Radians/Degrees)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    performBasicOperations(scanner);
                    break;
                case 2:
                    performTrigonometricFunctions(scanner);
                    break;
                case 3:
                    performMemoryFunctions(scanner);
                    break;
                case 4:
                    performCalculations(scanner);
                    break;
                case 5:
                    performLogarithmicAndPowerFunctions(scanner);
                    break;
                case 6:
                    toggleAngleMode();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void performBasicOperations(Scanner scanner) {
        System.out.print("Enter expression (e.g., 5 + 3): ");
        String expression = scanner.nextLine();
        String[] parts = expression.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double num2 = Double.parseDouble(parts[2]);

        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
        System.out.println("Result: " + result);
    }

    private void performTrigonometricFunctions(Scanner scanner) {
        System.out.print("Enter function (sin/cos/tan) and angle: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String function = parts[0];
        double angle = Double.parseDouble(parts[1]);

        if (!isRadians) {
            angle = Math.toRadians(angle);
        }

        double result = switch (function) {
            case "sin" -> Math.sin(angle);
            case "cos" -> Math.cos(angle);
            case "tan" -> Math.tan(angle);
            default -> 0;
        };
        System.out.println("Result: " + result);
    }

    private void performMemoryFunctions(Scanner scanner) {
        System.out.println("Memory Functions:");
        System.out.println("1. M+");
        System.out.println("2. M-");
        System.out.println("3. MR");
        System.out.print("Choose a memory function: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter number to add to memory: ");
                double valueToAdd = scanner.nextDouble();
                memoryValue += valueToAdd;
                System.out.println("Memory updated: " + memoryValue);
                break;
            case 2:
                System.out.print("Enter number to subtract from memory: ");
                double valueToSubtract = scanner.nextDouble();
                memoryValue -= valueToSubtract;
                System.out.println("Memory updated: " + memoryValue);
                break;
            case 3:
                System.out.println("Memory Recall: " + memoryValue);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void performCalculations(Scanner scanner) {
        System.out.print("Enter calculation (e.g., area of circle with radius 5): ");
        String inputText = scanner.nextLine().toLowerCase();

        if (inputText.contains("calculate area of circle with radius")) {
            Pattern pattern = Pattern.compile("radius (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double radius = Double.parseDouble(matcher.group(1));
                double area = Math.PI * radius * radius;
                System.out.println("Area of circle: " + area);
            }
        } else if (inputText.contains("calculate area of rectangle with length") && inputText.contains("and width")) {
            Pattern pattern = Pattern.compile("length (\\d+) and width (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double length = Double.parseDouble(matcher.group(1));
                double width = Double.parseDouble(matcher.group(2));
                double area = length * width;
                System.out.println("Area of rectangle: " + area);
            }
        } else if (inputText.contains("calculate area of triangle with base") && inputText.contains("and height")) {
            Pattern pattern = Pattern.compile("base (\\d+) and height (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double base = Double.parseDouble(matcher.group(1));
                double height = Double.parseDouble(matcher.group(2));
                double area = 0.5 * base * height;
                System.out.println("Area of triangle: " + area);
            }
        } else if (inputText.contains("calculate volume of cylinder with radius") && inputText.contains("and height")) {
            Pattern pattern = Pattern.compile("radius (\\d+) and height (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double radius = Double.parseDouble(matcher.group(1));
                double height = Double.parseDouble(matcher.group(2));
                double volume = Math.PI * Math.pow(radius, 2) * height;
                System.out.println("Volume of cylinder: " + volume);
            }
        } else if (inputText.contains("calculate volume of sphere with radius")) {
            Pattern pattern = Pattern.compile("radius (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double radius = Double.parseDouble(matcher.group(1));
                double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
                System.out.println("Volume of sphere: " + volume);
            }
        } else if (inputText.contains("calculate volume of cone with radius") && inputText.contains("and height")) {
            Pattern pattern = Pattern.compile("radius (\\d+) and height (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double radius = Double.parseDouble(matcher.group(1));
                double height = Double.parseDouble(matcher.group(2));
                double volume = (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
                System.out.println("Volume of cone: " + volume);
            }
        } else if (inputText.contains("calculate perimeter of rectangle with length") && inputText.contains("and width")) {
            Pattern pattern = Pattern.compile("length (\\d+) and width (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double length = Double.parseDouble(matcher.group(1));
                double width = Double.parseDouble(matcher.group(2));
                double perimeter = 2 * (length + width);
                System.out.println("Perimeter of rectangle: " + perimeter);
            }
        } else if (inputText.contains("calculate perimeter of triangle with side") && inputText.contains("and side") && inputText.contains("and side")) {
            Pattern pattern = Pattern.compile("side (\\d+) and side (\\d+) and side (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double side1 = Double.parseDouble(matcher.group(1));
                double side2 = Double.parseDouble(matcher.group(2));
                double side3 = Double.parseDouble(matcher.group(3));
                double perimeter = side1 + side2 + side3;
                System.out.println("Perimeter of triangle: " + perimeter);
            }
        } else if (inputText.contains("calculate circumference of circle with radius")) {
            Pattern pattern = Pattern.compile("radius (\\d+)");
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                double radius = Double.parseDouble(matcher.group(1));
                double circumference = 2 * Math.PI * radius;
                System.out.println("Circumference of circle: " + circumference);
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    private void performLogarithmicAndPowerFunctions(Scanner scanner) {
        System.out.print("Enter function (log, exp, pow) and values: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String function = parts[0];

        switch (function) {
            case "log":
                double value = Double.parseDouble(parts[1]);
                System.out.println("Logarithm (base 10): " + Math.log10(value));
                break;
            case "exp":
                double exponent = Double.parseDouble(parts[1]);
                System.out.println("Exponential: " + Math.exp(exponent));
                break;
            case "pow":
                double base = Double.parseDouble(parts[1]);
                double power = Double.parseDouble(parts[2]);
                System.out.println("Power: " + Math.pow(base, power));
                break;
            default:
                System.out.println("Invalid function.");
        }
    }

    private void toggleAngleMode() {
        isRadians = !isRadians;
        System.out.println("Angle mode changed to: " + (isRadians ? "Radians" : "Degrees"));
    }
}
