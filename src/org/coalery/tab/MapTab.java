package org.coalery.tab;

import org.coalery.map.MapCell;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MapTab extends DefaultTab {

    private MapCell[][] map;

    private Point lastPoint;
    private Point standardPoint;
    private int cellSize = 50;

    public MapTab() {
        super();
        setLayout(null);
        setBackground(Color.GRAY);

        standardPoint = new Point(0, 0);

        addMouseListener(new ReleaseListener());
        addMouseMotionListener(new DragListener());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(new Color(255, 255, 255, 127));
        for(int i=0; i*cellSize < getWidth(); i++) {
            int a = standardPoint.x % cellSize;
            if(a < 0) a += cellSize;
            int x = i * cellSize + a;
            g2.drawLine(x, 0, x, getHeight());
        }
        for(int i=0; i*cellSize < getHeight(); i++) {
            int a = standardPoint.y % cellSize;
            if(a < 0) a += cellSize;
            int y = i * cellSize + a;
            g2.drawLine(0, y, getWidth(), y);
        }
    }

    private class DragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            if(lastPoint == null)
                lastPoint = e.getPoint();
            else {
                Point currentPoint = e.getPoint();
                Point delta = new Point(currentPoint.x - lastPoint.x, currentPoint.y - lastPoint.y);
                standardPoint.setLocation(standardPoint.x + delta.x, standardPoint.y + delta.y);
                lastPoint = e.getPoint();
                MapTab.this.repaint();
            }
        }
    }

    private class ReleaseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            lastPoint = null;
        }
    }
}
