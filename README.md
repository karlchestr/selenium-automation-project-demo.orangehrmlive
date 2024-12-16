## Test Automation Framework using Selenium and Java for OrangeHRM Open Source

  ![image](https://github.com/user-attachments/assets/b159afcf-07a9-4955-a31f-8afca6b6ebe0)

  A test automation framework built with Selenium and Java, implementing the Page Object Model (POM) design pattern. 
  This framework is designed for [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login), an open-source demo human resource management system.
  
  This automation framework handles **Employee Information Management**, including **adding, editing, and deleting employee records**. 
  It also supports **adding and removing Admin users**. Additionally, it includes tests for **login and logout functionalities**.

  ![image](https://github.com/user-attachments/assets/a49d2491-9fc5-4960-8df5-bd9f33f403c6)
  ![image](https://github.com/user-attachments/assets/28955411-7ddb-4222-b45c-8be7143b136d)
  
  > **Tech Stack used:** IntelliJ IDEA Community Edition, Selenium WebDriver 4.23.0, Java 21, TestNG 7.10.2 and GitHub
   
### Getting Started

  These instructions will give you a copy of the project up and running on
  your local machine for development and testing purposes. 

### Prerequisites

  Before running this project, ensure you have the following installed on your system:
  - Java JDK 8 or higher
  - A Chrome browser and its corresponding WebDriver


### Setup Instructions

  **How to clone the project**
  1. Clone the repository
  
      `git clone <repository-url>`
  3. Navigate to the project directory
  
      `cd <directory-name>`
  5. Build the project using Maven
  
      `mvn clean install`
  
  **How to execute the tests**
  1. Open the project in IntelliJ IDEA (or your preferred IDE).
  2. Locate the testng.xml configuration file in the project structure.
  3. Right-click on the testng.xml file and select Run to execute the tests.
  4. Alternatively, you can execute individual test cases by navigating to the respective test file, right-clicking on it, and selecting Run.
