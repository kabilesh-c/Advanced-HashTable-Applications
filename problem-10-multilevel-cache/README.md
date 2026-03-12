# Problem 10 — Multi-Level Cache System (Netflix Style)

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

Large video streaming platforms such as Netflix serve **millions of users simultaneously**.

To achieve high performance, they use **multi-level caching systems**.

---

## Cache Architecture
User Request
│
▼
L1 Cache (Memory)
│
▼
L2 Cache (SSD)
│
▼
L3 Database


---

## System Goals

- Fast video retrieval
- Reduce database load
- Promote frequently accessed videos to faster cache levels
- Use **LRU eviction policy**

---

## Cache Levels

### L1 Cache

- Fastest
- Limited size
- Uses LRU eviction

### L2 Cache

- Medium speed
- Larger capacity

### L3 Database

- Slowest
- Stores all videos

---

## Example
getVideo("video_123")

L1 MISS
L2 HIT
Promoted to L1


Next request:
getVideo("video_123")

L1 HIT


---

## Real World Systems

- Netflix CDN
- YouTube caching
- CDN edge servers
- Database query caches

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Cache Lookup | O(1) |
| Cache Insert | O(1) |
| LRU Eviction | O(1) |
