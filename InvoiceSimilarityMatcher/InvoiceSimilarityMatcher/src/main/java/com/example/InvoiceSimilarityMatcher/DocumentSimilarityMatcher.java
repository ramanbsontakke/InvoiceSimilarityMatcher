package com.example.InvoiceSimilarityMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import SimilarityCalculator.SimilarityCalculator;

@Component
public class DocumentSimilarityMatcher {

    private List<Map<String, Object>> invoiceDatabase = new ArrayList<>();
    private double highestSimilarityScore = 0.0;

    public void addInvoice(Map<String, Object> invoice) {
        invoiceDatabase.add(invoice);
    }

    public String findMostSimilarInvoice(Map<String, Object> features) {
        String mostSimilarInvoice = null;
        for (Map<String, Object> invoice : invoiceDatabase) {
            double similarityScore = SimilarityCalculator.calculateCosineSimilarity(features, invoice);
            if (similarityScore > highestSimilarityScore) {
                highestSimilarityScore = similarityScore;
                mostSimilarInvoice = (String) invoice.get("invoiceNumber");
            }
        }
        return mostSimilarInvoice;
    }

    public double getSimilarityScore() {
        return highestSimilarityScore;
    }
}
