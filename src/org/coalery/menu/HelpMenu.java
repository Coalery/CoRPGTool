package org.coalery.menu;

import org.coalery.manager.LanguageManager;

import javax.swing.*;

public class HelpMenu extends JMenu {

    public HelpMenu() {
        super(LanguageManager.getString("HelpMenu"));
    }

}
