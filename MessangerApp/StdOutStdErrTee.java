/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StdOutStdErrTee extends OutputStream {

    //
    // Instance Data Fields
    //
    private OutputStream console;
    private OutputStream file;
    private String filePath;

    //
    // Constructors
    //


    public StdOutStdErrTee() {
    }


    public StdOutStdErrTee(String filePath, OutputStream console) {
        try {
            this.filePath = filePath;
            this.console = console;
            this.file = new FileOutputStream(filePath);
        } catch (IOException e) {
            System.err.println("Could not create log file: " + e.getMessage());
        }
    }

    //
    // Instance Methods
    //


    public void startLog() {
        // Implementation of log starting logic
    }


    public void stopLog() {
        try {
            if (file != null) {
                file.flush();
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStdOutFilePath() {
        return Config.getDefaultStdOutFilePath(); // Align with Config requirements
    }

    public String getStdErrFilePath() {
        return Config.getDefaultStdErrFilePath(); // Align with Config requirements
    }

    //
    // Override
    //
    @Override
    public void write(int b) throws IOException {
        if (console != null) {
            console.write(b);
        }
        if (file != null) {
            file.write(b);
        }
    }
}