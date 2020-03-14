package org.coalery.util;

import org.coalery.manager.LanguageManager;
import org.coalery.ui.CoButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectorySelector {

    public static File select(Frame parent) {
        final JDialog selector = new JDialog(parent, LanguageManager.getString("DirectorySelector_Title"), true);

        File[] roots = File.listRoots();
        if(roots.length == 0) {
            MessageShow.showMessage(selector, JOptionPane.ERROR_MESSAGE, LanguageManager.getString("MessageShow_Error"), LanguageManager.getString("DirectorySelector_CantFindRoot"));
            return null;
        }

        Container contentPane = selector.getContentPane();
        contentPane.setPreferredSize(new Dimension(450, 250));
        contentPane.setLayout(null);

        String[] rootsName = new String[roots.length];
        for(int i=0; i<roots.length; i++)
            rootsName[i] = roots[i].toString();

        final JComboBox<String> rootsCombo = new JComboBox<>(rootsName);
        rootsCombo.setBounds(5, 5, 440, 20);

        final ListModel<String> directoryListModel = new DefaultListModel<>();
        final JList<String> directoryList = new JList<>(directoryListModel);
        final JScrollPane directoryListScroll = new JScrollPane(directoryList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        directoryListScroll.setBounds(5, 30, 440, 165);

        final CoButton selectButton = new CoButton(LanguageManager.getString("DirectorySelector_SelectButton"));
        selectButton.setBounds(355, 200, 90, 20);

        final CoButton cancelButton = new CoButton(LanguageManager.getString("DirectorySelector_CancelButton"));
        cancelButton.setBounds(355, 225, 90, 20);

        contentPane.add(rootsCombo);
        contentPane.add(directoryListScroll);
        contentPane.add(selectButton);
        contentPane.add(cancelButton);
        selector.pack();
        selector.setVisible(true);
        return null;
    }

}
