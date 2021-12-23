package mathquiz;

public abstract class Quiz {

    // This is the quiz superclass, it houses the getters and setters, and sets up an abstract method for the subclasses to follow.
    // The subclasses will inherit its methods, including the formatInfo methods which format user info to be displayed later.
    private String question1;
    private String question2;
    private String question3;
    private int answer1;
    private int answer2;
    private int answer3;

    // Abstract method
    public abstract void getQuiz();

    public String formatInfo(String name) {
        return "Name: " + name + " | ";
    }
    public String formatInfo(int age) {
        return "Age: " + age + " | ";
    }

    // Getters and Setters
    public String getQuestion1() {
        return question1;
    }
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }
    public String getQuestion2() {
        return question2;
    }
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }
    public String getQuestion3() {
        return question3;
    }
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
    public int getAnswer1() {
        return answer1;
    }
    public void setAnswer1(int answer1) {
        this.answer1 = answer1;
    }
    public int getAnswer2() {
        return answer2;
    }
    public void setAnswer2(int answer2) {
        this.answer2 = answer2;
    }
    public int getAnswer3() {
        return answer3;
    }
    public void setAnswer3(int answer3) {
        this.answer3 = answer3;
    }
}
