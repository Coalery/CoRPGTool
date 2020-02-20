package org.coalery;

import org.coalery.tab.MapTab;
import org.coalery.tab.PropertyTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends JFrame{
    public MainUI() {
        super("CoRPGTool");
        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) { System.exit(0); }});
        setDefaultLookAndFeelDecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)(screenSize.width * 0.75f), (int)(screenSize.height * 0.75f));

        MapTab mapTab = new MapTab();
        PropertyTab propertyTab = new PropertyTab();

        ZeroSizeSplitPane map_property_SplitPane = new ZeroSizeSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapTab, propertyTab);
        map_property_SplitPane.setOneTouchExpandable(true);
        map_property_SplitPane.setDividerLocation((int)(getWidth() * 0.75f));

        mapTab.setMinimumSize(new Dimension(150, 0));
        propertyTab.setMinimumSize(new Dimension(150, 0));

        add(map_property_SplitPane);

        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }
}
