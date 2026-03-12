# Problem 4 — Plagiarism Detection System

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

A university needs to check **student essays against a database of 100,000 documents** to detect plagiarism.

Simple string comparison is too slow.

Instead we use **n‑gram hashing**.

---

## Problem Statement

Build a plagiarism detection system that:

- Breaks documents into n‑grams
- Stores n‑grams in a hash table
- Finds matching n‑grams between documents
- Calculates similarity percentage
- Identifies suspicious documents

---

## System Design
Document
│
▼
DocumentProcessor
│
▼
Generate n‑grams
│
▼
HashMap Index
(ngram → document IDs)
│
▼
Similarity Calculation


---

## Key Concepts

### N‑Grams

An n‑gram is a sequence of **n words**.

Example (5‑gram):
machine learning enables computers to
learning enables computers to learn


---

### HashMap Index
HashMap<String, Set<DocumentId>>


Example:
"machine learning enables computers to"
→ [essay_001, essay_089]


This allows **fast lookup of matching phrases**.

---

## Similarity Calculation
similarity = (matching_ngrams / total_ngrams) × 100


Example:
450 n‑grams total
67 matches

Similarity = 14.9%


---

## Example Output
Analysis for Document: essay_003

Matched with essay_001 → Similarity: 18.5%
Matched with essay_002 → Similarity: 12.1%


---

## Real World Systems

- Turnitin plagiarism detection
- MOSS code similarity detection
- Document deduplication systems

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Generate N‑grams | O(n) |
| Insert N‑grams | O(n) |
| Similarity Check | O(n) |