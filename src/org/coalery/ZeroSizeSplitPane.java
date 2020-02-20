package org.coalery;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

// https://www.formdev.com/blog/swing-tip-jsplitpane-with-zero-size-divider/

public class ZeroSizeSplitPane extends JSplitPane {
    private int dividerDragSize = 9;
    private int dividerDragOffset = 4;

    public ZeroSizeSplitPane() {
        setDividerSize(1);
        setContinuousLayout(true);
    }

    @Override
    public void doLayout() {
        super.doLayout();

        BasicSplitPaneDivider divider = ((BasicSplitPaneUI)getUI()).getDivider();
        Rectangle bounds = divider.getBounds();
    }
}
