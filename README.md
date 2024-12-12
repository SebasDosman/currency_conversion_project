# Currency Conversion Project

This repository contains a Java-based currency conversion application that leverages Spring Context for configuration management and integrates with an external API to fetch real-time exchange rates. The application provides a user-friendly interface for displaying conversion data and demonstrates clean architecture principles, external service integration, and dependency injection with Spring.

## Features

- **Real-Time Exchange Rates**: Fetches live data from the [ExchangeRate-API](https://www.exchangerate-api.com/).
- **User-Friendly Interface**: Built using Java Swing for simple and intuitive interaction.
- **Configuration Management**: Utilizes Spring Context to manage properties and dependencies.
- **Clean Architecture**: Separation of concerns with service layers and interface-based design.

## Prerequisites

- **Java 21**: Ensure Java 21 is installed and configured.
- **Maven**: Make sure Maven is installed for dependency management and project build.

## Dependencies

The project uses the following dependencies:

- [Spring Context](https://spring.io/): For configuration management.
- [Lombok](https://projectlombok.org/): To reduce boilerplate code.
- [Gson](https://github.com/google/gson): For JSON parsing.

These dependencies are defined in the `pom.xml` file.

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/SebasDosman/currency_conversion_project.git
cd currency_conversion_project
```

### Configure the API Key

1. Create an `application.properties` file in the `src/main/resources` directory.
2. Add the following property:

   ```properties
   application.api-key=<API_KEY>
   ```

   Replace `<API_KEY>` with your actual API key from [ExchangeRate-API](https://www.exchangerate-api.com/).

### Build and Run the Project

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="co.com.alura.challenge.Main"
```

### Usage

The application launches a menu interface where you can view exchange rate data. Simply follow the on-screen prompts to interact with the application.

## Project Structure

- `co.com.alura.challenge.config`: Contains the Spring configuration class.
- `co.com.alura.challenge.models`: Contains the model classes for the application.
- `co.com.alura.challenge.services`: Contains the service interface and its implementation for API consumption.
- `co.com.alura.challenge.utils`: Contains utility classes such as the menu system.
- `co.com.alura.challenge.Main`: Entry point of the application.

## License

This project is licensed under the [MIT License](LICENSE).

## Contributions

Contributions are welcome! Feel free to open issues or submit pull requests to improve the project.
