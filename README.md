# Flowchart Management System

This is a simple **Flowchart Management System** that allows users to manage flowcharts, consisting of nodes and edges that form a directed graph. The system supports basic **CRUD** operations and provides additional features like validating graphs, fetching outgoing edges, and querying connected nodes.

## Features

### Basic CRUD Operations:
1. **Create Flowchart**: Create a new flowchart with a unique ID, nodes, and edges.
2. **Fetch Flowchart**: Retrieve details of a flowchart by its ID, including its nodes and edges.
3. **Update Flowchart**: Add or remove nodes and edges in an existing flowchart.
4. **Delete Flowchart**: Delete an existing flowchart by its ID.

### Good-to-Have Features:
1. **Validate the Graph**: Check if the flowchart is a valid directed graph.
2. **Fetch Outgoing Edges for a Node**: Get all outgoing edges from a specific node in a flowchart.
3. **Swagger Documentation**: Automatically generated API documentation for easy testing and exploration.

### Bonus Features:
1. **Query Connected Nodes**: Fetch all nodes connected (directly or indirectly) to a specific node in the flowchart.

## Technology Stack

- **Java 17**: The programming language used to build the system.
- **Spring Boot**: Framework for building REST APIs.
- **Swagger UI**: API documentation and testing.
- **JUnit 5**: Framework for unit testing.
- **Lombok**: Used to reduce boilerplate code.

## Getting Started

### Prerequisites

Before running this project, ensure you have the following installed:

- **Java 17** or later.
- **Maven** for managing dependencies.