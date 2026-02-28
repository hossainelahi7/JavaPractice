/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Quiz {

    //
    // Instance Data Fields
    //
    String question;
    String answer;

    //
    // Constructors
    //
    public Quiz(String question, String answer) {
    }

    public static Quiz[] getQuiz(){
        Quiz[] quizzes = new Quiz[6];
        quizzes[0] = new Quiz("Which type of class has 'protected' constructors?", "abstract");
        // TODO: add all 6 questions here.

        return quizzes;
    }

    //
    // Instance Methods
    //


    public void runQuiz(QuestionAnswer qa, String studentAnswer) {
        // Compare student's answer to the correct answer "abstract" (case-insensitive)
        if (studentAnswer != null && studentAnswer.equalsIgnoreCase(qa.getAnswer())) {
            System.out.println("SF Giants: Correct!");
            System.out.println("*** Congrats! You won FREE TICKETS to SF GIANTS Games ***");
        } else {
            // Error messaging to match the "Oops..." style in Sample Output
            System.out.println("SF Giants: Oops...");
            System.out.println("Please try again at your graduation ceremony. _______");
        }
    }

    //
    // Additional Instance Methods
    //

    //
    // Language
    //
}