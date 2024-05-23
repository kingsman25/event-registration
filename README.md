Event Registration System

Setup

1. Install PostgreSQL and create a database named `eventdb`.
2. Update `application.properties` with your PostgreSQL username and password.
3. Run the SQL scripts to create tables.
4. Build and run the Spring Boot application:

User Registration
To register a new user, use the /register endpoint.
Authentication
Login using /login endpoint with username and password.
APIs
1.GET /api/events - Get all events
2.GET /api/events/{id} - Get event by ID
3.POST /api/events - Create a new event
4.PUT /api/events/{id} - Update an event
5.DELETE /api/events/{id} - Delete an event
