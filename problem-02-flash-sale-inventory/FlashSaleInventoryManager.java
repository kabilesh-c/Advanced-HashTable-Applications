import java.util.*;

/**
 * FlashSaleInventoryManager
 *
 * Problem 2: E-commerce Flash Sale Inventory Manager
 *
 * Simulates high demand product sales where thousands of users
 * attempt to buy limited inventory simultaneously.
 *
 * Features:
 * - Real-time stock lookup using HashMap
 * - Thread-safe purchase handling
 * - Waiting list for out-of-stock users
 * - O(1) stock lookup performance
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class FlashSaleInventoryManager {

    // productId -> stock count
    private HashMap<String, Integer> inventory;

    // productId -> waiting list
    private HashMap<String, Queue<Integer>> waitingList;

    public FlashSaleInventoryManager() {
        inventory = new HashMap<>();
        waitingList = new HashMap<>();
    }

    /**
     * Add product to inventory
     */
    public void addProduct(String productId, int stock) {
        inventory.put(productId, stock);
        waitingList.put(productId, new LinkedList<>());
    }

    /**
     * Check stock availability
     */
    public int checkStock(String productId) {
        return inventory.getOrDefault(productId, 0);
    }

    /**
     * Purchase item (Thread Safe)
     */
    public synchronized String purchaseItem(String productId, int userId) {

        int currentStock = inventory.getOrDefault(productId, 0);

        if (currentStock > 0) {

            inventory.put(productId, currentStock - 1);

            return "SUCCESS: User " + userId +
                    " purchased " + productId +
                    " | Remaining stock: " + (currentStock - 1);

        } else {

            Queue<Integer> queue = waitingList.get(productId);
            queue.add(userId);

            return "OUT OF STOCK: User " + userId +
                    " added to waiting list position #" + queue.size();
        }
    }

    /**
     * Display waiting list
     */
    public void displayWaitingList(String productId) {

        Queue<Integer> queue = waitingList.get(productId);

        System.out.println("\nWaiting List for " + productId + ":");

        for (Integer user : queue) {
            System.out.println("User ID: " + user);
        }
    }

    /**
     * Demo Main Method
     */
    public static void main(String[] args) {

        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();

        String product = "IPHONE15_256GB";

        // Initialize product with stock
        manager.addProduct(product, 3);

        System.out.println("Stock Available: "
                + manager.checkStock(product));

        System.out.println(manager.purchaseItem(product, 101));
        System.out.println(manager.purchaseItem(product, 102));
        System.out.println(manager.purchaseItem(product, 103));

        // Stock finished
        System.out.println(manager.purchaseItem(product, 104));
        System.out.println(manager.purchaseItem(product, 105));

        manager.displayWaitingList(product);
    }
}