/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OwnerGroup.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class OwnerGroup extends Organization {

    //
    // Data fields
    //
    private String owners; // REQUIRED: Fixes "cannot find symbol variable owners"

    //
    // Constructors
    //
    public OwnerGroup() {
    }

    public OwnerGroup(String owners) {
        this.owners = owners;
    }

    //
    // Instance Methods
    //

    //
    // Override
    //


    @Override
    public void displayMission() {

        System.out.println("Mission: Dedicated to excellence on and off the field.");
    }


    @Override
    public void displayAbout() {

        System.out.printf("%-25s %s%n", "Owner Group:", this.owners);
    }
}