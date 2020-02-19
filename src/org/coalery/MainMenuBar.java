package org.coalery;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
        JMenu file = new JMenu("File");
        { // File Menu Region
            JMenuItem file_Save = new JMenuItem("Save");
            JMenuItem file_Load = new JMenuItem("Load");

            file.add(file_Save);
            file.add(file_Load);
        }

        JMenu help = new JMenu("Help");
        { // Help Menu Region

        }

        add(file);
        add(help);
    }

}
