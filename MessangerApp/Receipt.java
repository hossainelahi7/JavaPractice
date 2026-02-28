/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Receipt.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Receipt {

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Receipt() {
    }

    //
    // Instance Methods
    //


    public void showReceipt(Student student, int cardCount, double price) {
        System.out.println("-".repeat(70));

        // Using the same 25-character alignment used in assignment02partB.Club and Player classes
        System.out.printf("%-25s %s %s%n", "Student:", student.getFirstName(), student.getLastName());
        System.out.printf("%-25s %s%n", "Email:", student.getEmail());
        System.out.printf("%-25s %d%n", "Card Quantity:", cardCount);

        // Calculating total and formatting as currency
        double total = cardCount * price;
        System.out.printf("%-25s $%.2f%n", "Total Price:", total);

        System.out.println("-".repeat(70));
    }
}