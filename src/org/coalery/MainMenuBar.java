package org.coalery;

import org.coalery.menu.FileMenu;
import org.coalery.menu.HelpMenu;
import org.coalery.menu.SettingsMenu;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
        FileMenu fileMenu = new FileMenu();
        SettingsMenu settingsMenu = new SettingsMenu();
        HelpMenu helpMenu = new HelpMenu();

        add(fileMenu);
        add(settingsMenu);
        add(helpMenu);
    }

}
