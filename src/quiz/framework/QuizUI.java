package quiz.framework;

public interface QuizUI {
    void setManager(QuizManager manager);
    void startUI();
    void displayQuestion(Question question);
    void displayResult(int totalScore, int correct, int errors);
}