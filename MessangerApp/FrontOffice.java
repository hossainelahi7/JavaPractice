/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: FrontOffice.java
 * Author: Duc Ta
 * Author: ANIKA Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// JAVA 15, 2020, added "sealed" and "permits" to Java classes.
// We are learning the new elements of JAVA 15.
// "sealed" and "permits" are used here so that we will have one more example to reference.
// We do not need to understand "sealed" and "permits" in order to start and complete this assignment.

public final class FrontOffice {

    //
    // Instance Data Fields
    //
    private String officeName;

    //
    // Constructors
    //
    public FrontOffice() {
    }

    public FrontOffice(String officeName) {
        this.officeName = officeName;
    }

    //
    // Instance Methods
    //


    public void displayAbout() {

        System.out.printf("%-25s %s%n", "Front Office:", this.officeName);
    }

    //
    // Language
    //
}