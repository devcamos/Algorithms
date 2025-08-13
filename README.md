Repo for managing algorithms/data structure knowledge. Highlighting the key algorithms and data structures and the patterns key to manage them.

In computer science there is a tradeoff between space and time. 

What is a tradeoff? 

A trade-off, when explained to a 5-year-old, can be imagined as a situation where you have to choose between two things. For example, let's say you have a toy car and a toy truck. You want to play with both, but you only have one toy box.
In this case, you might have to decide whether to put the toy car in the toy box or the toy truck. You can't fit both in the same box. This is a trade-off. You have to give up one thing to get the other.
In computer science, trade-offs between space and time are like choosing between having more room (space) or being faster (time). For example, sorting algorithms like QuickSort and MergeSort have different trade-offs. QuickSort is faster but uses more space, while MergeSort is slower but uses less space.

Todo

Add sorting_basics section

Add searching_basics section 

Project build tools 

What is a build tool?


Key maven build project dependencies


- Maven dependencies 
    - Junit - Code testing 
    - Lombok - simplification/generating boilerplate code. 
    - Maven
      - spotless - maintain consistent code formatting across your project.
- Add gradle 


Key resources 

What is Big 0?

Big O notation is a way to express how an algorithm's performance scales with the size of the input. It gives us an idea of how the algorithm will perform in different scenarios, such as when the input size is very small, medium, or large.
- Big O notation cheatsheet - https://www.bigocheatsheet.com/ 


Java implementations for common Algorithms 

-- Variant of Merge sort named Tim sort 
Arrays.sort()

## Automated Code Formatting with Git Hooks

This project uses a Git pre-commit hook to automatically format code using Spotless before each commit. This ensures consistent code style and prevents commits with formatting issues.

### Setup Instructions

1. Ensure you have Maven installed.
2. The pre-commit hook is located at `.git/hooks/pre-commit`. If not present, copy the following script into that file and make it executable:
   ```sh
   #!/bin/sh
   mvn spotless:apply
   if [ $? -ne 0 ]; then
     echo "Spotless formatting failed. Commit aborted."
     exit 1
   fi
   ```
3. Make the hook executable:
   ```sh
   chmod +x .git/hooks/pre-commit
   ```
4. Now, every commit will automatically format your code. If formatting fails, the commit will be aborted.

## Security Checks

This project uses automated security checks to help identify vulnerabilities and code issues:

### OWASP Dependency-Check
- Scans your Maven dependencies for known security vulnerabilities (CVEs).
- To run: `mvn dependency-check:check`
- Results are shown in the terminal and a report is generated in `target/dependency-check-report.html`.

### SpotBugs (with Find Security Bugs)
- Performs static analysis to detect security issues and bugs in your Java code.
- To run: `mvn spotbugs:check`
- Results are shown in the terminal and a report is generated in `target/spotbugs.xml` and `target/site/spotbugs.html`.

These checks are integrated into your Maven build and can be run manually or as part of your CI pipeline.

### Running All Checks and Building

To run code formatting, security checks, and build your project in one command, use:

```sh
mvn clean package spotless:apply dependency-check:check spotbugs:check
```

This will:
- Clean and build your project
- Format code with Spotless
- Scan dependencies for vulnerabilities (OWASP Dependency-Check)
- Run static code analysis (SpotBugs)

If you want these checks to run automatically with every build (e.g., on PRs), configure your CI pipeline to use this command.

### Troubleshooting OWASP Dependency-Check Errors

If you encounter errors related to CPE parsing or NVD data issues (e.g., whitespace in CPE strings), try the following steps:

1. Purge the local Dependency-Check database:
   ```sh
   mvn dependency-check:purge
   ```
2. Update the database with the correct goal:
   ```sh
   mvn dependency-check:update-only
   ```
3. Re-run the check:
   ```sh
   mvn dependency-check:check
   ```

If the error persists, it may be due to issues in the NVD feed. These are usually resolved by the OWASP team in future updates. You can check for updates or wait for a fix.

> **Note:** NVD data issues may cause scan failures. If you see errors about CPE parsing, check for updates or try again later.
