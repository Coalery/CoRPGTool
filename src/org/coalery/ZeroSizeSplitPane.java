package org.coalery;

import javax.swing.*;
import java.awt.*;

public class ZeroSizeSplitPane extends JComponent {
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int ORIENTATION_HORIZONTAL = 2;

    private final Color dividerColor = Color.GRAY;

    private Component leftComponent;
    private Component rightComponent;

    private int orientation;
    private int dividerLocation;
    private float proportion;

    public ZeroSizeSplitPane(int orientation, Component leftComponent, Component rightComponent, float proportion) {
        this.orientation = orientation;
        this.leftComponent = leftComponent;
        this.rightComponent = rightComponent;
        this.proportion = proportion;
    }

    @Override
    public void paint(Graphics g) {
        dividerLocation = (int)(getWidth() * proportion);
        g.setColor(dividerColor);
        if(orientation == ORIENTATION_VERTICAL)
            g.drawLine(dividerLocation, 0, dividerLocation, getHeight());
        else
            g.drawLine(0, dividerLocation, getWidth(), dividerLocation);
    }

    public Component getLeftComponent() { return leftComponent; }
    public void setLeftComponent(Component leftComponent) { this.leftComponent = leftComponent; }

    public Component getRightComponent() { return rightComponent; }
    public void setRightComponent(Component rightComponent) { this.rightComponent = rightComponent; }

    public int getOrientation() { return orientation; }
    public void setOrientation(int orientation) { this.orientation = orientation; }

    public int getDividerLocation() { return dividerLocation; }
    public void setDividerLocation(int dividerLocation) { this.dividerLocation = dividerLocation; }

    public float getProportion() { return proportion; }
    public void setProportion(float proportion) { this.proportion = proportion; }
}
