# US Visa Appointment Booking Automation Project

This project aims to automate the process of booking US visa appointments using Playwright and the Page Object Model (POM). The Page Object Model is a design pattern that helps in creating reusable and maintainable code for web UI testing.

## Features
- Automates the process of filling out the visa appointment form.
- Handles navigation between different pages of the application.
- Provides a clean and modular structure for writing automation scripts.

## Technologies Used
- **Playwright:** A Node.js library for automating browsers. Playwright provides a high-level API that allows interactions with web pages.
- **Page Object Model (POM):** A design pattern for creating an object-oriented model of web pages. Each page is represented as a class, and the interactions with the page are defined within the class.
- **Java:** The programming language used to write the automation scripts.

## Installation
1. Clone the repository: `git clone https://github.com/your/repository.git`
2. Set month and year window in which you want to search for dates
3. Run ReschduleTest.java

## Project Structure
```
- /src
  - /main
    - /Java
      - /Factory
        - PlayWrightFactory
      - /Factory
        - HomePage

    - ...
  - /tests
      - /Java
        - /Test
          - /RescheduleTest
    - ...
  - playwright.config.js
- README.md
- pom.xml
```

## Usage
1. Create a new instance of the `Playwright` class.
2. Navigate to the US visa appointment booking website.
3. Use the Page Object Model classes to interact with the pages and fill out the appointment form.
4. Run the automation script to book the appointment.

## Contributing
1. Fork the repository.
2. Create a new branch: `git checkout -b feature/new-feature`
3. Make your changes and commit them: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin feature/new-feature`
5. Submit a pull request.
---

Feel free to customize this README file according to your project's specific requirements and details.
