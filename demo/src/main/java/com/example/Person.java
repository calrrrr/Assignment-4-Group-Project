package com.example;
import java.util.HashMap;
import java.util.Date;

public class Person {
    
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    public String birthdate;
    private HashMap<Date, Integer> demeritPoints;
    private boolean isSuspended;

    public boolean addPerson(){
        // Logic to add a person
        return true; // Assuming the addition is successful
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