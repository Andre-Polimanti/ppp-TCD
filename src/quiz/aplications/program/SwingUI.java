package quiz.aplications.program;

import quiz.framework.Question;
import quiz.framework.QuizManager;
import quiz.framework.QuizUI;

import javax.swing.*;
import java.awt.*;

public class SwingUI implements QuizUI {
    private QuizManager manager;
    private JFrame frame;
    private JLabel lblQuestion;
    private JPanel pnlAlternatives;
    private ButtonGroup btnGroup;
    private JButton btnSubmit;

    @Override
    public void setManager(QuizManager manager) {
        this.manager = manager;
    }

    @Override
    public void startUI() {
        frame = new JFrame("Quiz de Programação - Lord Biggus Dickus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout(10, 10));

        lblQuestion = new JLabel("Carregando...", SwingConstants.CENTER);
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(lblQuestion, BorderLayout.NORTH);

        pnlAlternatives = new JPanel();
        pnlAlternatives.setLayout(new BoxLayout(pnlAlternatives, BoxLayout.Y_AXIS));
        frame.add(pnlAlternatives, BorderLayout.CENTER);

        btnSubmit = new JButton("Confirmar Resposta");
        btnSubmit.addActionListener(e -> processSubmit());
        frame.add(btnSubmit, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void processSubmit() {
        int selectedIndex = -1;
        int i = 0;
        for (Component c : pnlAlternatives.getComponents()) {
            if (c instanceof JRadioButton) {
                if (((JRadioButton) c).isSelected()) {
                    selectedIndex = i;
                    break;
                }
                i++;
            }
        }
        
        if (selectedIndex != -1) {
            manager.submitAnswer(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, selecione uma alternativa antes de prosseguir.");
        }
    }

    @Override
    public void displayQuestion(Question question) {
        lblQuestion.setText(question.getStatement());
        pnlAlternatives.removeAll();
        btnGroup = new ButtonGroup();

        for (String alt : question.getAlternatives()) {
            JRadioButton rb = new JRadioButton(alt);
            btnGroup.add(rb);
            pnlAlternatives.add(rb);
        }
        
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void displayResult(int totalScore, int correct, int errors) {
        String resultMsg = String.format("Fim de Jogo!\n\nAcertos: %d\nErros: %d\nPontuação Final: %d", correct, errors, totalScore);
        JOptionPane.showMessageDialog(frame, resultMsg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }
}