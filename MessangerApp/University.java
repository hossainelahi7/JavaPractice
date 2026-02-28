/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: University.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class University extends Organization {

    //
    // Instance Data Fields
    //
    private String mottoLatin;
    private String mottoEnglish;
    private String type;
    private int established;
    private String location;
    private String address;
    private String colors;
    private String nickname;
    private String mascot;
    private String website;

    //
    // Constructors
    //
    public University() {

        this.mottoLatin = "Experientia Docet";
        this.mottoEnglish = "Experience Teaches";
        this.type = "Public";
        this.established = 1899;
        this.location = "San Francisco, California, United States";
        this.address = "1600 Holloway Avenue, San Francisco, CA 94132";
        this.colors = "Purple, Gold";
        this.nickname = "Gators";
        this.mascot = "Gator";
        this.website = "www.sfsu.edu";
    }

    public University(String name) {
        this();
    }

    //
    // Instance Methods
    //


    @Override
    public void displayAbout() {

        System.out.println(this.getUniversityPhrase(0));
        System.out.printf("%-25s %s%n", "Official Name:", "San Francisco State University");
        System.out.printf("%-25s %s%n", "Motto in Latin:", this.mottoLatin);
        System.out.printf("%-25s %s%n", "Motto in English:", this.mottoEnglish);
        System.out.printf("%-25s %s%n", "Type:", this.type);
        System.out.printf("%-25s %d%n", "Year of Establishment:", this.established);
        System.out.printf("%-25s %s%n", "Location:", this.location);
        System.out.printf("%-25s %s%n", "Address:", this.address);
        System.out.printf("%-25s %s%n", "Colors:", this.colors);
        System.out.printf("%-25s %s%n", "Nickname:", this.nickname);
        System.out.printf("%-25s %s%n", "Mascot:", this.mascot);
        System.out.printf("%-25s %s%n", "Website:", this.website);
        System.out.println(this.getUniversityPhrase(0));
    }


    @Override
    public void displayMission() {

        System.out.println("SFSU Mission: To provide high-quality education in a diverse environment.");
    }

    //
    // Language
    //
    private String getUniversityPhrase(int i) {

        return Messenger.getConfig().getLanguage().getConfigPhrase(i);
    }
}