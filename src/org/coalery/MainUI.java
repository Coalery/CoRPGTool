package org.coalery;

import org.coalery.tab.ConsoleTab;
import org.coalery.tab.FileTab;
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
        ConsoleTab consoleTab = new ConsoleTab();

        Component[] middlePaneComponents = { mapTab, consoleTab };
        float[] middlePaneProportions = { 0.7f, 1.0f };

        FileTab fileTab = new FileTab();
        ZeroSizeSplitPane middlePane = new ZeroSizeSplitPane(ZeroSizeSplitPane.ORIENTATION_HORIZONTAL, middlePaneComponents, middlePaneProportions);
        PropertyTab propertyTab = new PropertyTab();

        Component[] mainPaneComponents = { fileTab, middlePane, propertyTab };
        float[] mainPaneProportions = { 0.2f, 0.8f, 1.0f };

        ZeroSizeSplitPane mainPane = new ZeroSizeSplitPane(ZeroSizeSplitPane.ORIENTATION_VERTICAL, mainPaneComponents, mainPaneProportions);

        setBackground(Color.CYAN);
        add(mainPane);

        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }
}
