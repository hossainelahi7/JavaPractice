/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: University.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class University extends Organization {
    //
    // Static Data Fields
    //

    //
    // Instance Data Fields
    private String name;
    private String location;

    //
    // Constructors
    //
    public University() {
        this("San Francisco State University", "San Francisco, CA");
    }

    public University(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Single-argument constructor for compatibility with Config
    public University(String name) {
        this(name, "San Francisco, CA");
    }

    //
    // Instance Methods
    public String displayInfo() {
        return "University: " + name + " (" + location + ")";
    }

    //
    // Additional Methods
    // Implement abstract methods from Organization
    @Override
    public void displayAbout() {
        System.out.println("About: " + name + " is a public university located in " + location + ".");
    }
    @Override
    public void displayMission() {
        System.out.println("Mission: To educate, inspire, and empower students.");
    }

    //
    // Language
    //

    //
    // Override
    //
}