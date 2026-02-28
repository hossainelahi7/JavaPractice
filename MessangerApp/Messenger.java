/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Messenger.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// Please DO NOT CHANGE this file.

public final class Messenger {

    //
    // main method
    //
    public static void main(String[] args) {
        Messenger.start();
        Messenger.chat();
        Messenger.stop();
    }

    //
    // Static Data Fields
    //
    private static final Config config = new Config();

    //
    // Constructors
    //
    private Messenger() {
    }

    //
    // Static Methods
    //
    public static Config getConfig() {
        return Messenger.config;
    }

    private static void start() {
        // Initializes the logging system and sets up user preferences
        Messenger.config.getStdOutStdErrTee().startLog();
        Messenger.config.setPreferences();
    }

    private static void chat() {
        // Creates a new chat session using the default club and university
        (new ChatSession(Messenger.config.getClub(), Messenger.config.getUniversity())).runChatSession();
    }

    private static void stop() {
        // Closes the logging streams
        Messenger.config.getStdOutStdErrTee().stopLog();

        // Requirement: Temporarily uncomment this line to run assignment02partB.LogFileDriver once chat is working
//         assignment02partB.LogFileDriver.run();
    }
}