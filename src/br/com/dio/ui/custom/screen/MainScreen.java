package br.com.dio.ui.custom.screen;

import br.com.dio.service.BoardService;
import br.com.dio.ui.custom.button.FinishGameButton;
import br.com.dio.ui.custom.button.ResetButton;
import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class MainScreen {

    private static Dimension dimension = new Dimension(600, 600);

    private BoardService boardService;


    private JButton checkGameStatusButton;
    private JButton finisGameButton;
    private JButton resetButton;

    public MainScreen(Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();

    }

    private void addFinishGameButton(JPanel mainPanel) {
        finisGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()) {
                JOptionPane.showMessageDialog(null, "Parabéns, você concluiu o jogo!");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finisGameButton.setEnabled(false);
            } else {
                var message = "Seu jogo tem alguma inconsistência, ajuste e tente novamente.";
                JOptionPane.showMessageDialog(null, message);
            }
        });
        mainPanel.add(finisGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new FinishGameButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var message = switch (gameStatus) {
                case NON_STARTED -> "O jogo não foi iniciado.";
                case INCOMPLETE -> "O jogo está incompleto.";
                case COMPLETE -> "O jogo está completo.";
            };
            message += hasErrors ? " e contém erros" : " e não contém erros";
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(checkGameStatusButton);

    }

    private void addResetButton(JPanel mainPanel) {
        resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente reiniciar o jogo?",
                    "Limpar o jogo",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );
            if (dialogResult == 0) {
                boardService.reset();
            }
        });
        mainPanel.add(resetButton);

    }


}
