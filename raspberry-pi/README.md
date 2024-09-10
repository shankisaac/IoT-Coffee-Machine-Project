# Raspberry Pi Coffee Machine Control

## Overview
This directory contains the Java code for controlling the coffee machine using a Raspberry Pi and a relay module.

## Files
- **`CoffeeMachineScheduler.java`**: Main class that fetches the coffee machine schedule from the Spring Boot API and controls the relay.
- **`RelayControl.java`**: Contains the logic to control the GPIO pin connected to the relay module.

## Setup
1. **Install Java** on Raspberry Pi:
   ```bash
   sudo apt update
   sudo apt install default-jdk

