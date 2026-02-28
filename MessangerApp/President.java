/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: President.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class President extends Person {

    //
    // Instance Data Fields
    //
    private String name;
    private int id;

    //
    // Constructors
    //
    public President() {
        super();
    }

    //
    // Instance Methods
    //
    public String speak(String message) {
        return "[President]: " + message;
    }
    @Override
    public void sayGreeting(String greeting) {
        System.out.println("[President]: " + greeting);
    }

    //
    // Language
    //

    //
    // Override
    //
}
