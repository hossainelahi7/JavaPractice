/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: GeneralManager.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class GeneralManager extends Person {

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public GeneralManager() {
    }

    public GeneralManager(String firstName, String lastName) {
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