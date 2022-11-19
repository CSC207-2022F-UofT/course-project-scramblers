package CoreEntities.IO;

import javax.swing.JFrame;
import java.awt.*;

public class View{

    private JFrame frame;
    private int height;
    private int width;

    public View(int w, int h){

        frame = new JFrame();
        width = w;
        height = h;
    }

    public void setUpView(){
        frame.setSize(width, height);
        frame.setTitle("SCRABBLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));
        //frame.getContentPane().setBackground(Color.getHSBColor((float) 0.36, (float) 0.2, (float) (1.0)));

    }

}
