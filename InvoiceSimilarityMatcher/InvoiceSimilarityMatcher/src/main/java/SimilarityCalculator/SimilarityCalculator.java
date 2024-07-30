package SimilarityCalculator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarityCalculator {

    public static double calculateCosineSimilarity(Map<String, Object> features1, Map<String, Object> features2) {
        Set<String> allFeatures = new HashSet<>();
        allFeatures.addAll(features1.keySet());
        allFeatures.addAll(features2.keySet());

        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;

        for (String feature : allFeatures) {
            double value1 = features1.getOrDefault(feature, 0).hashCode();
            double value2 = features2.getOrDefault(feature, 0).hashCode();

            dotProduct += value1 * value2;
            magnitude1 += Math.pow(value1, 2);
            magnitude2 += Math.pow(value2, 2);
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        if (magnitude1 == 0.0 || magnitude2 == 0.0) {
            return 0.0;
        } else {
            return dotProduct / (magnitude1 * magnitude2);
        }
    }

    public static double calculateJaccardSimilarity(Map<String, Object> features1, Map<String, Object> features2) {
        Set<String> set1 = features1.keySet();
        Set<String> set2 = features2.keySet();
        int intersection = 0;
        for (String key : set1) {
            if (set2.contains(key)) {
                intersection++;
            }
        }
        int union = set1.size() + set2.size() - intersection;
        return (double) intersection / union;
    }
}
