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

        // Alternative of exceptions(ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
        try { UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() ); } catch (Exception e) { e.printStackTrace(); }

        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) { System.exit(0); }});

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)(screenSize.width * 0.75f), (int)(screenSize.height * 0.75f));

        MapTab mapTab = new MapTab();
        PropertyTab propertyTab = new PropertyTab();

        Component[] components = { mapTab, propertyTab };
        float[] proportions = { 0.8f, 1.0f };

        ZeroSizeSplitPane map_property_SplitPane = new ZeroSizeSplitPane(ZeroSizeSplitPane.ORIENTATION_VERTICAL, components, proportions);

        add(map_property_SplitPane);

        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }
}
