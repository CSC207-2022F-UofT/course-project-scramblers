package CoreEntities.IO;

import javax.swing.*;
import java.awt.*;

public class HomeWindow{

    private JFrame frame;
    private int height;
    private int width;
    JLabel title = new JLabel("WELCOME TO SCRABBLE!", Math.round(width/2));




    public HomeWindow(JFrame OriginalFrame){

        frame = OriginalFrame;
        width = OriginalFrame.getWidth();
        height = OriginalFrame.getHeight();


    }

    /*
    Getter method for HomeWindow's height
     */
    public int getHeight(){
        return height;
    }


    /*
    Getter method for HomeWindow's width
     */
    public int getWidth(){
        return width;
    }




    /*
    Creates quit, load, and new buttons.
    */
    public JButton HomeWindowButton(String str){
        if(str.equals("QUIT")){
            JButton quit = new JButton("Quit");
            quit.setSize(10,20);
            quit.setAlignmentX(width/2);
            quit.setAlignmentY(height/3);
            return quit;
        }
        else if(str.equals("LOAD")){
            JButton load = new JButton("Load");
            load.setSize(10, 20);
            load.setAlignmentX(width/2);
            load.setAlignmentY(2*(height/3));
            return load;
        }

        else{
            JButton neww = new JButton("New");
            neww.setSize(10, 20);
            neww.setAlignmentX(width/2);
            neww.setAlignmentY(3*(height/3));
            return neww;
        }
    }


    public void setUpHomeWindow(){
        frame.setSize(600, 600);
        frame.setTitle("SCRABBLE");

        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));
        frame.getContentPane().add(title);

        // Creating the 3 main buttons
        JButton NewButton = HomeWindowButton("NEW");
        JButton LoadButton = HomeWindowButton("LOAD");
        JButton QuitButton = HomeWindowButton("QUIT");

        // Adding the buttons to the frame
        frame.getContentPane().add(NewButton);
        frame.getContentPane().add(LoadButton);
        frame.getContentPane().add(QuitButton);


        frame.setVisible(true); // keep this last in the method so that everything shows up properly

    }

}
