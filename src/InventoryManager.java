import java.io.*;
import java.util.*;

public class InventoryManager {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileName = "src/inventory.txt";

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Item");
            System.out.println("3. Update Item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> readInventory(fileName);
                case 2 -> {
                    System.out.print("Enter item name: ");
                    String itemName = scan.nextLine();
                    System.out.print("Enter item count: ");
                    int itemCount = scan.nextInt();
                    addItem(fileName, itemName, itemCount);
                }
                case 3 -> {
                    System.out.print("Enter item name: ");
                    String itemName = scan.nextLine();
                    System.out.print("Enter new item count: ");
                    int itemCount = scan.nextInt();
                    updateItem(fileName, itemName, itemCount);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void readInventory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Current Inventory:");
            boolean inventoryEmpty = true;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 2) {
                    System.out.println("Warning: Skipping invalid line: " + line);
                    continue;
                }

                String itemName = parts[0].trim();
                String itemCount = parts[1].trim();

                try {
                    int count = Integer.parseInt(itemCount);
                    System.out.println(itemName + " - " + count);
                    inventoryEmpty = false;
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid count for item '" + itemName + "', skipping line.");
                }
            }

            if (inventoryEmpty) {
                System.out.println("No items in inventory.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading the inventory file.");
        }
    }


    public static void addItem(String fileName, String itemName, int itemCount) {
        try {
            if (itemExists(fileName, itemName)) {
                System.out.println("Item already exists. Use the update option to modify it.");
                return;
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(itemName + "," + itemCount);
                writer.newLine();
                System.out.println("Item added successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error writing to the inventory file.");
        }
    }

    public static void updateItem(String fileName, String itemName, int itemCount) {
        File inputFile = new File(fileName);
        File tempFile = new File("src/temp_inventory.txt");

        boolean updated = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(itemName.trim())) {
                    writer.write(itemName.trim() + "," + itemCount);
                    updated = true;
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }

            if (!updated) {
                System.out.println("Item not found. Use the add option to create it.");
            } else {
                System.out.println("Item updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error updating the inventory file.");
        }

        if (updated) {
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }
        } else {
            tempFile.delete();
        }
    }


    private static boolean itemExists(String fileName, String itemName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(itemName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occured");
        }
        return false;
    }


}
