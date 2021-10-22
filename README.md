# Factset Guessing Game Code

This repository contains the code for the guessing game program. The application has been developed using Maven to necessitate easier dependency management. There are two main directories in the project namely: src/main/java directory which contains the application files and a corresponding src/test/java which contains the test files.The program has been divided into multiple classes spanning across two main packages to ensure a standard structure.

# Setup Instructions

In order to run the program, you can download/clone the repository and then import the GuessingProgram directory as a maven project into your IDE and then start the GuessingGameLauncher class (located in the com.game.guesser.client package inside src/main/java) as a Java Application. Before running the program, please make sure the compiler source and target versions in the pom.xml matches your system Java version.

# Guessing Game v1.1

The new version of the project has been developed as a web app using Spring Boot and JSP. The directory structure is similar to the first version, except for the additional packages created for the controller and the SpringBootApplication classes.

# Setup Instructions for Guessing Game v1.1

In order to run the program, you can download/clone the repository and then import the Guessing Game v1.1 folder as a maven project into your IDE. Once the project has been imported, it should be started as a Spring Boot App. Once the application has started, you can go to localhost:8080/index to the start the game. Please note that as per the  guidelines, the program will terminate after 3 tries or when you guess the correct answer (whichever is earliest) and you will need to restart the application from the IDE to play again.
