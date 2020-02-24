package org.coalery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ZeroSizeSplitPane extends JComponent {
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int ORIENTATION_HORIZONTAL = 2;

    private final Color dividerColor = Color.RED;

    private Component leftComponent;
    private Component rightComponent;

    private JPanel dividerHandle;
    private final int dividerSize = 5; // TODO dividerSize have to change each resolution(Screen Size).

    private int orientation;
    private int dividerLocation = -1;
    private float proportion;

    public ZeroSizeSplitPane(int orientation, Component leftComponent, Component rightComponent, float proportion) {
        this.orientation = orientation;
        this.leftComponent = leftComponent;
        this.rightComponent = rightComponent;
        this.proportion = proportion;

        dividerHandle = new JPanel();
        dividerHandle.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(point, ZeroSizeSplitPane.this);
                if(orientation == ORIENTATION_VERTICAL)
                    dividerLocation = point.x;
                else
                    dividerLocation = point.y;
                repaint();
            }
        });
        setLayout(null);

        add(dividerHandle);
        add(leftComponent);
        add(rightComponent);

        setComponentZOrder(dividerHandle, 0);
        setComponentZOrder(leftComponent, 1);
        setComponentZOrder(rightComponent, 2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(dividerColor);
        if(orientation == ORIENTATION_VERTICAL) {
            if(dividerLocation == -1) dividerLocation = (int)(getWidth() * proportion);
            leftComponent.setBounds(0, 0, dividerLocation, getHeight());
            rightComponent.setBounds(dividerLocation + 1, 0, getWidth() - dividerLocation - 1, getHeight());
            dividerHandle.setBounds(dividerLocation - dividerSize - 1, 0, dividerSize * 2 + 1, getHeight());
            dividerHandle.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            g.drawLine(dividerLocation, 0, dividerLocation, getHeight());
        } else {
            if(dividerLocation == -1) dividerLocation = (int)(getHeight() * proportion);
            leftComponent.setBounds(0, 0, getWidth(), dividerLocation);
            rightComponent.setBounds(0, dividerLocation + 1, getWidth(), getHeight() - dividerLocation - 1);
            dividerHandle.setBounds(0, dividerLocation - dividerSize - 1, getWidth(), dividerSize * 2 + 1);
            dividerHandle.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            g.drawLine(0, dividerLocation, getWidth(), dividerLocation);
        }
        dividerHandle.setOpaque(false);
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
