# Problem 3 — DNS Cache with TTL

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

DNS lookups normally take **100ms or more** because they query remote DNS servers.

A caching system can reduce lookup time to **less than 1ms**.

However cached entries must expire after a certain **TTL (Time To Live)**.

---

## Problem Statement

Build a DNS caching system that:

- Stores domain → IP mappings
- Uses TTL-based expiration
- Automatically refreshes expired entries
- Tracks cache hit/miss statistics
- Supports fast O(1) lookups

---

## System Design
User Request
│
▼
DNSCacheSystem
│
├── HashMap<Domain, DNSEntry>
│
└── Cache Statistics


---

## Key Concepts

### HashMap

Used for fast lookup.
HashMap<String, DNSEntry>


Time Complexity:
Lookup: O(1)
Insert: O(1)


---

### TTL (Time To Live)

Each cache entry contains:
timestamp
expiryTime


If:
currentTime > expiryTime


the entry is **invalid**.

---

### Cache Hit vs Miss
Cache HIT → return cached IP
Cache MISS → query upstream DNS


Statistics are tracked to measure performance.

---

## Example Output
Cache MISS for google.com
172.217.14.206

Cache HIT for google.com
172.217.14.206

Cache MISS for openai.com
104.18.12.123

(after TTL expires)

Cache MISS for google.com
172.217.14.207


---

## Real World Systems

- Browser DNS cache
- CDN edge servers
- Corporate DNS resolvers
- Operating system DNS caching

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Resolve Domain | O(1) |
| Cache Insert | O(1) |
| Expiry Check | O(1) |