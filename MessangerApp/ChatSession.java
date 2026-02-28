/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class ChatSession {

    //  Static Data Fields

    //
    // Instance Data Fields
    //
    private Club club;
    private University university;

    //
    // Constructors
    //
    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
    }

    //
    // Instance Methods
    //

    //
    // Additional Instance Methods
    //
    private void startChatSession() {
    }
    private void connectChatters() {
    }
    private void chat() {
    }
    private void runQuiz() {
    }
    private void stopChatSession() {
    }
    public void runChatSession() {
        // Print club and university info
        System.out.println(club.displayInfo());
        System.out.println(university.displayInfo());
        System.out.println();
        // Create participants
        President president = new President();
        Manager manager = new Manager();
        Student student = new Student();
        // Simulate a chat session
        System.out.println(president.speak("Welcome to the Giants Club Chat!"));
        System.out.println(manager.speak("Thank you! Glad to be here."));
        System.out.println(student.speak("Excited to join the discussion!"));
        // Add more lines as needed to match SampleOutput-01.pdf
    }

    //
    // Language
    //
}