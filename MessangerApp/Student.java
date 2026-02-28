/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Student.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Student extends Person {

    //
    // Instance Data Fields
    //
    private String email;
    private University university;

    //
    // Constructors
    //
    public Student() {
    }

    public Student(String firstName, String lastName, String email, University university) {

        super(firstName, lastName);
        this.email = email;
        this.university = university;
    }

    //
    // Instance Methods
    //
    public String getEmail() {
        return email;
    }

    public University getUniversity() {
        return university;
    }

    //
    // Additional Methods
    //

    //
    // Language
    //

    //
    // Override
    //


    @Override
    public void sayGreeting(String string) {
        if (string != null) {
            System.out.println(string);
        }
    }
}