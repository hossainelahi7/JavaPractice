/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: QuestionAnswer.java
 * Author: Duc Ta
 * Author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class QuestionAnswer {

    //
    // Instance Data Fields
    //
    private String question;
    private String answer;

    //
    // Constructors
    //
    public QuestionAnswer() {
    }

    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    //
    // Instance Method
    //
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    //
    // Language
    //

    //
    // Override
    //
}