package quiz.aplications.math;

import java.util.Arrays;
import java.util.List;
import quiz.framework.Question;
import quiz.framework.QuizManager;
import quiz.framework.QuizUI;
import quiz.framework.ScoringStrategy;

public class QuizMatematica extends QuizManager {

    @Override
    protected List<Question> createQuestions() {
        return Arrays.asList(
            new Question("Qual é a raiz quadrada de 144?",
                Arrays.asList("10", "12", "14", "16"), 1),
            new Question("Quanto é 7 vezes 8?",
                Arrays.asList("54", "56", "58", "62"), 1)
        );
    }

    @Override
    protected ScoringStrategy createStrategy() {
        //+5 por acerto, -2 por erro
        return isCorrect -> isCorrect ? 5 : -2;
    }

    @Override
    protected QuizUI createUI() {
        return new ConsoleUI();
    }

    public static void main(String[] args) {
        new QuizMatematica().start();
    }
}