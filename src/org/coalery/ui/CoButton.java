package org.coalery.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CoButton extends JButton {

    public CoButton() {
        super();
        decorate();
    }

    public CoButton(Icon icon) {
        super(icon);
        decorate();
    }

    public CoButton(String text) {
        super(text);
        decorate();
    }

    public CoButton(Action a) {
        super(a);
        decorate();
    }

    public CoButton(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    public void decorate() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getBackground().darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackground().brighter());
            }
        });

        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
