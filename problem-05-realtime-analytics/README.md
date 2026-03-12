# Problem 5 — Real-Time Analytics Dashboard

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

A news website receives **1 million page views per hour**.

The marketing team needs **real-time analytics** showing:

- Most visited pages
- Unique visitors
- Traffic sources
- Popular content

---

## Problem Statement

Build a streaming analytics system that:

- Processes page view events in real time
- Maintains top visited pages
- Tracks unique visitors per page
- Tracks traffic sources
- Updates dashboard every few seconds

---

## System Design
Page View Event
│
▼
RealTimeAnalyticsDashboard
│
├── HashMap<PageUrl, ViewCount>
│
├── HashMap<PageUrl, Set<UserId>>
│
└── HashMap<TrafficSource, Count>


---

## Key Concepts

### Frequency Counting
HashMap<String, Integer>
pageUrl → visitCount


---

### Unique Visitor Tracking
HashMap<String, Set<String>>
pageUrl → uniqueUsers


---

### Traffic Source Analysis
HashMap<String, Integer>
source → visitCount


Sources may include:

- Google
- Facebook
- Direct
- Twitter
- Email

---

## Example Output
Top Pages:

/article/breaking-news - 15423 views (8234 unique)

/sports/championship - 12091 views (9871 unique)

Traffic Sources:

Google: 45%
Direct: 30%
Facebook: 15%
Other: 10%


---

## Real World Systems

- Google Analytics
- Twitter trending topics
- YouTube video popularity tracking
- E-commerce product analytics

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Process Event | O(1) |
| Update Counts | O(1) |
| Top Pages Sort | O(n log n) |