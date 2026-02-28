/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Player extends Person {

    // Instance Data Fields
    private String position;
    private int number;
    private String bats;
    private String throwsHand;
    private int mlbDebut;

    //
    // Constructors
    //
    public Player() {

        super("Buster", "Posey");
        this.position = "Catcher";
        this.number = 28;
        this.bats = "Right";
        this.throwsHand = "Right";
        this.mlbDebut = 2009;
    }

    public Player(String firstName, String lastName, String position, int number,
                  String bats, String throwsHand, int mlbDebut) {
        super(firstName, lastName);
        this.position = position;
        this.number = number;
        this.bats = bats;
        this.throwsHand = throwsHand;
        this.mlbDebut = mlbDebut;
    }

    //
    // Instance Methods
    //


    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public void displayPlayerInfo() {

        System.out.println(this.getPlayerPhrase(0));
        System.out.printf("%-25s %s %s%n", "Player:", this.getFirstName(), this.getLastName());
        System.out.printf("%-25s %s%n", "assignment02partB.Club:", "San Francisco Giants");
        System.out.printf("%-25s %s%n", "Position:", this.position);
        System.out.printf("%-25s %d%n", "Number:", this.number);
        System.out.printf("%-25s %s%n", "Bats:", this.bats);
        System.out.printf("%-25s %s%n", "Throws:", this.throwsHand);
        System.out.printf("%-25s %d%n", "MLB Debut:", this.mlbDebut);
        System.out.println(this.getPlayerPhrase(0));
    }

    //
    // Language
    //
    private String getPlayerPhrase(int i) {

        return Messenger.getConfig().getLanguage().getConfigPhrase(i);
    }

    //
    // @Override
    //
    @Override
    public void sayGreeting(String string) {

        System.out.println(string);
    }
}