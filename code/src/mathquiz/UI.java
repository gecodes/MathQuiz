package mathquiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UI {

    // Declare fields
    private Quiz quiz;
    private Date date;
    private SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private String currentQuiz;

    private int answer1;
    private int answer2;
    private int answer3;

    private JFrame frame;

    private JButton addButton;
    private JButton subButton;
    private JButton multiButton;
    private JButton submitButton;

    private JTextField input1;
    private JTextField input2;
    private JTextField input3;
    private JTextField inputName;
    private JTextField inputAge;

    private JLabel namePrompt;
    private JLabel agePrompt;
    private JLabel question1;
    private JLabel question2;
    private JLabel question3;
    private JLabel result;

    private JPanel mainPanel;
    private JPanel selectPanel;
    private JPanel infoPanel;
    private JPanel question1Panel;
    private JPanel question2Panel;
    private JPanel question3Panel;
    private JPanel resultsPanel;

    // UI constructor
    public UI() {

        // Instantiate elements
        frame = new JFrame("Math");

        // Buttons
        addButton = new JButton("Addition");
        subButton = new JButton("Subtraction");
        multiButton = new JButton("Multiplication");
        submitButton = new JButton("Submit");

        // Button actions.
        // The quiz selection buttons will load a quiz's questions from a text file.
        // Addition
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quiz = new Addition();
                currentQuiz = "Addition";
                setup();
            }
        });
        // Subtraction
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quiz = new Subtraction();
                currentQuiz = "Subtraction";
                setup();
            }
        });
        // Multiplication
        multiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quiz = new Multiplication();
                currentQuiz = "Multiplication";
                setup();
            }
        });

        // Submit
        // This button checks the quiz's answers against the user's input and prints a time stamped score to an incrementing report card.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                try {
                    if (answer1 == Integer.parseInt(input1.getText())) {
                        input1.setForeground(Color.GREEN);
                        counter++;
                    } else {
                        input1.setForeground(Color.RED);
                    }
                    if (answer2 == Integer.parseInt(input2.getText())) {
                        input2.setForeground(Color.GREEN);
                        counter++;
                    } else {
                        input2.setForeground(Color.RED);
                    }
                    if (answer3 == Integer.parseInt(input3.getText())) {
                        input3.setForeground(Color.GREEN);
                        counter++;
                    } else {
                        input3.setForeground(Color.RED);
                    }
                    date = new Date();
                    String score = "Score: " + counter + "/3";
                    String name = inputName.getText();
                    int age = Integer.parseInt(inputAge.getText());
                    result.setText(score);

                    PrintWriter reportCard = new PrintWriter(new FileWriter("C:\\School\\CP2\\OOP Java\\MathQuiz\\quizResults.txt", true));
                    reportCard.println(fmt.format(date) + " | " +
                            quiz.formatInfo(name) +
                            quiz.formatInfo(age) +
                            currentQuiz + " | " +
                            score);
                    reportCard.close();

                } catch (NumberFormatException | IOException error) {
                    result.setText("Error");
                }
            }
        });

        // Labels
        namePrompt = new JLabel("Name:");
        namePrompt.setPreferredSize(new Dimension(50, 15));
        agePrompt = new JLabel("Age:");
        agePrompt.setPreferredSize(new Dimension(50, 15));
        question1 =  new JLabel("Question 1");
        question1.setPreferredSize(new Dimension(180, 10));
        question2 =  new JLabel("Question 2");
        question2.setPreferredSize(new Dimension(180, 10));
        question3 =  new JLabel("Question 3");
        question3.setPreferredSize(new Dimension(180, 10));
        result = new JLabel("Result");
        result.setPreferredSize(new Dimension(100, 10));

        // Text fields
        inputName = new JTextField();
        inputName.setPreferredSize(new Dimension(100, 25));
        inputAge = new JTextField();
        inputAge.setPreferredSize(new Dimension(30, 25));
        input1 = new JTextField();
        input1.setPreferredSize(new Dimension(50, 25));
        input2 = new JTextField();
        input2.setPreferredSize(new Dimension(50, 25));
        input3 = new JTextField();
        input3.setPreferredSize(new Dimension(50, 25));

        // Set up super-panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new GridLayout(6,1));

        // Select question sub-panel
        selectPanel = new JPanel();
        selectPanel.setLayout(new FlowLayout());
        selectPanel.add(addButton);
        selectPanel.add(subButton);
        selectPanel.add(multiButton);

        // Input info sub-panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(namePrompt);
        infoPanel.add(inputName);
        infoPanel.add(agePrompt);
        infoPanel.add(inputAge);

        // Question 1 sub-panel
        question1Panel = new JPanel();
        question1Panel.setLayout(new FlowLayout());
        question1Panel.add(question1);
        question1Panel.add(input1);

        // Question 2 sub-panel
        question2Panel = new JPanel();
        question2Panel.setLayout(new FlowLayout());
        question2Panel.add(question2);
        question2Panel.add(input2);

        // Question 3 sub-panel
        question3Panel = new JPanel();
        question3Panel.setLayout(new FlowLayout());
        question3Panel.add(question3);
        question3Panel.add(input3);

        // Results sub-panel
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new FlowLayout());
        resultsPanel.add(submitButton);
        resultsPanel.add(result);

        // Set up frame and main panel
        frame.add(mainPanel);
        mainPanel.add(selectPanel);
        mainPanel.add(infoPanel);
        mainPanel.add(question1Panel);
        mainPanel.add(question2Panel);
        mainPanel.add(question3Panel);
        mainPanel.add(resultsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    // This method sets up a new quiz by resetting the text fields and displaying the questions.
    private void setup() {
        input1.setText(null);
        input1.setForeground(Color.BLACK);
        input2.setText(null);
        input2.setForeground(Color.BLACK);
        input3.setText(null);
        input3.setForeground(Color.BLACK);
        result.setText("Good Luck!");
        quiz.getQuiz();
        question1.setText(quiz.getQuestion1());
        question2.setText(quiz.getQuestion2());
        question3.setText(quiz.getQuestion3());
        answer1 = quiz.getAnswer1();
        answer2 = quiz.getAnswer2();
        answer3 = quiz.getAnswer3();
    }
}
