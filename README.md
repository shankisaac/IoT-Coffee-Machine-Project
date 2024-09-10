# IoT-Coffee-Machine-Project

## Overview
This project shows how to use a Raspberry Pi, Java, Spring Boot, and RESTful services to control a coffee machine. The goal is to have the coffee start brewing automatically 10 minutes before waking up.

## Components
- **Java**: Used for the backend application running on the Raspberry Pi.
- **Spring Boot**: Provides a RESTful API for scheduling the coffee machine.
- **RESTful Services**: Facilitates communication between the backend and the Raspberry Pi.
- **Raspberry Pi**: Controls the coffee machine using a relay module.

## Setting Up the Spring Boot Application
1. **Generate a Spring Boot Project:**
   - Go to [Spring Initializr](https://start.spring.io/), select "Gradle" for the build tool and add "Spring    Web" as a dependency.

2. **Create REST API:**
   - Implement REST endpoints to set and get the coffee machine schedule.

3. **Run the Application:**
   - ./gradlew bootRun to start the application.

## Setting Up the Raspberry Pi
1. **Install Java:**
   - Update your Raspberry Pi: sudo apt update
   - Install Java: sudo apt install default-jdk

2. **Connect Relay Module:**
   - Set up the relay module to control the coffee machine.

3. **Java Application for Raspberry Pi:**
   - Create a Java file to fetch the coffee machine schedule and control the relay.

4. Compile and Run Code:
   - Compile with javac CoffeeMachineScheduler.java
   - Run with java CoffeeMachineScheduler

## How to Use
- **Spring Boot API**: Use the API endpoints to set and check the coffee machine’s schedule.
- **Raspberry Pi**: Ensure it runs the Java code to control the coffee machine based on the schedule.

## Project Structure
   spring-boot/: Contains the Spring Boot application files.
   - CoffeeMachineController.java: Handles the scheduling API.
   - build.gradle: Configures the Gradle build for the Spring Boot application.

   raspberry-pi/: Contains the Java application for the Raspberry Pi.
   - CoffeeMachineScheduler.java: Fetches the schedule from the API and controls the coffee machine.
