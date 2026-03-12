import java.util.*;

/**
 * PlagiarismDetector
 *
 * Detects similarity between documents using n-gram hashing.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class PlagiarismDetector {

    // ngram -> document IDs
    private HashMap<String, Set<String>> ngramIndex;

    public PlagiarismDetector() {
        ngramIndex = new HashMap<>();
    }

    /**
     * Add document to the system
     */
    public void addDocument(String docId, String text) {

        List<String> ngrams = DocumentProcessor.generateNGrams(text, 5);

        for (String gram : ngrams) {

            ngramIndex
                    .computeIfAbsent(gram, k -> new HashSet<>())
                    .add(docId);
        }
    }

    /**
     * Analyze document similarity
     */
    public void analyzeDocument(String docId, String text) {

        List<String> ngrams = DocumentProcessor.generateNGrams(text, 5);

        HashMap<String, Integer> matchCounts = new HashMap<>();

        for (String gram : ngrams) {

            if (ngramIndex.containsKey(gram)) {

                for (String existingDoc : ngramIndex.get(gram)) {

                    matchCounts.put(
                            existingDoc,
                            matchCounts.getOrDefault(existingDoc, 0) + 1
                    );
                }
            }
        }

        System.out.println("Analysis for Document: " + docId);

        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {

            double similarity =
                    (entry.getValue() * 100.0) / ngrams.size();

            System.out.println(
                    "Matched with " + entry.getKey() +
                            " → Similarity: " + similarity + "%"
            );
        }
    }

    /**
     * Demo Main Method
     */
    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        String doc1 =
                "machine learning enables computers to learn from data";

        String doc2 =
                "machine learning allows computers to learn from large data sets";

        String doc3 =
                "artificial intelligence and machine learning are related fields";

        detector.addDocument("essay_001", doc1);
        detector.addDocument("essay_002", doc2);

        detector.analyzeDocument("essay_003", doc3);
    }
}