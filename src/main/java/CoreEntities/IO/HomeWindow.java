package CoreEntities.IO;

import javax.swing.*;
import java.awt.*;

public class HomeWindow {

    private JFrame frame;
    private int height;
    private int width;

    public HomeWindow(int w, int h){

        frame = new JFrame();
        width = w;
        height = h;

    }


    public void setUpHomeWindow(){
        frame.setSize(width, height);
        frame.setTitle("SCRABBLE");
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));
    }
}
