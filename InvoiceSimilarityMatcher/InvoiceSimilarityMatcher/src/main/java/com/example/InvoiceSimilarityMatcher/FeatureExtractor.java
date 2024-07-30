package com.example.InvoiceSimilarityMatcher;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FeatureExtractor {

    private static final Set<String> STOPWORDS = Set.of(
            "the", "and", "is", "in", "to", "with", "a", "of", "for", "on", "it", "at", "by", "from"
    );

    public static Map<String, Object> extractFeatures(String text) {
        Map<String, Object> features = new HashMap<>();
        features.put("keywords", extractKeywords(text));
        features.put("invoiceNumber", extractInvoiceNumber(text));
        features.put("date", extractDate(text));
        features.put("amount", extractAmount(text));
        return features;
    }

    private static List<String> extractKeywords(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (!STOPWORDS.contains(word.toLowerCase())) {
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        return wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static String extractInvoiceNumber(String text) {
        Pattern pattern = Pattern.compile("\\b(?:INV|INVOICE)\\s*[:#-]?\\s*(\\d{3,})\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Unknown";
    }

    private static String extractDate(String text) {
        Pattern pattern = Pattern.compile("\\b(\\d{1,2}[/-]\\d{1,2}[/-]\\d{2,4})\\b");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Unknown";
    }

    private static String extractAmount(String text) {
        Pattern pattern = Pattern.compile("\\b\\$?([0-9]+[,.]?[0-9]{0,2})\\b");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Unknown";
    }
}
