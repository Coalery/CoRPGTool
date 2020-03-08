package org.coalery.menu;

import org.coalery.manager.LanguageManager;

import javax.swing.*;

public class SettingsMenu extends JMenu {

    public SettingsMenu() {
        super(LanguageManager.getString("SettingsMenu"));
    }

}
