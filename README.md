# browserstack-ai-selfheal

This project demonstrates automated UI testing using Selenium WebDriver and TestNG, with a focus on self-healing test capabilities.

## Features

- Automated browser testing using Selenium WebDriver
- TestNG-based test structure
- Example of self-healing element location

## Prerequisites

- Java 8 or above
- Maven
- Selenium WebDriver dependencies
- TestNG

## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/browserstack-ai-selfheal.git
   cd browserstack-ai-selfheal
   ```

2. Install dependencies:
   ```sh
   mvn clean install
   ```

## Running Tests

To execute the tests, first run:
```sh
mvn test
```
Then run:
```sh
mvn -P healed test
```

## Project Structure

- `src/test/java/org/browserstack/selfheal/SetupTest.java`: Main test class.
- `logs/`: Log files.
- `target/`: Build output and reports.

## License

This project is open-source and free to use under the MIT License.# browserstack-ai-selfheal
