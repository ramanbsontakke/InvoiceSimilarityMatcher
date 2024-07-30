package com.example.InvoiceSimilarityMatcher;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private DocumentSimilarityMatcher documentSimilarityMatcher;

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String extractedText = PDFExtractor.extractText(file);
        Map<String, Object> features = FeatureExtractor.extractFeatures(extractedText);
        documentSimilarityMatcher.addInvoice(features);

     // Assuming findMostSimilarInvoice() returns a String
        String mostSimilarInvoice = documentSimilarityMatcher.findMostSimilarInvoice(features);

        double similarityScore = documentSimilarityMatcher.getSimilarityScore();

        return ResponseEntity.ok(Map.of("similarInvoice", mostSimilarInvoice, "similarityScore", similarityScore));

    }
}
