import java.util.HashMap;

/**
 * TrieNode
 *
 * Node for Trie used in autocomplete system.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class TrieNode {

    HashMap<Character, TrieNode> children;

    boolean isEndOfWord;

    String word;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}