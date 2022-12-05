package io;

import core_entities.game_parts.Board;
import core_entities.game_parts.LetterRack;
import core_entities.game_parts.Square;
import io.ui.logic.Controller;
import io.ui.logic.Presenter;
import io.ui.logic.ViewModel;
import launch_new_game_use_case.LaunchGameResponseModel;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ViewFinal extends JFrame{

    private JFrame frame;
    private JPanel masterPanel;
    private JPanel superMasterPanel;
    private JPanel masterPanel2;
    private GridLayout gridLayoutBoard;
    private GridLayout gridLayoutMenu;
    private GridLayout gridLayoutRack;
    private GridLayout gridLayoutMaster2;
    private JPanel BoardPanel;
    private JPanel MenuPanel;
    private JPanel RackPanel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JButton QUIT;
    private JButton LOAD;
    private JButton NEW;
    private ArrayList<JButton> List_of_Board_Buttons;
    private ArrayList List_of_Letter_Rack_Buttons;
    private JTextField coordinates_x;
    private JTextField coordinates_y;
    private JLabel coordinates_instructions_x;
    private JLabel coordinates_instructions_y;
    private JTextField word;
    private JLabel word_instructions;
    private JButton okButton;
    private JLabel error_message_field;
    private JLabel error_message;
    private JTextField csvFilePathField;
    private JLabel csvInstructionLabel;
    private JButton rerackButton;
    private Controller controller;
    private JLabel score_1;


    public ViewFinal(Controller ctrlor){
        //creating a controller instance
        controller = ctrlor;

        //creating the supermaster panel
        superMasterPanel = new JPanel();
        superMasterPanel.setLayout(new BoxLayout(superMasterPanel, BoxLayout.Y_AXIS));

        //creating the master panels
        masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.X_AXIS));

        masterPanel2 = new JPanel();
        masterPanel2.setLayout(new BoxLayout(masterPanel2, BoxLayout.Y_AXIS));

        //creating the sub panels
        BoardPanel = new JPanel();
        MenuPanel = new JPanel();
        RackPanel = new JPanel();
        subPanel1 = new JPanel();
        subPanel2 = new JPanel();


        //creating the grids
        gridLayoutBoard = new GridLayout(15,15);
        gridLayoutMenu = new GridLayout(5,1);
        gridLayoutRack = new GridLayout(10,1);
        gridLayoutMaster2 = new GridLayout(5,2);



        BoardPanel.setLayout(gridLayoutBoard);
        RackPanel.setLayout(gridLayoutRack);
        MenuPanel.setLayout(gridLayoutMenu);
        //masterPanel2.setLayout(gridLayoutMaster2);


        //creating the rerack button and adding it to the rack panel
        rerackButton = new JButton("Rerack");
        RackPanel.add(rerackButton);
        score_1 = new JLabel("Current Player's Score:");
        RackPanel.add(score_1);


        //creating menu buttons
        QUIT = new JButton("QUIT");
        LOAD = new JButton("LOAD");
        NEW = new JButton("NEW");

        //creating CSV file path textfield and instruction label
        csvInstructionLabel = new JLabel("Place csv file path below for custom board (optional):");
        csvFilePathField = new JTextField();

        //adding menu buttons and field to MenuPanel

        MenuPanel.add(NEW);
        MenuPanel.add(QUIT);
        MenuPanel.add(LOAD);
        MenuPanel.add(csvInstructionLabel);
        MenuPanel.add(csvFilePathField);

        //creating the board buttons
        List_of_Board_Buttons = ScrabbleBoard();



        //creating the letter rack buttons
        List_of_Letter_Rack_Buttons = RackButtons();

        //creating score buttons


        //creating the coordinates_x instructions label
        coordinates_instructions_x = new JLabel("The board is a 15x15 grid starting with an origin of 0,0 in the top left corner box. Please type in the x coordinate of where you wish to place the word in the textbox below:");
        masterPanel2.add(coordinates_instructions_x);


        //creating the coordinates_x textfield
        coordinates_x = new JTextField();
        masterPanel2.add(coordinates_x);


        //creating the coordinates_y instructions label
        coordinates_instructions_y = new JLabel("Please type in the y coordinate of where you wish to place the word in the textbox below:");
        masterPanel2.add(coordinates_instructions_y);


        //creating the coordinates_y textfield
        coordinates_y = new JTextField();
        masterPanel2.add(coordinates_y);



        //creating the word instructions JLabel
        word_instructions = new JLabel("Please type in word using the letters from the letter rack in the top right corner. Do not use any letters more than once unless you have more than one tile of that specific letter (DO NOT TYPE IN NUMBERS OR ANY SPECIAL CHARACTERS):");
        masterPanel2.add(word_instructions);

        //creating the word textfield
        word = new JTextField();
        masterPanel2.add(word);

        //creating the OK button
        okButton = new JButton("ENTER");
        masterPanel2.add(okButton);

        //creating error message fields
        error_message = new JLabel("If there is an error message, it will show up below:");
        error_message_field = new JLabel("");
        masterPanel2.add(error_message);
        masterPanel2.add(error_message_field);


        //Adding all the panels
        subPanel1.add(BoardPanel);
        subPanel2.add(MenuPanel);
        subPanel2.add(RackPanel);


        masterPanel.add(subPanel1);
        masterPanel.add(subPanel2);


        superMasterPanel.add(masterPanel);
        superMasterPanel.add(masterPanel2);

        //setting up the buttons' actionListeners
        QUIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });


        LOAD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = csvFilePathField.getText();

                controller.reloadGame(/*String path*/);
            }
        });


        NEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.launchTheGame(/*String ""*/);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = word.getText();
                text = text.toLowerCase().strip();
                String x = getCoordinates_x();
                String y = getCoordinates_y();
                //controller.placeWordExecute(text, x, y);
            }
        });

        //adding panel to frame
        frame = new JFrame("Scrabble");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(superMasterPanel);
        frame.setVisible(true);



    }


    public void updateScore1(String score) {
        setScore_1(score);
    }

    public void updateRack(LetterRack rack){
        for (int i = 0; i<7; i++){
            JButton temp = (JButton) List_of_Letter_Rack_Buttons.get(i);
            char temp_letter = rack.getLETTERS()[i].getLetter();
            temp.setText(String.valueOf(temp_letter));
        }

    }

    public void updateErrorMsg(String err){
        setError_message_field(err);
    }


    public void updateBoard(char [][] b){
        ArrayList<JButton> lst = List_of_Board_Buttons;
        int pos = 0;
        for (int i = 0; i< 15; i++){
            for (int j = 0; j<15; j++){
                lst.get(pos).setText(String.valueOf(b[j][i]));
                pos += 1;
            }
        }
    }





    public static void main(String[] args) {

        ViewFinal view = new ViewFinal(null);

    }

    public ArrayList ScrabbleBoard(){

        ArrayList button_list = new ArrayList();

        int start_point_x = 450;
        int start_point_y = 100;
        int position_i = start_point_x;

        for(int i = 0; i < 15; i++){

            int position_j = start_point_y;
            for( int j = 0; j < 15; j++){
                JButton button = new JButton(" ");
                button.setSize(5,5);
                button.setAlignmentX(position_i);
                button.setAlignmentY(position_j);
                BoardPanel.add(button);
                button_list.add(button);

            }

            position_i += 20;
        }

        return button_list;
    }




    public ArrayList RackButtons(){

        ArrayList button_list = new ArrayList();


            for( int j = 0; j < 7; j++){
                JButton button = new JButton(" ");
                button.setSize(3,3);
                RackPanel.add(button);
                button_list.add(button);

            }


        return button_list;
    }






    public String getCoordinates_x() {
        return coordinates_x.getText();
    }

    public String getCoordinates_y() {
        return coordinates_y.getText();
    }

    public String getScore_1(){
        return score_1.getText();
    }

    public void setScore_1(String score) {
        score_1.setText("Current Player's Score: " + score);
    }

    public void setError_message_field(String err){
        error_message_field.setText(err);
    }

    public void setColors(){
        ArrayList<JButton> lst = List_of_Board_Buttons;
        Square [][] multi =
        for (int i=0; i<225; i++){

        }
    }

}
