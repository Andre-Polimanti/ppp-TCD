package quiz.aplications.math;

import java.util.List;
import java.util.Scanner;
import quiz.framework.Question;
import quiz.framework.QuizManager;
import quiz.framework.QuizUI;

public class ConsoleUI implements QuizUI {
    private QuizManager manager;
    private Scanner scanner;

    @Override
    public void setManager(QuizManager manager) {
        this.manager = manager;
    }

    @Override
    public void startUI() {
        scanner = new Scanner(System.in);
        System.out.println("   BEM-VINDO AO QUIZ DE MATEMÁTICA    ");
    }

    @Override
    public void displayQuestion(Question question) {
        System.out.println("\n-> " + question.getStatement());
        List<String> alts = question.getAlternatives();
        
        for (int i = 0; i < alts.size(); i++) {
            System.out.println("   [" + i + "] " + alts.get(i));
        }
        
        System.out.print("Digite o número da sua resposta: ");
        int answer = scanner.nextInt();
        
        manager.submitAnswer(answer); 
    }

    @Override
    public void displayResult(int totalScore, int correct, int errors) {
        System.out.println("             RESULTADO FINAL          ");
        System.out.println("Acertos.......: " + correct);
        System.out.println("Erros.........: " + errors);
        System.out.println("Pontuação Total: " + totalScore);
        
        if (scanner != null) {
            scanner.close();
        }
    }
}