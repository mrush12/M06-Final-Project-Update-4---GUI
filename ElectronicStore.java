import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ElectronicStore {

    private static Map<String, Map<String, Object>> devices = new HashMap<>();
    private static List<Map<String, Object>> cart = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateDevices();
        while (true) {
            System.out.println("Welcome to Lighting Bolt Electronics!");
            System.out.println("1. Display available devices");
            System.out.println("2. Display device description");
            System.out.println("3. Display device specifications");
            System.out.println("4. Add device to cart");
            System.out.println("5. Purchase");
            System.out.println("6. FAQ");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayDevices();
                    break;
                case "2":
                    displayDevices();
                    System.out.print("Enter the device to display description: ");
                    String deviceDesc = scanner.nextLine();
                    displayDescription(deviceDesc);
                    break;
                case "3":
                    displayDevices();
                    System.out.print("Enter the device to display specifications: ");
                    String deviceSpecs = scanner.nextLine();
                    displaySpecifications(deviceSpecs);
                    break;
                case "4":
                    displayDevices();
                    System.out.print("Enter the device you want to add to the cart: ");
                    String deviceToAdd = scanner.nextLine();
                    System.out.print("Enter the quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    addToCart(deviceToAdd, quantity);
                    break;
                case "5":
                    processPurchase();
                    break;
                case "6":
                    displayFAQ();
                    break;
                case "7":
                    System.out.println("Thank you for visiting Shophouse. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void populateDevices() {
        devices.put("Laptop", createDevice(1000, "A portable computer suitable for various tasks.",
                "Processor: Intel Core i5, RAM: 8GB, Storage: 256GB SSD"));
        devices.put("Smartphone", createDevice(800, "A mobile phone with advanced features and internet connectivity.",
                "Display: 6.5-inch OLED, Camera: 12MP, Storage: 128GB"));
        devices.put("Tablet",
                createDevice(500, "A handheld device with a touchscreen display for multimedia and browsing.",
                        "Screen Size: 10.1 inches, RAM: 4GB, Storage: 64GB"));
        devices.put("Headphones", createDevice(200, "Wireless headphones for an immersive audio experience.",
                "Connectivity: Bluetooth 5.0, Battery Life: Up to 20 hours"));
        // Add more devices here
    }

    private static Map<String, Object> createDevice(int price, String description, String specifications) {
        Map<String, Object> device = new HashMap<>();
        device.put("price", price);
        device.put("description", description);
        device.put("specifications", specifications);
        return device;
    }

    private static void displayDevices() {
        System.out.println("Available Devices:");
        for (String device : devices.keySet()) {
            System.out.println(device + ": $" + devices.get(device).get("price"));
        }
    }

    private static void displayDescription(String device) {
        if (devices.containsKey(device)) {
            System.out.println("Device: " + device);
            System.out.println("Description: " + devices.get(device).get("description"));
        } else {
            System.out.println("Device not available.");
        }
    }

    private static void displaySpecifications(String device) {
        if (devices.containsKey(device)) {
            System.out.println("Device: " + device);
            System.out.println("Specifications: " + devices.get(device).get("specifications"));
        } else {
            System.out.println("Device not available.");
        }
    }

    private static void addToCart(String device, int quantity) {
        if (devices.containsKey(device)) {
            Map<String, Object> cartItem = new HashMap<>();
            cartItem.put("device", device);
            cartItem.put("quantity", quantity);
            cart.add(cartItem);
            System.out.println(quantity + " " + device + "(s) added to the cart.");
        } else {
            System.out.println("Device not available.");
        }
    }

    private static void processPurchase() {
        double totalAmount = calculateTotalAmount();
        System.out.println("Items in Cart:");
        for (Map<String, Object> cartItem : cart) {
            String device = (String) cartItem.get("device");
            int quantity = (int) cartItem.get("quantity");
            int price = (int) devices.get(device).get("price");
            System.out.println("Device: " + device + ", Quantity: " + quantity + ", Price: $" + (price * quantity));
        }
        System.out.println("Total Amount: $" + totalAmount);

        System.out.print("Would you like to proceed with the purchase? (Y/N): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            String cardName = validateCardName();
            String cardNumber = validateCardNumber();
            String expiryDate = validateCardExpiry();
            String cvv = validateCardCVV();

            System.out.println("Processing payment with card: " + cardName + ", Card Number: " + cardNumber
                    + ", Expiry Date: " + expiryDate + ", CVV: " + cvv);
            System.out.println("Payment successful. Thank you for your purchase!");
            String orderNumber = generateOrderNumber();
            System.out.println("Your order number is: " + orderNumber);
            cart.clear();
        } else {
            System.out.println("Purchase cancelled.");
        }
    }

    private static double calculateTotalAmount() {
        double total = 0;
        for (Map<String, Object> cartItem : cart) {
            String device = (String) cartItem.get("device");
            int quantity = (int) cartItem.get("quantity");
            int price = (int) devices.get(device).get("price");
            total += price * quantity;
        }
        return total;
    }

    private static String validateCardName() {
        String cardName;
        while (true) {
            System.out.print("Enter the name on the credit card: ");
            cardName = scanner.nextLine();
            if (cardName.matches("^[a-zA-Z ]+$")) {
                break;
            } else {
                System.out.println("Invalid credit card name.");
            }
        }
        return cardName;
    }

    private static String validateCardNumber() {
        String cardNumber;
        while (true) {
            System.out.print("Enter your credit card number: ");
            cardNumber = scanner.nextLine();
            if (cardNumber.matches("^\\d{16}$")) {
                break;
            } else {
                System.out.println("Invalid credit card number.");
            }
        }
        return cardNumber;
    }

    private static String validateCardExpiry() {
        String expiryDate;
        while (true) {
            System.out.print("Enter the expiration date (MM/YY): ");
            expiryDate = scanner.nextLine();
            if (expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
                String[] parts = expiryDate.split("/");
                int currentYear = Year.now().getValue() % 100;
                int currentMonth = LocalDate.now().getMonthValue();
                int inputYear = Integer.parseInt(parts[1]);
                int inputMonth = Integer.parseInt(parts[0]);
                if (inputYear >= currentYear || (inputYear == currentYear && inputMonth >= currentMonth)) {
                    break;
                }
            }
            System.out.println("Invalid credit card expiration date.");
        }
        return expiryDate;
    }

    private static String validateCardCVV() {
        String cvv;
        while (true) {
            System.out.print("Enter the CVV: ");
            cvv = scanner.nextLine();
            if (cvv.matches("^\\d{3}$")) {
                break;
            } else {
                System.out.println("Invalid credit card CVV.");
            }
        }
        return cvv;
    }

    private static String generateOrderNumber() {
        Random random = new Random();
        StringBuilder orderNumber = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            orderNumber.append(random.nextInt(10));
        }
        return orderNumber.toString();
    }

    private static void displayFAQ() {
        System.out.println("Frequently Asked Questions:");
        System.out.println("Q: Can I return a purchased device?");
        System.out.println("A: Yes, you can return a device within 30 days of purchase with the original receipt.");
        System.out.println("Q: Do the devices come with a warranty?");
        System.out.println("A: Yes, all devices come with a one-year manufacturer warranty.");
        System.out.println("Q: Can I pay with cash?");
        System.out.println("A: Currently, we only accept credit card payments.");
        System.out.println("Q: How long does shipping take?");
        System.out.println("A: Shipping usually takes 3-5 business days.");
    }
}
