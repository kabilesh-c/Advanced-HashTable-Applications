import java.util.*;

/**
 * AutocompleteSystem
 *
 * Implements a search engine autocomplete system using
 * Trie + HashMap for frequency tracking.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class AutocompleteSystem {

    private TrieNode root;

    // query -> frequency
    private HashMap<String, Integer> frequencyMap;

    public AutocompleteSystem() {
        root = new TrieNode();
        frequencyMap = new HashMap<>();
    }

    /**
     * Insert query into Trie
     */
    public void insert(String query) {

        TrieNode node = root;

        for (char c : query.toCharArray()) {

            node.children.putIfAbsent(c, new TrieNode());

            node = node.children.get(c);
        }

        node.isEndOfWord = true;
        node.word = query;

        frequencyMap.put(query,
                frequencyMap.getOrDefault(query, 0) + 1);
    }

    /**
     * Search suggestions for prefix
     */
    public List<String> search(String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {

            if (!node.children.containsKey(c)) {
                return new ArrayList<>();
            }

            node = node.children.get(c);
        }

        List<String> results = new ArrayList<>();

        dfs(node, results);

        results.sort((a, b) ->
                frequencyMap.get(b) - frequencyMap.get(a));

        return results.size() > 10 ?
                results.subList(0, 10) : results;
    }

    /**
     * DFS traversal to collect words
     */
    private void dfs(TrieNode node, List<String> results) {

        if (node.isEndOfWord) {
            results.add(node.word);
        }

        for (TrieNode child : node.children.values()) {
            dfs(child, results);
        }
    }

    /**
     * Update query frequency
     */
    public void updateFrequency(String query) {

        insert(query);
    }

    /**
     * Demo
     */
    public static void main(String[] args) {

        AutocompleteSystem system = new AutocompleteSystem();

        system.insert("java tutorial");
        system.insert("javascript");
        system.insert("java download");
        system.insert("java tutorial");
        system.insert("java interview questions");

        List<String> suggestions = system.search("jav");

        System.out.println("Suggestions:");

        int rank = 1;

        for (String s : suggestions) {

            System.out.println(
                    rank++ + ". " + s +
                            " (" + system.frequencyMap.get(s) + ")"
            );
        }

        system.updateFrequency("java 21 features");
    }
}