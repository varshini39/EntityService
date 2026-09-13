# EntityService

Shared domain-model library for the [Flight Booking microservices](https://github.com/varshini39/flightbooking). It holds the JPA entities and password-hashing utility that [UserService](https://github.com/varshini39/UserService), [FlightService](https://github.com/varshini39/FlightService), and [BookingService](https://github.com/varshini39/BookingService) all depend on, so the domain model is defined once and stays consistent across services.

> This is a library, not a runnable service — it has no REST endpoints and doesn't get deployed on its own.

## What's in it

- **`User`** — `user_id`, `first_name`, `last_name`, `age`, `gender`, `phone_number`, `email_id`, `password`
- **`Flight`** — `flight_id`, `airline_name`, `from`, `to`, `start_time`, `end_time`, `rate`, `total_seats`, `available_seats`
- **`Booking`** — `pnr_number`, `userId`, `flightId`, `booking_date`, `seats`, `meal_required`, `booking_status` (plus transient `user`/`flight` fields, populated by BookingService when it enriches a booking with data from the other services)
- **`BCryptPasswordDeserializer`** — a Jackson deserializer wired onto `User.password` so any incoming password is BCrypt-hashed before it's ever assigned to the entity; the field is write-only (`@JsonProperty(access = WRITE_ONLY)`), so hashes are never serialized back out in responses.

## How it's consumed

`UserService`, `FlightService`, and `BookingService` each declare it as a Maven dependency:

```xml
<dependency>
    <groupId>com.app.project</groupId>
    <artifactId>entity-service</artifactId>
</dependency>
```

To build and use a local change:

```bash
mvn clean install
```

then rebuild the dependent service so it picks up the new jar from your local `~/.m2` repository.

## Part of

[flightbooking](https://github.com/varshini39/flightbooking) (project overview) · [UserService](https://github.com/varshini39/UserService) · [FlightService](https://github.com/varshini39/FlightService) · [BookingService](https://github.com/varshini39/BookingService)
