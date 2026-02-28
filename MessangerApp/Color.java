/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Color.java
 * @author: Duc Ta
 * @author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Color {

    //
    // Static Data Fields
    //
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    //
    // Instance Data Fields
    //

    //
    // Constructors
    //
    public Color() {
    }

    //
    // Static Methods
    //


    public static String sfStateStyle(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return ANSI_PURPLE_BACKGROUND + ANSI_YELLOW + string + ANSI_RESET;
    }

    //
    // Instance Methods
    //
    public String getColorSequences() {
        return "Yellow on Purple";
    }

    //
    // Language
    //
}