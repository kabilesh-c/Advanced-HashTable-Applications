# Problem 2 — E-commerce Flash Sale Inventory Manager

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

During a flash sale, thousands of customers try to purchase a product simultaneously.

Example:

50,000 users trying to buy  
100 units of stock.

The system must ensure:

- No overselling
- High performance
- Instant stock checks

---

## Problem Statement

Build a system that:

- Tracks product inventory in real time
- Handles concurrent purchase requests
- Prevents overselling
- Maintains a waiting list when stock runs out
- Provides O(1) stock lookup

---

## System Design
User Request
│
▼
FlashSaleInventoryManager
│
├── HashMap<ProductId, StockCount>
│
└── HashMap<ProductId, WaitingQueue>


---

## Key Concepts

### HashMap

Used for instant stock lookup.
HashMap<String, Integer>
productId → stockCount


Time Complexity:
Lookup: O(1)
Update: O(1)


---

### Thread Safety

Purchase operation is synchronized to prevent race conditions.
public synchronized purchaseItem()


This ensures:

- Only one thread updates stock at a time
- No overselling occurs

---

### Waiting List

When stock becomes zero:

Users are placed in a queue.
Queue<Integer>
userId


FIFO order ensures fairness.

---

## Example Output
Stock Available: 3

SUCCESS: User 101 purchased IPHONE15_256GB
Remaining stock: 2

SUCCESS: User 102 purchased IPHONE15_256GB
Remaining stock: 1

SUCCESS: User 103 purchased IPHONE15_256GB
Remaining stock: 0

OUT OF STOCK: User 104 added to waiting list #1
OUT OF STOCK: User 105 added to waiting list #2


---

## Real World Use Cases

- Amazon Prime Day
- Flipkart Big Billion Days
- Concert ticket booking
- Limited edition product sales

---

## Complexity Analysis

| Operation | Time Complexity |
|--------|--------|
| Check Stock | O(1) |
| Purchase Item | O(1) |
| Add to Waiting List | O(1) |

---

## Technologies

- Java
- HashMap
- Queue
- LinkedList
- Thread Synchronization