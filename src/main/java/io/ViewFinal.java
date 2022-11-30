package io;

import core_entities.game_parts.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ViewFinal extends JFrame implements Observer {

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
    private ArrayList List_of_Board_Buttons;
    private ArrayList List_of_Letter_Rack_Buttons;
    private JTextField coordinates;
    private JLabel coordinates_instructions;
    private JTextField word;
    private JLabel word_instructions;
    private JButton okButton;
    private JLabel error_message_field;
    private JLabel error_message;
    private JTextField csvFilePathField;
    private JLabel csvInstructionLabel;
    private JButton rerackButton;


    public ViewFinal(){

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
        gridLayoutRack = new GridLayout(8,1);
        gridLayoutMaster2 = new GridLayout(5,2);



        BoardPanel.setLayout(gridLayoutBoard);
        RackPanel.setLayout(gridLayoutRack);
        MenuPanel.setLayout(gridLayoutMenu);
        //masterPanel2.setLayout(gridLayoutMaster2);


        //creating the rerack button and adding it to the rack panel
        rerackButton = new JButton("Rerack");
        RackPanel.add(rerackButton);


        //creating menu buttons
        QUIT = new JButton("QUIT");
        LOAD = new JButton("LOAD");
        NEW = new JButton("NEW");

        //creating CSV file path textfield and instruction label
        csvInstructionLabel = new JLabel("Place csv file path below:");
        csvFilePathField = new JTextField("Delete this text and place your game's csv file path");

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


        //creating the coordinates instructions label
        coordinates_instructions = new JLabel("THIS IS WHERE THE INSTRUCTIONS GO:");
        masterPanel2.add(coordinates_instructions);

        //creating the coordinates textfield
        coordinates = new JTextField();
        masterPanel2.add(coordinates);


        //creating the word instructions JLabel
        word_instructions = new JLabel("this is where the word goes:");
        masterPanel2.add(word_instructions);

        //creating the word textfield
        word = new JTextField();
        masterPanel2.add(word);

        //creating the OK button
        okButton = new JButton("ENTER");
        masterPanel2.add(okButton);

        //creating error message fields
        error_message = new JLabel("If there is an error message, it will show up below:");
        error_message_field = new JLabel("POTENTIAL ERROR MESSAGE");
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

        //adding panel to frame
        frame = new JFrame("Scrabble");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(superMasterPanel);
        frame.setVisible(true);



    }


    @Override
    public void update(Observable o, Object arg) {


    }

    public static void main(String[] args) {
        ViewFinal view = new ViewFinal();

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



    public ArrayList getList_of_Letter_Rack_Buttons() {
        return List_of_Letter_Rack_Buttons;
    }

    public ArrayList getList_of_Board_Buttons() {
        return List_of_Board_Buttons;
    }
}
