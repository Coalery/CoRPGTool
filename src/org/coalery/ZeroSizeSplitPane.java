package org.coalery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ZeroSizeSplitPane extends JComponent {
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int ORIENTATION_HORIZONTAL = 2;

    private final int dividerSize = 5; // TODO dividerSize have to change each resolution(Screen Size).
    private final Color dividerColor = Color.RED;
    private final float leastProportion = 0.1f;

    private Component[] components;
    private JPanel[] dividerHandles;
    private float[] weight;
    private int orientation;

    public ZeroSizeSplitPane(int orientation, Component[] components, float[] weight) {
        if(components.length != weight.length) return;

        this.orientation = orientation;
        this.components = components;
        this.weight = weight;
        this.dividerHandles = new JPanel[weight.length - 1];

        int zIndexCnt = 0;
        for(int i=0; i<dividerHandles.length; i++) { // Divider Handle Processing.
            dividerHandles[i] = new JPanel();
            dividerHandles[i].addMouseMotionListener(new ZeroSizeDivider(i));
            if(orientation == ORIENTATION_VERTICAL) dividerHandles[i].setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            else dividerHandles[i].setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            dividerHandles[i].setOpaque(false);
            add(dividerHandles[i]);
            setComponentZOrder(dividerHandles[i], zIndexCnt++);
        }

        for (Component component : components) { // Components Processing.
            add(component);
            setComponentZOrder(component, zIndexCnt++);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(dividerColor);

        int componentLocation = 0;
        if(orientation == ORIENTATION_VERTICAL) {
            for(int i=0; i<components.length - 1; i++) {
                int dividerLocation = (int)(getWidth() * weight[i]);
                components[i].setBounds(componentLocation, 0, dividerLocation - componentLocation, getHeight());
                dividerHandles[i].setBounds(dividerLocation - dividerSize, 0, dividerSize * 2, getHeight());
                componentLocation = dividerLocation;
            }
            components[components.length - 1].setBounds(componentLocation, 0, getWidth() - componentLocation, getHeight());
        } else {
            for(int i=0; i<components.length - 1; i++) {
                int dividerLocation = (int)(getHeight() * weight[i]);
                components[i].setBounds(0, componentLocation, getWidth(), dividerLocation - componentLocation);
                dividerHandles[i].setBounds(0, dividerLocation - dividerSize - 1, getWidth(), dividerSize * 2 + 1);
                componentLocation += dividerLocation;
            }
            components[components.length - 1].setBounds(0, componentLocation, getWidth(), getHeight() - componentLocation);
        }
    }

    public void setProportion(float weight, int index) {
        float frontWeight = (index - 1 >= 0 ? this.weight[index - 1] : 0.0f);
        float backWeight = (index + 1 < this.weight.length ? this.weight[index + 1] : 0.9999f);

        if(weight < frontWeight + leastProportion) this.weight[index] = frontWeight + leastProportion;
        else if(weight > backWeight - leastProportion) this.weight[index] = backWeight - leastProportion;
        else this.weight[index] = weight;
    }

    private class ZeroSizeDivider extends MouseMotionAdapter {
        private int index;
        public ZeroSizeDivider(int index) { this.index = index; }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(point, ZeroSizeSplitPane.this);
            if (orientation == ORIENTATION_VERTICAL)
                setProportion(point.x / (float) getWidth(), index);
            else
                setProportion(point.y / (float) getHeight(), index);
            repaint();
        }
    }

}
