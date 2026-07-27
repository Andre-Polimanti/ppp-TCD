package quiz.framework;

import java.util.List;

public abstract class QuizManager {
    private List<Question> questions;
    private ScoringStrategy strategy;
    private QuizUI ui;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private int correctCount = 0;
    private int errorCount = 0;

    protected abstract List<Question> createQuestions();
    protected abstract ScoringStrategy createStrategy();
    protected abstract QuizUI createUI();

    // Padrão Template Method: Define o esqueleto do fluxo inicial do quiz
    public final void start() {
        this.questions = createQuestions();
        this.strategy = createStrategy();
        this.ui = createUI();

        this.ui.setManager(this);
        this.ui.startUI();
        showNext();
    }

    public void showNext() {
        if (currentQuestionIndex < questions.size()) {
            ui.displayQuestion(questions.get(currentQuestionIndex));
        } else {
            ui.displayResult(score, correctCount, errorCount);
        }
    }

    public void submitAnswer(int selectedIndex) {
        Question q = questions.get(currentQuestionIndex);
        boolean isCorrect = (selectedIndex == q.getCorrectIndex());

        if (isCorrect) {
            correctCount++;
        } else {
            errorCount++;
        }

        score += strategy.calculateScore(isCorrect);
        currentQuestionIndex++;

        showNext();
    }
}