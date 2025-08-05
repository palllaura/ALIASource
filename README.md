# ALIAS🔍urce
ALIASource is a minimal Spring Boot application for managing secret contact records with codenames, built with a RESTful API and PostgreSQL backend.

## Features

* View a table of all contacts
* Add a new contact
* Edit an existing contact
* Delete a contact
* Load initial data from an SQL file
* Backend built with Java + Spring Boot
* Frontend built with Angular + TypeScript
* Uses PostgreSQL as the database

## Prerequisites
* Java 17+
* Angular 17+
* A package manager like Gradle
* A code editor like IntelliJ IDEA
* Docker (for running PostgreSQL)

## Installation

### Database (PostgreSQL via Docker)
1. Run the container:
      ```bash
   docker run -d \
     --name postgres-db \
     -e POSTGRES_USER=postgres \
     -e POSTGRES_PASSWORD=postgres \
     -e POSTGRES_DB=aliasource \
     -p 5432:5432 \
     postgres:15
2. Confirm the container is running:
      ```bash
   docker ps

### Backend (Spring Boot)
1. Clone the repository:
   ```bash
   git clone https://github.com/palllaura/aliasource.git
   cd aliasource

2. Open the project in your IDE.

3. Build and run the backend:
   ```bash
   ./gradlew bootRun
4. The backend server will start at:
   http://localhost:8080

### Frontend (Angular)
1. Navigate to the frontend folder:
   ```bash
   cd frontend
2. Install dependencies:
   ```bash
   npm install
3. Start the development server:
   ```bash
   ng serve
4. The frontend will be available at:
   http://localhost:4200/

<img width="918" height="564" alt="Screenshot 2025-08-05 at 18 01 34" src="https://github.com/user-attachments/assets/c1912920-d35d-4d8a-9ec8-c23416d06f53" />

<img width="913" height="563" alt="Screenshot 2025-08-05 at 18 03 39" src="https://github.com/user-attachments/assets/cf0ab7db-4a60-4369-849b-8ab4f6d8665d" />


