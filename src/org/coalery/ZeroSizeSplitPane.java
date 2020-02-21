package org.coalery;

import javax.swing.*;
import java.awt.*;

public class ZeroSizeSplitPane extends JSplitPane {
    public ZeroSizeSplitPane(int orientation, Component leftComponent, Component rightComponent) {
        super(orientation, leftComponent, rightComponent);
        setDividerSize(5);
        setContinuousLayout(true);
    }
}
