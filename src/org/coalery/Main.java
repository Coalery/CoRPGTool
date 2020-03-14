package org.coalery;

import org.coalery.manager.Language;
import org.coalery.manager.LanguageManager;
import org.coalery.util.DirectorySelector;

public class Main {
    public static void main(String[] args) {
        LanguageManager.init(Language.KOREAN, "language/");
        System.out.println(DirectorySelector.select(null).getAbsolutePath());
        javax.swing.SwingUtilities.invokeLater(MainUI::new);
    }
}