
package quizgame;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static String[] questions = { 
        "What is the capital of Lebanon?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal in the world?",
        "Who painted the Mona Lisa?",
        "What is the chemical symbol for oxygen?"
    };
    private static String[][] options = {
        {"A) Beirut", "B) London", "C) Rome", "D) Berlin"},
        {"A) Mars", "B) Venus", "C) Jupiter", "D) Mercury"},
        {"A) Elephant", "B) Blue Whale", "C) Giraffe", "D) Dolphin"},
        {"A) Leonardo da Vinci", "B) Vincent van Gogh", "C) Pablo Picasso", "D) Michelangelo"},
        {"A) O2", "B) CO2", "C) H2O", "D) CH4"}
    };
    private static char[] correctAnswers = {'A', 'A', 'B', 'A', 'A'};
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        int questionDuration = 10; // 10 seconds per question
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.");
                showNextQuestion();
            }
        }, questionDuration * 1000);
        
        showQuestion();
    }
    
    private static void showQuestion() {
        System.out.println(questions[currentQuestionIndex]);
        for (String option : options[currentQuestionIndex]) {
            System.out.println(option);
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        char userAnswer = Character.toUpperCase(scanner.next().charAt(0));
        
        if (userAnswer == correctAnswers[currentQuestionIndex]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " + correctAnswers[currentQuestionIndex]);
        }
        
        showNextQuestion();
    }
    
    private static void showNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            showQuestion();
        } else {
            endQuiz();
        }
    }
    
    private static void endQuiz() {
        System.out.println("Quiz ended.");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}