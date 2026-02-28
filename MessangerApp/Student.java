/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Student.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Student extends Person {

    //
    // Constructors
    //
    public Student() {
        super();
    }

    //
    // Instance Methods
    //
    public String speak(String message) {
        return "[Student]: " + message;
    }

    @Override
    public void sayGreeting(String greeting) {
        System.out.println("[Student]: " + greeting);
    }
}