# Todo App: Demonstrating Ports & Adapter (Hexagonal) Architecture in Java

This repository showcases a simple Todo application implemented using the **Ports & Adapter (Hexagonal) Architecture** in Java. The project emphasizes a clean separation between the core business logic and external components, promoting maintainability and flexibility.

## Table of Contents

- [Introduction](#introduction)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **Ports & Adapter Architecture**, also known as **Hexagonal Architecture**, is an architectural pattern that aims to decouple the core business logic from external systems like databases, user interfaces, or third-party services. This approach enhances testability, scalability, and adaptability to change.

## Architecture Overview

In this application:

- **Domain Layer**: Contains the core business logic related to managing todo items.
- **Application Layer**: Defines interfaces (ports) that the domain uses to communicate with external systems.
- **Infrastructure Layer**: Implements the interfaces (adapters) to interact with external systems such as databases or web frameworks.

This structure ensures that the core business logic remains independent and can be tested in isolation.

## Project Structure

The project is organized as follows:

```
arch-java-ports-adapter/
├── domain/
│   └── ... (Entities and business logic)
├── application/
│   └── ... (Ports and services)
├── infrastructure/
│   ├── persistence/
│   │   └── ... (Database adapters)
│   └── web/
│       └── ... (REST controllers)
└── ...
```

- **domain**: Contains the `Todo` entity and business rules.
- **application**: Defines ports such as `TodoRepository` and services that use these ports.
- **infrastructure**: Implements the ports, including persistence mechanisms and web controllers.

## Getting Started

### Prerequisites

- **Java 11** or higher
- **Gradle 7.0** or higher

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/OsaiaConsulting/arch-java-ports-adapter.git
   cd arch-java-ports-adapter
   ```

2. **Build the project**:

   ```bash
   ./gradlew build
   ```

### Running the Application

1. **Start the application**:

   ```bash
   ./gradlew bootRun
   ```

   The application will start and be accessible at `http://localhost:8080`.

## Usage

The application provides a RESTful API to manage todo items. You can interact with the API using tools like `curl` or Postman.

- **Create a new todo item**:

  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"title": "Sample Todo", "description": "This is a sample todo item."}' http://localhost:8080/todos
  ```

- **Retrieve all todo items**:

  ```bash
  curl http://localhost:8080/todos
  ```

- **Update a todo item**:

  ```bash
  curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Todo", "description": "This is an updated todo item."}' http://localhost:8080/todos/{id}
  ```

- **Delete a todo item**:

  ```bash
  curl -X DELETE http://localhost:8080/todos/{id}
  ```

Replace `{id}` with the actual ID of the todo item.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
