package org.coalery;

import org.coalery.manager.LanguageManager;
import org.coalery.manager.Language;

public class Main {
    public static void main(String[] args) {
        LanguageManager.init(Language.KOREAN, "language/");
        javax.swing.SwingUtilities.invokeLater(MainUI::new);
    }
}