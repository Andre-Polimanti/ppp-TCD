package quiz.aplications.program;

import java.util.Arrays;
import java.util.List;
import quiz.framework.Question;
import quiz.framework.QuizManager;
import quiz.framework.QuizUI;
import quiz.framework.ScoringStrategy;

public class QuizProgramacao extends QuizManager {

    @Override
    protected List<Question> createQuestions() {
        return Arrays.asList(
            new Question("Qual princípio do SOLID determina que uma classe deve ter apenas um motivo para mudar?",
                Arrays.asList("Open-Closed Principle", "Single Responsibility Principle", "Liskov Substitution Principle", "Interface Segregation Principle"), 1),
            new Question("Qual padrão de projeto é utilizado para garantir que uma classe tenha apenas uma instância?",
                Arrays.asList("Factory Method", "Observer", "Singleton", "Strategy"), 2)
        );
    }

    @Override
    protected ScoringStrategy createStrategy() {
        return isCorrect -> isCorrect ? 10 : -2;
    }

    @Override
    protected QuizUI createUI() {
        return new SwingUI();
    }

    public static void main(String[] args) {
        new QuizProgramacao().start();
    }
}