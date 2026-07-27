package quiz.framework;

public interface ScoringStrategy {
    int calculateScore(boolean isCorrect);
}