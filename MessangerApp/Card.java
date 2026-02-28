/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

public final class Card {
   //
    // Instance Data Fields
    //
    private int artSize = 0;     // Changed if needed for ASCII art alignment
    private String artFont = ""; // Changed if needed for ASCII art style

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public String getMessage() {
        return message;
    }

    private String name;
    private Character character;
    private String message;

    //
    // Constructors
    //
    public Card(String name, Character character, String message) {
        this.name = name;
        this.character = character;
        this.message = message;
    }


    public int getArtSize() {
        return artSize;
    }

    public void setArtSize(int artSize) {
        this.artSize = artSize;
    }

    public String getArtFont() {
        return artFont;
    }

    public void setArtFont(String artFont) {
        this.artFont = artFont;
    }


    //
    // Instance Methods
    //

/*
    public void printCard(Player player, Club club) {
        // Line separators help match the visual style of the sample output
        System.out.println("-".repeat(70));

        // %-25s ensures the colons align vertically across all sections
        System.out.printf("%-25s %s%n", "Player:", player.getName());
        System.out.printf("%-25s %s%n", "assignment02partB.Club:", club.getClubName());

        System.out.println("-".repeat(70));
    }*/

    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}