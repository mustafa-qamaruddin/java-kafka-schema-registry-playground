# Confluent Kafka Schema Prototype Project

Welcome to the Confluent Kafka Schema Prototype Project! This project demonstrates the use of Apache Kafka and Confluent Schema Registry for producing and consuming Avro messages. The project is organized as a Gradle multi-module project with three submodules: producer, consumer, and schema-manager.

## Overview

- **Producer**: This submodule is responsible for producing Avro messages and sending them to a Kafka broker. It uses Avro schemas for data serialization and Confluent Schema Registry for schema management.

- **Consumer**: The consumer submodule subscribes to the Kafka topic and consumes Avro messages. It deserializes the messages using the Avro schema and processes them.

- **Schema Manager**: The schema-manager submodule is used for managing Avro schemas. It includes schema definition files and tools for registering and evolving schemas in the Confluent Schema Registry.

## Prerequisites

Before you begin, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or higher
- Gradle
- Apache Kafka
- Confluent Schema Registry

## Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/mustafa-qamaruddin/java-kafka-schema-registry-playground.git
   ```

2. Build the project:

   ```shell
   cd confluent-kafka-schema-prototype
   gradle build
   ```

3. Start the Kafka broker and Confluent Schema Registry if not already running.

4. Configure the producer and consumer modules with the necessary Kafka broker and Schema Registry settings in their respective configuration files.

5. Start the producer and consumer:

   ```shell
   cd producer
   gradle run
   ```

   ```shell
   cd consumer
   gradle run
   ```

6. Watch as the producer sends messages to the Kafka topic, and the consumer consumes and processes them.
