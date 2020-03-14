package org.coalery.util;

import javax.swing.*;
import java.awt.*;

public class MessageShow {

    public static void showMessage(Component parent, int type, String title, String message) {
        JOptionPane.showMessageDialog(parent, message, title, type);
    }

}
