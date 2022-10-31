package CoreEntities.IO;

import javax.swing.JFrame;

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

    }

}
