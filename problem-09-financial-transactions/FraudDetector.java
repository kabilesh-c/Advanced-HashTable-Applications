import java.util.*;

/**
 * FraudDetector
 *
 * Implements financial fraud detection using Two-Sum variants.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class FraudDetector {

    /**
     * Classic Two Sum
     */
    public static List<Transaction[]> findTwoSum(List<Transaction> transactions, int target) {

        HashMap<Integer, Transaction> map = new HashMap<>();

        List<Transaction[]> result = new ArrayList<>();

        for (Transaction t : transactions) {

            int complement = target - t.amount;

            if (map.containsKey(complement)) {

                result.add(new Transaction[]{map.get(complement), t});
            }

            map.put(t.amount, t);
        }

        return result;
    }

    /**
     * Duplicate detection
     */
    public static Map<String, List<Transaction>> detectDuplicates(List<Transaction> transactions) {

        Map<String, List<Transaction>> map = new HashMap<>();

        for (Transaction t : transactions) {

            String key = t.amount + "-" + t.merchant;

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(t);
        }

        return map;
    }

    /**
     * K Sum (simple 3-sum demo)
     */
    public static void findThreeSum(List<Transaction> transactions, int target) {

        int n = transactions.size();

        for (int i = 0; i < n - 2; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int needed = target - transactions.get(i).amount - transactions.get(j).amount;

                if (set.contains(needed)) {

                    System.out.println(
                            "3-Sum Found: "
                                    + transactions.get(i).amount + ", "
                                    + transactions.get(j).amount + ", "
                                    + needed
                    );
                }

                set.add(transactions.get(j).amount);
            }
        }
    }

    /**
     * Demo
     */
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, 500, "StoreA", "acc1", "10:00"));
        transactions.add(new Transaction(2, 300, "StoreB", "acc2", "10:15"));
        transactions.add(new Transaction(3, 200, "StoreC", "acc3", "10:30"));
        transactions.add(new Transaction(4, 500, "StoreA", "acc4", "11:00"));

        System.out.println("Two Sum Results:");

        List<Transaction[]> pairs = findTwoSum(transactions, 500);

        for (Transaction[] pair : pairs) {

            System.out.println(pair[0] + " + " + pair[1]);
        }

        System.out.println("\nDuplicate Transactions:");

        Map<String, List<Transaction>> duplicates = detectDuplicates(transactions);

        for (String key : duplicates.keySet()) {

            List<Transaction> list = duplicates.get(key);

            if (list.size() > 1) {

                System.out.println("Duplicate group: " + key);

                for (Transaction t : list) {

                    System.out.println(t);
                }
            }
        }

        System.out.println("\nThree Sum Detection:");

        findThreeSum(transactions, 1000);
    }
}