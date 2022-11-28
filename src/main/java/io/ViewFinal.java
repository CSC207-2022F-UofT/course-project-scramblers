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
    private GridLayout gridLayoutBoard;
    private GridLayout gridLayoutMenu;
    private GridLayout gridLayoutRack;
    private JPanel BoardPanel;
    private JPanel MenuPanel;
    private JPanel RackPanel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JLabel TITLE;
    private ArrayList List_of_Board_Buttons;
    private ArrayList List_of_Letter_Rack_Buttons;


    public ViewFinal(){


        //creating the master panel
        masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.X_AXIS));

        //creating the sub panels
        BoardPanel = new JPanel();
        MenuPanel = new JPanel();
        RackPanel = new JPanel();
        subPanel1 = new JPanel();
        subPanel2 = new JPanel();


        //creating the grids
        gridLayoutBoard = new GridLayout(15,15);
        gridLayoutMenu = new GridLayout(3,1);
        gridLayoutRack = new GridLayout(7,1);



        BoardPanel.setLayout(gridLayoutBoard);
        RackPanel.setLayout(gridLayoutRack);
        MenuPanel.setLayout(gridLayoutMenu);


        List_of_Board_Buttons = ScrabbleBoard();
        List_of_Letter_Rack_Buttons = RackButtons();


        //adding menu buttons
        JButton QUIT = new JButton("QUIT");
        JButton LOAD = new JButton("LOAD");
        JButton NEW = new JButton("NEW");


        MenuPanel.add(NEW);
        MenuPanel.add(QUIT);
        MenuPanel.add(LOAD);

        //adding a letter rack







        //Adding all the panels
        subPanel1.add(BoardPanel);
        subPanel2.add(MenuPanel);
        subPanel2.add(RackPanel);


        masterPanel.add(subPanel1);
        masterPanel.add(subPanel2);


        //adding panel to frame
        frame = new JFrame("Scrabble");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(masterPanel);
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
                JButton button = new JButton("X");
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
                JButton button = new JButton("X");
                button.setSize(3,3);
                RackPanel.add(button);
                button_list.add(button);

            }


        return button_list;
    }

}
