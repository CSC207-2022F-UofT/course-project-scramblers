package CoreEntities.IO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    private JFrame frame;
    private int height;
    private int width;
    private JPanel panel;

    public  GameWindow(){

        frame = new JFrame("Scrabble");
        panel = new JPanel();
        width = 600;
        height = 600;
    }

    public void setUpGameWindow(){
        frame.setSize(width, height);




        JButton ahhh = new JButton("AHHHHH");
        ahhh.setSize(10,20);
        ahhh.setAlignmentX(200);

        JLabel text = new JLabel("Text goes here");
        text.setAlignmentX(200);
        text.setAlignmentY(500);

        JTextField field = new JTextField("TEMPORARY TEXT GOES HERE");
        field.setSize(30,60);
        field.setAlignmentX(200);
        field.setAlignmentY(400);


        panel.add(ahhh);
        panel.add(field);
        panel.add(text);



        frame.add(panel);
        frame.setVisible(true);

        frame.setBackground(Color.getHSBColor((float) 0.6,(float) 0.40,(float) 1.0));



        ahhh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = field.getText();
                text.setText(temp);
            }
        });




    }
}
