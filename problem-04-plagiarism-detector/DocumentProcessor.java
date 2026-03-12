import java.util.*;

/**
 * DocumentProcessor
 *
 * Responsible for extracting n-grams from a document.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class DocumentProcessor {

    /**
     * Generate n-grams from text
     */
    public static List<String> generateNGrams(String text, int n) {

        List<String> ngrams = new ArrayList<>();

        String[] words = text.toLowerCase().split("\\s+");

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder gram = new StringBuilder();

            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }

            ngrams.add(gram.toString().trim());
        }

        return ngrams;
    }
}