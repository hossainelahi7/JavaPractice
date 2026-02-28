package assignment02partB;

/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: Anika Hossain Sharna
 * **********************************************
 */

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Club extends Organization {

    //
    // Static Data Fields
    //
    private static String officialSong = "I Left My Heart in San Francisco";

    //
    // Instance Data Fields
    //
    private String shortName;
    private int established;
    private String colors;
    private String ballpark;
    private int worldSeriesTitles;
    private int nlPennants;
    private int divisionTitles;
    private int wildCardBerths;
    private String owners;
    private President president;
    private GeneralManager generalManager;
    private Manager manager;

    //
    // Constructors
    //
    public Club() {
        this.shortName = "SF Giants";
        this.established = 1883;
        this.colors = "Orange, Black, Gold, Cream";
        this.ballpark = "Oracle Park";
        this.worldSeriesTitles = 8;
        this.nlPennants = 23;
        this.divisionTitles = 8;
        this.wildCardBerths = 3;
        this.owners = "San Francisco Baseball Associates LLC";


        this.president = new President("Farhan", "Zaidi");
        this.generalManager = new GeneralManager("Scott", "Harris");
        this.manager = new Manager("Gabe", "Kapler");
    }

    public Club(String name) {
        this();
    }

    //
    // Static Methods
    //
    public static String getOfficialSong() {
        return officialSong;
    }

    public static void setOfficialSong(String officialSong) {
        Club.officialSong = officialSong;
    }

    //
    // Instance Methods
    //


    public String getClubName() {
        return "San Francisco Giants";
    }

    @Override
    public void displayAbout() {
        this.displayInfo();
    }

    @Override
    public void displayMission() {

        System.out.println("SF Giants Mission: Dedicated to the fans and community.");
    }

    public void displayInfo() {
        // Using %-25s for IDENTICAL column alignment as required
        System.out.println(this.getClubPhrase(0));
        System.out.printf("%-25s %s%n", "Club:", this.getClubName());
        System.out.printf("%-25s %s%n", "Short Name:", this.shortName);
        System.out.printf("%-25s %d%n", "Established in:", this.established);
        System.out.printf("%-25s %s%n", "Colors:", this.colors);
        System.out.printf("%-25s %s%n", "Ballpark:", this.ballpark);
        System.out.printf("%-25s %d%n", "World Series Titles:", this.worldSeriesTitles);
        System.out.printf("%-25s %d%n", "NL Pennants:", this.nlPennants);
        System.out.printf("%-25s %d%n", "Division Titles:", this.divisionTitles);
        System.out.printf("%-25s %d%n", "Wild Card Berths:", this.wildCardBerths);
        System.out.printf("%-25s %s%n", "Owners:", this.owners);
        System.out.printf("%-25s %s %s%n", "President:", president.getFirstName(), president.getLastName());
        System.out.printf("%-25s %s %s%n", "General Manager:", generalManager.getFirstName(), generalManager.getLastName());
        System.out.printf("%-25s %s %s%n", "Manager:", manager.getFirstName(), manager.getLastName());
        System.out.println(this.getClubPhrase(0));
    }

    //
    // Language
    //
    private String getClubPhrase(int i) {
        // Defensive check: If config is null, return a default separator to avoid NPE
        if (Messenger.getConfig() != null && Messenger.getConfig().getLanguage() != null) {
            return Messenger.getConfig().getLanguage().getConfigPhrase(i);
        }
        return "-".repeat(70);
    }
}