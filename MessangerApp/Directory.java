/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Directory.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;
import java.io.File;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Directory {

    //
    // Instance Data Fields
    //
    private String path;

    //
    // Constructors
    //
    public Directory() {

        this.path = "assignment02PartB" + File.separator + "log" + File.separator;
    }

    public Directory(String path) {
        this.path = path;
    }

    //
    // Instance Methods
    //


    public String getPath() {

        return this.path;
    }


    public void createDirectory() {
        File directory = new File(this.path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}