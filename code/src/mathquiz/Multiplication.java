package mathquiz;

import java.io.*;

public class Multiplication extends Quiz {

    private int answer1 = 15;
    private int answer2 = 100;
    private int answer3 = 132;
    private File myFile = new File("C:\\School\\CP2\\OOP Java\\MathQuiz\\quizMultiplication.txt");

    // This method reads a specific text file to gather quiz questions.
    public void getQuiz() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            setQuestion1(reader.readLine());
            setQuestion2(reader.readLine());
            setQuestion3(reader.readLine());
            reader.close();
            setAnswer1(answer1);
            setAnswer2(answer2);
            setAnswer3(answer3);
        } catch (Exception e) {
            System.out.println("Could not find quiz.");
        }
    }
}
