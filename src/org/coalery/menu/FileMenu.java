package org.coalery.menu;

import org.coalery.manager.LanguageManager;

import javax.swing.*;

public class FileMenu extends JMenu {

    public FileMenu() {
        super(LanguageManager.getString("FileMenu"));

        JMenuItem file_Load = new JMenuItem(LanguageManager.getString("FileMenu_Load"));
        JMenuItem file_Save = new JMenuItem(LanguageManager.getString("FileMenu_Save"));

        add(file_Load);
        add(file_Save);
    }

}
