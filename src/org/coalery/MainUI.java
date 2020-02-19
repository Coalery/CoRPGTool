package org.coalery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends JFrame{
    public MainUI() {
        super("CoRPGTool");
        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) { System.exit(0); }});

        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }
}
