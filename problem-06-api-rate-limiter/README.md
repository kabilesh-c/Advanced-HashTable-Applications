# Problem 6 — Distributed API Rate Limiter

Author: Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

An API gateway serves **100,000 clients**.

Each client is allowed:
1000 requests per hour


The system must enforce this limit **efficiently and in real time**.

---

## Problem Statement

Build a rate limiter that:

- Tracks request counts per client
- Allows burst traffic
- Automatically refills tokens over time
- Responds within 1ms
- Supports distributed API gateways

---

## System Design
Client Request
│
▼
API Gateway
│
▼
APIRateLimiter
│
└── HashMap<ClientId, TokenBucket>


---

## Token Bucket Algorithm

Each client has a **bucket of tokens**.
TokenBucket
tokens
maxTokens
refillRate


When a request arrives:
if tokens > 0
allow request
tokens--
else
deny request


---

## Example
checkRateLimit(clientId="abc123")

Allowed (999 remaining)

checkRateLimit(clientId="abc123")

Allowed (998 remaining)


If limit exceeded:
Denied: Rate limit exceeded


---

## Real World Systems

- AWS API Gateway
- GitHub API
- Stripe API
- Twitter API

---

## Complexity

| Operation | Complexity |
|--------|--------|
| Rate Limit Check | O(1) |
| Token Refill | O(1) |
| Client Lookup | O(1) |    