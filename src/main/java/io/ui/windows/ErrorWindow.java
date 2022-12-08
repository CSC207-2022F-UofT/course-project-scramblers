package io.ui.windows;

import javax.swing.*;

public class ErrorWindow {

    public ErrorWindow(String msg){
        final String error = msg;

        //Error Frame setup
        JInternalFrame window = new JInternalFrame(msg);
        window.setSize(300,200);

        //Button setup
        JButton OKButton = new JButton();
        OKButton.setSize(10,20);
        window.add(OKButton);
        OKButton.setVisible(true);

    }


}
