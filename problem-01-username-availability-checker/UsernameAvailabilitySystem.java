import java.util.*;

/**
 * UsernameAvailabilitySystem
 *
 * Problem 1: Social Media Username Availability Checker
 *
 * This system simulates a registration service for a social media platform
 * with millions of users checking username availability in real time.
 *
 * Key Features:
 * - O(1) username availability check using HashMap
 * - Suggest alternative usernames
 * - Track popularity of attempted usernames
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class UsernameAvailabilitySystem {

    // username -> userId
    private HashMap<String, Integer> registeredUsers;

    // username -> attempt count
    private HashMap<String, Integer> usernameAttempts;

    public UsernameAvailabilitySystem() {
        registeredUsers = new HashMap<>();
        usernameAttempts = new HashMap<>();
    }

    /**
     * Register a user with username
     */
    public void registerUser(String username, int userId) {
        registeredUsers.put(username, userId);
    }

    /**
     * Check username availability
     */
    public boolean checkAvailability(String username) {

        // Track attempt frequency
        usernameAttempts.put(username,
                usernameAttempts.getOrDefault(username, 0) + 1);

        return !registeredUsers.containsKey(username);
    }

    /**
     * Suggest alternative usernames
     */
    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username + "123");
        suggestions.add(username.replace("_", "."));
        suggestions.add(username + "_official");

        return suggestions;
    }

    /**
     * Get most attempted username
     */
    public String getMostAttempted() {

        String mostAttempted = "";
        int maxAttempts = 0;

        for (Map.Entry<String, Integer> entry : usernameAttempts.entrySet()) {

            if (entry.getValue() > maxAttempts) {
                maxAttempts = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }

        return mostAttempted + " (" + maxAttempts + " attempts)";
    }

    /**
     * Demo main method
     */
    public static void main(String[] args) {

        UsernameAvailabilitySystem system = new UsernameAvailabilitySystem();

        // Pre-register some users
        system.registerUser("john_doe", 1001);
        system.registerUser("admin", 1002);
        system.registerUser("superuser", 1003);

        System.out.println("===== Username Availability Checker =====");

        System.out.println("Check 'john_doe': "
                + system.checkAvailability("john_doe"));

        System.out.println("Check 'jane_smith': "
                + system.checkAvailability("jane_smith"));

        System.out.println("\nSuggestions for 'john_doe':");

        List<String> suggestions =
                system.suggestAlternatives("john_doe");

        for (String s : suggestions) {
            System.out.println("- " + s);
        }

        // Simulate repeated attempts
        system.checkAvailability("admin");
        system.checkAvailability("admin");
        system.checkAvailability("admin");

        System.out.println("\nMost Attempted Username: "
                + system.getMostAttempted());
    }
}