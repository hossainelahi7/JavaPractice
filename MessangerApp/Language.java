/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

import java.util.Scanner;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Language {

    //
    // Static Data Fields
    //
    private static final String defaultAlienSound = "~ ąļīæń ~ ";

    //
    // Instance Data Fields
    //
    private String language;
    private String[] configPhrases;
    private String[] universityPhrases;
    private String[] clubPhrases;
    private String[] greetingPhrases;

    //
    // Constructors
    //
    public Language() {
        this(Config.getDefaultLanguage());
    }

    public Language(String language) {
        this.language = language;
        switch (language.toLowerCase()) {
            case "alien" -> this.populateAlienPhrases();
            case "chinese" -> this.populateChinesePhrases();
            case "french" -> this.populateFrenchPhrases();
            case "spanish" -> this.populateSpanishPhrases();
            case "future" -> this.populateYourLanguagePhrases();
            default -> this.populateEnglishPhrases();
        }
    }

    //
    // Static Methods
    //
    public static void displayAppHeader() {
        System.out.println(Config.getOfficialAppHeader());
    }


    public static Language setLanguagePreference() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Language: ");
            String lang = input.nextLine();
            if (lang.equalsIgnoreCase("English") || lang.equalsIgnoreCase("Alien")) {
                return new Language(lang);
            }



            System.out.println("Language: UNSUPPORTED language. Please enter your language.");
            System.out.println("Language: English, Chinese, French, Spanish, Alien");
        }
    }

    //
    // Instance Methods
    //
    public String getLanguage() { return language; }

    public String getConfigPhrase(int i) { return configPhrases[i]; }

    public String getUniversityPhrase(int i) { return universityPhrases[i]; }

    public String getClubPhrase(int i) { return clubPhrases[i]; }

    public String getGreetingPhrase(int i) { return greetingPhrases[i]; }

    //
    // Population Methods
    //
    private void populateEnglishPhrases() {

        this.configPhrases = new String[]{
                "-".repeat(70), "Language:", "Time Zone:", "Color Sequences:",
                "Standard Output Log:", "Standard Error Log:", "Receipt Log:",
                "Receipt-*-*.log", "Default University:", "Default Club:"
        };

        this.universityPhrases = new String[]{
                "San Francisco State University", "Experientia Docet", "Experience Teaches", "Public", "1899"
        };

        this.clubPhrases = new String[]{
                "San Francisco Giants", "SF Giants", "1883", "Orange, Black, Gold, Cream", "Oracle Park", "8"
        };

        this.greetingPhrases = new String[]{"Hello", "Welcome", "Nice to meet you"};
    }

    private void populateAlienPhrases() {
        this.configPhrases = new String[10];
        for (int i = 0; i < 10; i++) configPhrases[i] = defaultAlienSound;

        this.universityPhrases = new String[10];
        for (int i = 0; i < 10; i++) universityPhrases[i] = defaultAlienSound;

        this.clubPhrases = new String[10];
        for (int i = 0; i < 10; i++) clubPhrases[i] = defaultAlienSound;

        this.greetingPhrases = new String[3];
        for (int i = 0; i < 3; i++) greetingPhrases[i] = defaultAlienSound;
    }


    private void populateChinesePhrases() { populateEnglishPhrases(); }
    private void populateFrenchPhrases() { populateEnglishPhrases(); }
    private void populateSpanishPhrases() { populateEnglishPhrases(); }
    private void populateYourLanguagePhrases() { populateEnglishPhrases(); }
}