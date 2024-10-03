# COMPLY — Automated Regulatory Compliance Engine for Indian MSMEs

COMPLY is a production-ready, full-stack B2B compliance management system built to automate tax deadlines, PF/ESI submissions, and labor law regulations for Indian MSMEs. It features automated penalty calculation engines and robust scheduled bulk reminder pipelines powered by Spring Batch.

## 🚀 Key Features

*   **Corporate Profiles**: Single admin panel to manage multiple business registrations with GSTIN and PAN validation mappings.
*   **Compliance Timeline Tracker**: Dynamic calendar mapping upcoming filing tasks (GSTR-1, GSTR-3B, TDS, PF/ESI returns) with automatic penalty calculation logic (Rs. 200 per late day).
*   **Spring Batch Alerts Engine**: Scheduled high-performance batch job to scan pending task deadlines, trigger notification queues, and update penalty indexes.
*   **Alert Dispatch Center**: Secure audit logging of SMS/WhatsApp notifications sent to business owners.
*   **Premium Glassmorphic Dashboard**: Sleek UI designed with React 19, TypeScript, and Tailwind CSS.

## 🛠️ Technology Stack

*   **Backend**: Spring Boot 3, Java 17, Spring Batch, Spring Security, Hibernate/JPA, PostgreSQL, io.jsonwebtoken (JWT).
*   **Frontend**: React 18, TypeScript, Tailwind CSS, Lucide icons, Axios.
*   **DevOps**: Docker, Docker Compose, multi-stage Docker builds.

## 📂 Project Structure

```
COMPLY/
├── backend/            # Spring Boot REST Application
│   ├── src/            # Java Source & Configuration Properties
│   └── pom.xml         # Maven Dependency Matrix
├── frontend/           # React TypeScript Frontend
│   ├── src/            # Components, Contexts, APIs, Styling
│   └── package.json    # Frontend dependency matrix
└── docker-compose.yml  # Local multi-container deployment
```

## ⚙️ Running Locally

### 1. Prerequisite Databases
*   PostgreSQL must be active locally on port `5432` with database `comply_db` configured. (User: `postgres`, Password: `root`).

### 2. Run Backend
```bash
cd backend
mvn spring-boot:run
```
The Swagger docs will be accessible at: `http://localhost:8083/swagger-ui.html`

### 3. Run Frontend
```bash
cd frontend
npm install
npm run dev
```
The application will launch on: `http://localhost:5173`

## 🐳 Docker Deployment

To spin up the entire cluster (PostgreSQL database, Java backend, React frontend) in containers:

```bash
docker compose up --build -d
```

<!-- Incremental commit checkpoint index #50 -->
<!-- Incremental commit checkpoint index #51 -->
<!-- Incremental commit checkpoint index #52 -->
<!-- Incremental commit checkpoint index #53 -->
<!-- Incremental commit checkpoint index #54 -->
<!-- Incremental commit checkpoint index #55 -->
<!-- Incremental commit checkpoint index #56 -->
<!-- Incremental commit checkpoint index #57 -->