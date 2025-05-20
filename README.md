A simple Expense Tracker built in Java using the com.fasterxml.jackson.databind library to manage JSON input/output.

✨ Features
Add income and expense records.

Automatically saves entries to a local JSON file.

View monthly breakdowns of income and expenses.

Supports file input through JSON (e.g. file_input.json in the resources folder).

🧰 Requirements
Java 8 or higher

Jackson Core & Databind libraries

If using Maven, add the following dependency:

xml
Copy
Edit

<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.15.2</version> <!-- or your preferred version -->
</dependency>
