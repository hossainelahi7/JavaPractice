/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;

import java.util.Scanner;

public final class ChatSession {

    //
    // Instance Data Fields
    //
    private Config config;
    private Student student;
    private Player player;
    private Club club;
    private University university;
    private Scanner input = new Scanner(System.in);

    //
    // Constructors
    //
    public ChatSession() {
    }

    public ChatSession(Config config) {
        this.config = config;
        this.club = new Club();
        this.university = new University();
        this.player = new Player();
    }

    public ChatSession(Club club, University university) {
        this.config = Messenger.getConfig();
        this.club = club;
        this.university = university;
        this.player = new Player();
    }

    //
    // Instance Methods
    //


    public void runChatSession() {

        System.out.println(config.getTimer().getChatTimestamp() + " - Chat session started.");


        club.displayAbout();


        System.out.print("SF Giants: Your first name and last name, please: ");
        String firstName = input.next();
        String lastName = input.next();
        System.out.print("SF Giants: Your school email address, please: ");
        String email = input.next();

        this.student = new Student(firstName, lastName, email, university);


        System.out.println(student.getFirstName() + ": Welcome to my university!");
        university.displayAbout();


        this.connectChatters();
//        this.chat();
        this.runQuiz();
        this.stopChatSession();
    }

    private void connectChatters() {
        System.out.println("SF Giants: Thank you. We are connecting you with our player...");
        System.out.println(". . . . .");
        player.displayPlayerInfo();
    }

    private void chat() {
        String studentName = student.getFirstName();
        String playerHeader = player.getFirstName() + " " + player.getLastName() + ", " + 28 + ": ";

        System.out.println(playerHeader + "Hello " + studentName + ". C-O-N-G-R-A-T-U-L-A-T-I-O-N-S!");
        System.out.println(playerHeader + Color.sfStateStyle("SAN FRANCISCO STATE UNIVERSITY") + ". Way to go!");
        System.out.println(studentName + ": Thank you, " + player.getFirstName() + "! Nice to e-meet you here !");
        System.out.println(playerHeader + "Likewise," + studentName + ". Very nice chatting w/ you.");


        int noOfCards = 0;
        int tries = 3;
        while (tries > 0) {
            System.out.print(playerHeader + "How many SF Giants Thank You cards would you like to order? ");
            try {

                noOfCards = Integer.parseInt(input.next());
                break;
            } catch (NumberFormatException e) {

                System.out.println("Please enter an INTEGER. " + (tries - 1) + " tries left.");
                System.out.println("java.util.InputMismatchException");
                tries--;
            }
        }

        if(noOfCards > 0){
            System.out.printf(
                    """
                    %s, 28: In 3 lines, please provide%n
                    [1] Recipient name%n
                    [2] Art symbol (a character)%n
                    [3] Message to recipient%n
                    """, playerHeader);

            Card[] cards = new Card[noOfCards];
            input.nextLine();
            for(int cardNo = 0; cardNo < noOfCards ; cardNo++){
                int number = cardNo+1;
                System.out.printf("%s Card #%s:%n", playerHeader, number);
                System.out.printf("%s: [1] ", studentName);
                String recipientName = input.nextLine();
                System.out.printf("%s: [2] ", studentName);
                Character artSymbol = input.nextLine().charAt(0);
                System.out.printf("%s: [3] ", studentName);
                String message = input.nextLine();
                cards[cardNo] = new Card(recipientName, artSymbol, message);
            }
            System.out.printf("%s Thanks, %s. Please confirm your order:%n", playerHeader, studentName);
            for(Card card: cards){
                SFGiantsCardGenerator.generateSFGiantsCard(card.getName(), card.getMessage(), studentName, student.getEmail(), card.getCharacter(), card.getArtSize(), card.getArtFont());
            }
        }
    }

    private void runQuiz() {
        System.out.println("SF Giants: *** FREE TICKETS to SF GIANTS Games *** 1 miss allowed");
        Quiz[] quizzes = Quiz.getQuiz();
        int marks = 2;
        for(Quiz quiz : quizzes){
            System.out.printf("SF Giants: %s%n", quiz.question);
            String answer = input.nextLine().trim();
            //TODO :: check answer value here.
            if(answer.equalsIgnoreCase(quiz.answer)){
                System.out.println("SF Giants: Correct!");
            }else {
                System.out.println("SF Giants: Oops...");
                marks= marks-1;
            }
            if(marks<=0)
                break;
        }
        System.out.println("*** Congrats! You won FREE TICKETS to SF GIANTS Games ***");
    }

    private void stopChatSession() {
        System.out.println(config.getTimer().getChatTimestamp() + " - Chat session ended.");
    }
}