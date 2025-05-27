package com.example;
import java.util.HashMap;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Person {
    
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    private String birthdate;
    private HashMap<Date, Integer> demeritPoints;
    private boolean isSuspended;

    public boolean addPerson(String personID, String address, String birthdate, File file) {
        this.personID = personID;
        this.address = address;
        this.birthdate = birthdate;
        
        //Condition 1
        //PersonID should be exactly 10 characters long
        if (personID.length() != 10) {
            return false; // Invalid personID length
        }
        //the first two characters should be numbers between 2 and 9, there should be at least two special characters between characters 3 and 8,
        //and the last two characters should be upper case letters (A-Z). Example: "56s_d%&fAB"
        if (personID.charAt (0) < '2' || personID.charAt(0) > '9' || personID.charAt(1) < '2' || personID.charAt(1) > '9') {
            return false; // First two characters must be between 2 and 9
        }
        
        String middle = personID.substring(2, 8);
        int specialCount = 0;
        for (char c : middle.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }
        if (specialCount < 2) {
            return false;
        }
        
        if (!personID.substring(8, 10).matches("[A-Z]{2}")) {
            return false; // Last two characters must be uppercase letters
        }

        //Condition 2
        //The address of the Person should follow the follwoiing format: Street Number|Street|City|State|Country.
        //The State should be only Victoria.
        if (!address.matches("^\\d+\\|[^|]+\\|[^|]+\\|Victoria\\|[^|]+$")) {
            return false; // Invalid address format
        }

        //Condition 3
        //The format of the birth date of the person should follow the following format: DD-MM-YYYY. Example: 15-11-1990
        if (!birthdate.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            return false; // Invalid birthdate format
        }

        //Instruction: If the Person's information meets the above conditions and any other conditions you may want to consider,
        //the information should be inserted into a TXT file, and the addPerson function should return true.
        //Otherwise, the information should not be inserted into the TXT file, and the addPerson functionn should return false.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("PersonID: " + personID);
            writer.newLine();
            writer.write("Address: " + address);
            writer.newLine();
            writer.write("Birthdate: " + birthdate);
            writer.newLine();
            writer.write("------");
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception
            return false; // Return false if writing fails
        }
    }

    public boolean updatePersonalDetails(){
        // Logic to update personal details
        return true; // Assuming the update is successful
    }

    public String addDemeritPoints(){
        // Logic to add demerit points
        return "Sucess"; // Assuming the addition is successful
    }
}