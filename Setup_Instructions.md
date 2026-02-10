# Setup Instructions

## 1. JDK Installation

- Operating System: Windows 11
- JDK Version: Java 25 LTS  
  Example `java -version` output:

  ```text
  java version "25" 2025-09-16 LTS
  Java(TM) SE Runtime Environment (build 25+37-LTS-3491)
  Java HotSpot(TM) 64-Bit Server VM (build 25+37-LTS-3491, mixed mode, sharing)
  ```

### Steps followed

1. Downloaded Java 25 LTS (JDK) from the official Oracle/Java website.
2. Run the installer and completed the default setup on Windows.
3. Configured the `PATH` environment variable so that `java` and `javac` are available in the terminal.
4. Verified installation using:

   ```text
   java -version
   javac -version
   ```

---

## 2. Hello World Program

To verify the JDK setup, a simple `Hello World` program was created and executed in IntelliJ IDEA.

### Source code

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Steps to run in IntelliJ IDEA

1. Opened IntelliJ IDEA and created a new Java project.
2. Created a new Java class named `HelloWorld` inside the `src` folder.
3. Copied the code above into `HelloWorld.java`.
4. Clicked the green **Run** button next to the `main` method.
5. The Run console displayed:

   ```text
   Hello, World!
   ```

---

## 3. Environment Verification

The JDK installation was verified by:

- Checking `java -version` in the command prompt.
- Checking `javac -version` to confirm the compiler is installed.
- Successfully compiling and running a Hello World application in IntelliJ IDEA.
