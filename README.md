## BookMyShow - Spring Boot Demo

This project is a simplified **BookMyShow-style movie ticket booking system** built with **Spring Boot**, **Spring Data JPA**, and **MySQL**. It demonstrates a basic domain model (regions, theatres, screens, seats, shows, users, bookings) and exposes REST APIs for **user registration** and **ticket booking**.

### Tech Stack
- **Language**: Java 21
- **Framework**: Spring Boot 3.5.x
- **Persistence**: Spring Data JPA, Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **Other**: Lombok, Spring Boot Actuator

### Project Structure (high level)
- `BookmyshowApplication` – Spring Boot bootstrap class.
- `model` – JPA entities such as `Region`, `Theatre`, `Screen`, `Seat`, `Show`, `ShowSeat`, `Booking`, `Movie`, `User`, etc.
- `repository` – Spring Data repositories for entities (e.g. `UserRepository`, `BookingRepository`, `ShowSeatRepository`, `MovieRepository`).
- `services` – Business logic layer:
  - `UserService` – register and fetch users.
  - `BookingService` – transactional seat blocking and booking creation.
- `controllers` – REST controllers:
  - `UserController` – user registration and retrieval.
  - `TicketController` – ticket booking and a simple test endpoint.
- `src/main/resources/application.properties` – database and JPA configuration.
- `src/main/resources/data.sql` – schema bootstrapping and sample data.

### Prerequisites
- Java 21 installed and on your `PATH`
- Maven 3.9+ installed (or use the included `mvnw` / `mvnw.cmd`)
- MySQL server running locally

### Database Setup
1. Create a database named `bookmyshow` in MySQL:

```sql
CREATE DATABASE bookmyshow;
```

2. Update credentials in `src/main/resources/application.properties` if needed:
   - `spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow`
   - `spring.datasource.username=...`
   - `spring.datasource.password=...`

3. On application startup:
   - Hibernate will run with `spring.jpa.hibernate.ddl-auto=update`.
   - `data.sql` will reset and seed the core domain tables (`region`, `theatre`, `screen`, `seat`, `screen_seats`, `movies`, `movie_show`, `show_seat`) with sample data so you can book tickets immediately.

### Building and Running
From the project root:

```bash
# Using local Maven
mvn clean install

# Or using the Maven wrapper (recommended)
./mvnw clean install
```

Then run the Spring Boot application:

```bash
mvn spring-boot:run
# or
./mvnw spring-boot:run
```

By default the app will start on **port 8080**.

### REST API Overview

#### 1. Register a User
- **URL**: `POST /user/register`
- **Request Body** (`RegisterUserRequestDto`):

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "secret"
}
```

- **Response** (`RegisterUserResponseDto`):

```json
{
  "id": 1
}
```

#### 2. Get User by ID
- **URL**: `GET /user/{userId}`
- **Path Variable**: `userId` – numeric user identifier
- **Response**: `User` entity JSON (id, name, email, etc.), or HTTP 404 via `NoUserFound` if not found.

#### 3. Book Ticket
- **URL**: `POST /ticket/book`
- **Request Body** (`BookTicketRequestDto`):

```json
{
  "showSeatIds": [1, 2, 3]
}
```

- **Behavior**:
  - Wrapped in a **SERIALIZABLE** transaction.
  - Loads all requested `ShowSeat` records.
  - Validates that all seats exist and are `AVAILABLE`.
  - Marks them as `BLOCKED` and persists.
  - Creates a `Booking` linked to the `Show` and the chosen seats.

- **Response** (`BookTicketResponseDto`):

```json
{
  "bookingId": 1,
  "amount": 12.0,
  "theatreName": "PVR",
  "seatNumbers": [1, 2, 3]
}
```

If any seat is not available or an ID is invalid, the service throws `BadRequestException` and returns HTTP 400 (depending on your global exception handling).

#### 4. Test Ticket Endpoint
- **URL**: `GET /ticket/get`
- **Response**: Simple string confirming the endpoint is reachable.

### Running Tests

```bash
mvn test
# or
./mvnw test
```

This runs the standard Spring Boot test suite (see `BookmyshowApplicationTests`).

### Notes & Next Steps
- Sensitive values (like DB password) should ideally be moved out of `application.properties` into environment variables or a config server for non-local environments.
- You can extend this project by adding:
  - Authentication/authorization for users.
  - Show search APIs by movie, region, or time.
  - Pricing logic instead of the current hardcoded booking amount.

