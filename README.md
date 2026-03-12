Real-World Hash Table Systems in Java

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Overview

This repository contains **10 real-world system design problems implemented using Hash Tables and related data structures in Java**.

These implementations simulate how large-scale systems such as **Google, Amazon, Netflix, and modern backend platforms** use hash-based data structures to achieve **high performance and scalability**.

This project is part of my **Placement Training Program**, where I am practicing and implementing **industry-relevant backend system design problems** to strengthen my understanding of:

- Data Structures
- Hash Tables
- System Design Concepts
- Backend Engineering Patterns
- Performance Optimization

---

## Goals of This Repository

The goal of this project is to:

- Practice **real-world applications of Hash Tables**
- Understand **how large-scale systems manage data efficiently**
- Build a **strong GitHub portfolio for placements**
- Implement **production-like problem statements**

Each problem focuses on a **different real-world system** where hash tables are commonly used.

---

## Technologies Used

- **Java**
- **HashMap**
- **Trie Data Structure**
- **Custom Hash Tables**
- **LRU Caching**
- **System Design Concepts**

---

# Implemented Systems

## 1. Social Media Username Availability Checker

Simulates username validation during user registration.

Features:

- O(1) username lookup
- Username availability checking
- Alternative username suggestions
- Attempt frequency tracking

Real World Example:

- Twitter username selection
- Instagram handle creation

---

## 2. Flash Sale Inventory Manager

Handles high concurrency inventory during flash sales.

Features:

- Real-time stock tracking
- Thread-safe purchase processing
- Waiting list system
- O(1) stock lookup

Real World Example:

- Amazon Prime Day
- Limited edition product launches

---

## 3. DNS Cache with TTL

Simulates how DNS caching reduces network latency.

Features:

- Domain to IP caching
- TTL expiration
- Cache hit/miss tracking
- Automatic cleanup

Real World Example:

- Browser DNS caching
- CDN DNS resolution

---

## 4. Plagiarism Detection System

Detects document similarity using n-gram hashing.

Features:

- Document n-gram hashing
- Similarity scoring
- Matching document detection

Real World Example:

- Turnitin plagiarism detection
- Code similarity detection tools

---

## 5. Real-Time Website Analytics Dashboard

Processes high-volume website traffic analytics.

Features:

- Page visit tracking
- Unique visitor counting
- Traffic source analytics
- Top page ranking

Real World Example:

- Google Analytics
- Real-time marketing dashboards

---

## 6. Distributed API Rate Limiter

Controls request rates in API gateways.

Features:

- Token bucket algorithm
- Client request tracking
- Burst traffic handling
- Rate limit enforcement

Real World Example:

- AWS API Gateway
- GitHub API rate limits

---

## 7. Search Engine Autocomplete System

Implements a Google-style autocomplete engine.

Features:

- Trie-based prefix search
- Query frequency tracking
- Top suggestion ranking

Real World Example:

- Google search suggestions
- Amazon product search
- IDE auto-completion

---

## 8. Parking Lot Management System

Uses a custom hash table with open addressing.

Features:

- License plate hashing
- Linear probing collision resolution
- Entry/exit tracking
- Occupancy statistics

Real World Example:

- Smart parking systems
- Airport parking management

---

## 9. Financial Transaction Fraud Detection

Detects suspicious transaction patterns.

Features:

- Two-sum fraud detection
- Duplicate payment detection
- K-sum suspicious transaction groups

Real World Example:

- Banking fraud detection
- Payment gateway monitoring

---

## 10. Multi-Level Cache System

Simulates caching architecture used by streaming platforms.

Features:

- L1 / L2 / L3 cache hierarchy
- LRU eviction policy
- Cache promotion
- Cache performance tracking

Real World Example:

- Netflix CDN caching
- YouTube video caching

---

# Repository Structure
.
├── problem-01-username-availability-checker
├── problem-02-flash-sale-inventory
├── problem-03-dns-cache
├── problem-04-plagiarism-detector
├── problem-05-realtime-analytics
├── problem-06-api-rate-limiter
├── problem-07-autocomplete-system
├── problem-08-parking-lot-hash-table
├── problem-09-financial-transactions
└── problem-10-multilevel-cache


Each directory contains:

- Java implementation
- Documentation
- Example usage

---

## Learning Outcomes

Through this project I practiced:

- Efficient data storage using hash tables
- Designing scalable backend systems
- Handling real-world performance constraints
- Implementing industry-inspired algorithms

---

## Future Improvements

Possible future enhancements:

- Add unit tests
- Implement distributed caching
- Add concurrency simulations
- Add performance benchmarking

---

## Author

Kabilesh C  
Email: kabileshc.dev@gmail.com

This project is part of my **placement preparation and backend engineering practice**.
