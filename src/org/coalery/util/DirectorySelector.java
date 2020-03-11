package org.coalery.util;

import org.coalery.manager.LanguageManager;
import org.coalery.ui.CoButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectorySelector {

    public static File select(Frame parent) {
        JDialog selector = new JDialog(parent, LanguageManager.getString("DirectorySelector_Title"), true);
        selector.setSize(600, 300);
        selector.setLayout(null);

        CoButton selectButton = new CoButton(LanguageManager.getString("DirectorySelector_SelectButton"));
        selectButton.setSize(100, 50);
        selectButton.setLocation(40, 40);

        selector.add(selectButton);
        selector.setVisible(true);
        return null;
    }

}
