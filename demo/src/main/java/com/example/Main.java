package com.example;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("test_output.txt");
        // Clear the file at the start
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            // Clear file
        } catch (IOException e) {
            System.out.println("Could not clear file: " + e.getMessage());
        }

        Person person = new Person();

        // Add a person
        person.addPerson("56!@abc#CD", "John", "Doe", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);

        // Update personal details
        person.updatePersonalDetails("56!@abc#CD", "Jane", "Doe", "199|Grove St|Melbourne|Victoria|Australia", "15-11-1990", testFile);

        // // Add demerit points
        person.addDemeritPoints("56!@abc#CD", 6, "11-05-2024", testFile);
        person.addDemeritPoints("56!@abc#CD", 6, "12-05-2024", testFile);
        person.addDemeritPoints("56!@abc#CD", 1, "13-05-2024", testFile);
        

        // Print file contents once at the end
        System.out.println("\nContents of test_output.txt:");
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}