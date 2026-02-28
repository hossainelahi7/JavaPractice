package assignment02partB;/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: assignment02partB.Manager.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Manager extends Person {

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Manager() {
    }
    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
    }
    //
    // Instance Methods
    //

    //
    // Language
    //

    //
    // Override
    //
    @Override
    public void sayGreeting(String string) {

        System.out.println(string);
    }
}