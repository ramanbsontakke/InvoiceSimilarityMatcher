# InvoiceSimilarityMatcher


## Overview

This project implements a document similarity matching system in Java. It uses TF-IDF (Term Frequency-Inverse Document Frequency) to represent documents and computes the similarity between them using cosine similarity.

## Approach

### Document Representation

- **TF-IDF (Term Frequency-Inverse Document Frequency)**: 
  - Each document is represented as a vector where each element corresponds to a term's TF-IDF score.
  - **Term Frequency (TF)** measures how frequently a term occurs in a document.
  - **Inverse Document Frequency (IDF)** measures how important a term is across all documents.

### Similarity Metric

- **Cosine Similarity**: 
  - Measures the cosine of the angle between two vectors. It ranges from -1 to 1, where 1 indicates identical direction and -1 indicates opposite directions. The formula is:

  \[
  \text{Cosine Similarity} = \frac{\sum (A_i \cdot B_i)}{\sqrt{\sum (A_i^2)} \cdot \sqrt{\sum (B_i^2)}}
  \]

## Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Running the Code

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/document-similarity.git
   cd document-similarity
