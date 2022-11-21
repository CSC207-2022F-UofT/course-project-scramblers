package CoreEntities.IO;

import javax.swing.*;
import java.awt.*;

public class HomeWindow {

    private JFrame frame;
    private int height;
    private int width;
    JLabel title = new JLabel("WELCOME TO SCRABBLE!",((Integer) (width/2)));

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image img = toolkit.getImage("207Logo");


    public HomeWindow(int w, int h){

        frame = new JFrame();
        width = w;
        height = h;


    }


    public void setUpHomeWindow(){
        frame.setSize(width, height);
        frame.setTitle("SCRABBLE");

        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));
        frame.getContentPane().add(title);
        title.setVisible(true);

        frame.setVisible(true); // keep this last in the method so that everything shows up properly

    }

}
