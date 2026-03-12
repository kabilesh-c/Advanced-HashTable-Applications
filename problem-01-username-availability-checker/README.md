# Problem 1 — Social Media Username Availability Checker

## Author
Kabilesh C  
Email: kabileshc.dev@gmail.com

---

## Scenario

A social media platform with **10 million users** needs to check username availability in real time during registration.

Users frequently search for usernames before creating an account.

The system must handle **1000+ availability checks per second**.

---

## Problem Statement

Design a system that:

- Checks if a username already exists in **O(1) time**
- Suggests alternative usernames if the requested one is taken
- Tracks popularity of attempted usernames
- Handles high request volume efficiently

---

## Concepts Demonstrated

### HashMap

Used for **instant username lookup**
HashMap<String, Integer>
username → userId


Time Complexity:
Lookup: O(1)
Insertion: O(1)


---

### Frequency Counting

Tracks how many times each username was attempted.
HashMap<String, Integer>
username → attemptCount


This helps identify **popular usernames**.

Example:
admin → 10543 attempts
john → 8421 attempts


---

### Username Suggestions

When a username is taken, the system generates alternatives:

Example:
john_doe → john_doe1
john_doe → john_doe2
john_doe → john.doe
john_doe → john_doe_official


---

## System Architecture
User Request
│
▼
UsernameAvailabilitySystem
│
├── HashMap (registeredUsers)
│
└── HashMap (usernameAttempts)


---

## Example Execution
checkAvailability("john_doe") → false
checkAvailability("jane_smith") → true

suggestAlternatives("john_doe")
→ john_doe1
→ john_doe2
→ john.doe

getMostAttempted()
→ admin (10543 attempts)


---

## Real World Use Cases

- Twitter username selection
- Instagram registration
- Email address availability
- Gaming platform usernames

---

## Complexity Analysis

| Operation | Time Complexity |
|--------|--------|
| Check Username | O(1) |
| Register Username | O(1) |
| Suggest Alternatives | O(k) |
| Get Most Attempted | O(n) |

---

## Technologies Used

- Java
- HashMap
- ArrayList
- Object-Oriented Design