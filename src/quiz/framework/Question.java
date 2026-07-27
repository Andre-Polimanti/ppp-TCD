package quiz.framework;

import java.util.List;

public class Question {
    private String statement;
    private List<String> alternatives;
    private int correctIndex;

    public Question(String statement, List<String> alternatives, int correctIndex) {
        this.statement = statement;
        this.alternatives = alternatives;
        this.correctIndex = correctIndex;
    }

    public String getStatement() { return statement; }
    public List<String> getAlternatives() { return alternatives; }
    public int getCorrectIndex() { return correctIndex; }
}