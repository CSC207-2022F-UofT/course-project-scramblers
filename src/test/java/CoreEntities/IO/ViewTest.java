package CoreEntities.IO;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    public static void main(String[] args) {
        View v = new View(600,600);
        JFrame frame = v.getFrame();
        HomeWindow homeWindow = new HomeWindow(frame);
        homeWindow.setUpHomeWindow();



    }

}