package com.example;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        File testFile = new File("test_output.txt");

        // Add a person
        boolean addResult = person.addPerson("56!@abc#CD", "John", "Doe", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        System.out.println("addPerson result: " + addResult);
         System.out.println("\nContents of updateDetails:");
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        // Update personal details
        boolean updateResult = person.updatePersonalDetails("56!@abc#CD", "Jane", "Doe", "199|Grove St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        System.out.println("updatePersonalDetails result: " + updateResult);
        
        System.out.println("\nContents of updateDetails:");
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        // Add demerit points
        String demeritResult = person.addDemeritPoints("56!@abc#CD", 3, "10-05-2024", testFile);
        System.out.println("addDemeritPoints result: " + demeritResult);

        // Check suspension
        boolean suspended = person.isSuspended();
        System.out.println("isSuspended result: " + suspended);
    }
}