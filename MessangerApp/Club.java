/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Club extends Organization {

    //
    // Instance Data Fields
    //
    private int yearEstablished;
    private String[] owners;
    private String[] colors;
    private String officialName;
    private String shortName;

    //
    // Constructors
    //
    public Club() {
        this(1883, new String[]{"San Francisco Baseball Associates LLC"}, new String[]{"Orange", "Black", "Gold", "Cream"}, "San Francisco Giants", "SF Giants");
    }

    public Club(int yearEstablished, String[] owners, String[] colors, String officialName, String shortName) {
        this.yearEstablished = yearEstablished;
        this.owners = owners;
        this.colors = colors;
        this.officialName = officialName;
        this.shortName = shortName;
    }

    // Single-argument constructor for compatibility with Config
    public Club(String officialName) {
        this(1883, new String[]{"San Francisco Baseball Associates LLC"}, new String[]{"Orange", "Black", "Gold", "Cream"}, officialName, "SF Giants");
    }

    //
    // Static Methods
    //
private void setDefaultClub(String officialName) {
        officialName = "San Francisco Giants";
}
    //
    // Instance Methods
    //
public String displayInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Club: ").append(officialName).append(" (Established: ").append(yearEstablished).append(")\n");
        sb.append("Owners: ");
        for (int i = 0; i < owners.length; i++) {
            sb.append(owners[i]);
            if (i < owners.length - 1) sb.append(", ");
        }
        sb.append("\nColors: ");
        for (int i = 0; i < colors.length; i++) {
            sb.append(colors[i]);
            if (i < colors.length - 1) sb.append(", ");
        }
        sb.append("\nShort Name: ").append(shortName);
        return sb.toString();
    }
    //
    // Language
    //
    // Implement abstract methods from Organization
    @Override
    public void displayAbout() {
        System.out.println("About: " + officialName + " is a professional baseball club established in " + yearEstablished + ".");
    }
    @Override
    public void displayMission() {
        System.out.println("Mission: To promote baseball and community spirit.");
    }
}