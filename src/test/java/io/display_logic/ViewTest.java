package io.display_logic;

import io.windows.HomeWindow;
import io.display_logic.View;

import javax.swing.*;

class ViewTest {
    public static void main(String[] args) {
        View v = new View(600,600);
        JFrame frame = v.getFrame();
        HomeWindow homeWindow = new HomeWindow(frame);
        homeWindow.setUpHomeWindow();



    }

}