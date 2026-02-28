/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Manager.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Manager extends Person {

    //
    // Instance Data Fields
    //
    private String name;
    private int id;

    //
    // Constructors
    //
    public Manager() {
        super();
    }

    //
    // Instance Methods
    //
    public String speak(String message) {
        return "[Manager]: " + message;
    }
    @Override
    public void sayGreeting(String greeting) {
        System.out.println("[Manager]: " + greeting);
    }

    //
    // Language
    //

    //
    // Override
    //
}