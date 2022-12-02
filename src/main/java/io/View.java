package io;

import io.ui.logic.Controller;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JDialog implements Observer {
    private JPanel contentPane = new JPanel();
    private JButton NewButton;
    private JButton QuitButton;
    private JLabel Title;
    private JButton LoadButton;
    private JTextField FilePathField;
    private JPanel HomeScreenPanel;
    private Controller c;

    public View() {
        c = null;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(NewButton);

        // Button to call onNewButton() to start new game
        NewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNewButton();
            }
        });

        QuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });


        // call onQuit() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    public void setController(Controller c) {
        this.c = c;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private void onNewButton() {
        // CALL METHOD TO START NEW GAME THROUGH CONTROLLER
        dispose();
    }

    private void onQuit() {
        // add your code here if necessary

        dispose();
    }

    public static void main(String[] args) {
        View dialog = new View();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
