# Problem 9 — Financial Transaction Analysis (Two Sum Variants)

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

A payment processing company needs to detect suspicious financial transactions.

Millions of transactions occur daily, and the system must quickly detect patterns such as:

- Fraudulent transaction pairs
- Duplicate payments
- Suspicious transaction groups

---

## Problem Statement

Build a transaction analysis system that:

- Detects pairs of transactions that sum to a target value
- Identifies duplicate payments
- Finds groups of transactions that sum to a suspicious value
- Works efficiently on millions of transactions

---

## System Design
Transaction Stream
│
▼
Fraud Detection Engine
│
├── HashMap (Two Sum detection)
├── HashMap (Duplicate detection)
└── HashSet (K-Sum detection)


---

## Key Algorithms

### Two Sum

Uses complement lookup.
target = 500
300 → store
200 → complement = 300 → match found


Complexity:
O(n)


---

### Duplicate Detection

Uses HashMap grouping:
HashMap<(amount, merchant), transactions>


Example:
500-StoreA → [t1, t4]


---

### K Sum (3‑Sum)

Detects suspicious groups of transactions that together match a target value.

---

## Real World Systems

- Banking fraud detection
- Cryptocurrency monitoring
- Tax fraud detection
- Payment gateway analytics

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Two Sum | O(n) |
| Duplicate Detection | O(n) |
| Three Sum | O(n²) |