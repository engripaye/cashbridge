# CashBridge 💳

**A Cash App–style digital wallet redesigned for Nigeria & high-risk regions**

> Secure peer-to-peer payments with real-time fraud detection, identity trust scoring, and escrow-based transactions — built with Spring Boot and modern backend architecture.

---

## 🚀 Overview

CashBridge is a **digital wallet and payment platform** inspired by Cash App, but purpose-built for **Nigeria and other high-risk regions** where traditional P2P payment systems struggle due to fraud, weak identity verification, and chargeback abuse.

Instead of ignoring these challenges, CashBridge **solves them at the system level** using layered identity verification, real-time risk scoring, escrow payments, and ledger-based wallet architecture.

This project focuses on **backend engineering, security design, and product thinking**, not just UI.

---

## 🎯 Problem Statement

Many global payment platforms restrict users from high-risk regions because of:

* High fraud rates
* Weak or inconsistent identity verification
* Chargeback abuse
* Device spoofing & VPN usage
* Poor transaction traceability

**CashBridge addresses these issues directly**, demonstrating how a modern fintech system can be safely deployed in such environments.

---

## ✨ Key Differentiators

### 🔐 Multi-Layer Identity Verification (KY-NG)

Beyond basic KYC, CashBridge introduces **layered trust verification** tailored for Nigeria.

**Includes:**

* BVN verification (mocked API)
* NIN verification (mocked API)
* Phone number ownership validation
* Face match simulation (image hash comparison)
* Device fingerprinting

> Demonstrates real-world banking security logic, not simple CRUD authentication.

---

### 🧠 Dynamic Fraud Risk Engine

Every transaction is evaluated **in real time** using a weighted risk-scoring model.

**Risk signals include:**

* New or untrusted device
* VPN or proxy detection
* Unusual transaction amount
* Rapid transfer patterns
* Geo-location anomalies
* Receiver reputation

**Risk-based actions:**

* ✅ Low risk → instant transfer
* ⚠ Medium risk → OTP + delayed processing
* 🚫 High risk → blocked and flagged for manual review

This system mirrors how real fintech fraud engines operate.

---

### 🧾 Escrow-Based Transactions

CashBridge introduces **built-in escrow payments**, a feature not available in Cash App.

**Flow:**

1. Sender initiates payment
2. Funds are held in escrow
3. Receiver confirms service or delivery
4. Funds are released automatically
5. Timeout triggers auto-refund

**Ideal for:**

* Freelancers
* Online vendors
* P2P trades

---

### 🏦 Anti-Chargeback Wallet Architecture

Instead of direct bank pulls:

* Users fund an internal wallet
* All transfers are **wallet-to-wallet**
* No instant reversal abuse
* Immutable transaction records

This approach is inspired by **ledger-based accounting systems** used in real banks.

---

### 📱 Device & Session Trust System

Each device is assigned a **trust score** based on usage behavior.

**Tracked attributes:**

* Device ID
* IP address
* OS & browser
* Trust score
* Last seen timestamp

Trust increases with clean usage and decreases with suspicious activity.

---

### 🤝 Social Trust Graph

Users build reputation over time.

* Successful transactions → trust increases
* Fraud reports → trust decreases

**High-trust users receive:**

* Higher transaction limits
* Faster processing
* Fewer verification steps

This introduces **social trust modeling without blockchain complexity**.

---

### 🌐 Offline-Friendly Payment Tokens

To handle unreliable connectivity:

* Short-lived payment tokens can be generated
* Designed for poor internet conditions
* USSD-style flow planned as a future extension

---

## 🏗️ System Architecture

### Backend (Spring Boot – Java 21)

```
cashbridge-backend/
├── auth-service
├── user-service
├── wallet-service
├── transaction-service
├── fraud-engine
├── escrow-service
├── notification-service
└── audit-log-service
```

### Core Technologies

* Java 21
* Spring Boot 3.5
* Spring Security + JWT
* OAuth2 (future-ready)
* PostgreSQL / MySQL
* Redis (sessions & risk scoring)
* Kafka (optional – async fraud events)

---

## 🎨 Frontend

Built with **HTML, CSS, and vanilla JavaScript**, focusing on clarity and usability.

### Pages

* `signup.html` – BVN & NIN simulation
* `login.html`
* `dashboard.html`
* `send-money.html`
* `escrow-payment.html`
* `risk-alert.html`
* `admin-fraud-dashboard.html`

---

## 🧪 Sample Fraud Engine Logic

```java
public RiskLevel evaluate(Transaction tx, User user) {
    int score = 0;

    if (tx.isNewDevice()) score += 30;
    if (tx.isLargeAmount()) score += 25;
    if (user.isNewAccount()) score += 20;
    if (tx.isLocationAnomaly()) score += 25;

    if (score > 70) return RiskLevel.HIGH;
    if (score > 40) return RiskLevel.MEDIUM;
    return RiskLevel.LOW;
}
```

---

## 📈 What This Project Demonstrates

* ✔ Real-world fintech problem solving
* ✔ Secure backend system design
* ✔ Fraud detection & risk modeling
* ✔ Escrow and ledger-based accounting
* ✔ Scalable Spring Boot architecture
* ✔ Strong product engineering mindset

This goes far beyond a typical “banking app” project.

---

## 🛣️ Roadmap

* [ ] Full database schema design
* [ ] Auth & Wallet services
* [ ] Fraud engine expansion
* [ ] Admin fraud monitoring dashboard
* [ ] Notification service (email/SMS simulation)
* [ ] USSD-style offline payments

---

## 📄 Project Summary (For Recruiters)
