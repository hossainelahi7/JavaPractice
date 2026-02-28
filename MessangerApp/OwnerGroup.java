/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OwnerGroup.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class OwnerGroup extends Organization{
    //
    // Data fields
    //

    //
    // Constructors
    //
    public OwnerGroup() {
    }

    //
    // Instance Methods
    //

    // Implement abstract methods from Organization
    @Override
    public void displayAbout() {
        System.out.println("About: Owner group of the club.");
    }
    @Override
    public void displayMission() {
        System.out.println("Mission: To support and manage the club's operations.");
    }

    //
    // Override
    //
}