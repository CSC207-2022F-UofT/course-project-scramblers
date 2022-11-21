package CoreEntities.IO;

import javax.swing.*;
import java.awt.*;

public class View{

    private static JFrame frame;
    private int height;
    private int width;

    public View(int w, int h){

        frame = new JFrame();
        width = w;
        height = h;
    }

    /*
    Getter Method for the View Frame
    */
    public JFrame getFrame(){
        return frame;
    }

    /*
    Getter Method for the View Frame's width
    */
    public int getWidth(){
        return width;
    }

    /*
    Getter Method for the View Frame's height
    */
    public int getHeight(){
        return height;
    }





//    public void setUpView(){
//        frame.setSize(width, height);
//        frame.setTitle("SCRABBLE");
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setVisible(true);
//        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));
//    }

//    public void errorWindow(String msg){
//        JOptionPane errorframe = new JOptionPane();
//        JButton button = new JButton("OK");
//        button.setSize(10,20);
//        final JTextField errorText = new JTextField(msg);
//        errorframe.setSize(300,200);
//        errorframe.setVisible(true);
//
//
//    }




    public static void main(String[] args) {
        //View v = new View(600,600);

        HomeWindow home = new HomeWindow(frame);
        home.setUpHomeWindow();


    }
}
