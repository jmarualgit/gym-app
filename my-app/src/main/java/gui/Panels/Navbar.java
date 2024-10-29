package gui.Panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Navbar extends JPanel {

    private Color tabBackgroundColor = new Color(214, 204, 194);
    private Color tabForegroundColor = new Color(227, 213, 202);
    private Dimension tabSize = new Dimension(200, 50);
    
    public Navbar() {
        initialize();
    }

    private void initialize() {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Home", new Home());
        tabbedPane.addTab("Workout!", new Workout());
        tabbedPane.addTab("Info", new Info());

        this.setBackground(tabBackgroundColor);
        tabbedPane.setBackground(tabForegroundColor);

        JLabel label1 = new JLabel("Home", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Workout!", SwingConstants.CENTER);
        JLabel label3 = new JLabel("Info", SwingConstants.CENTER);

        label1.setPreferredSize(tabSize);
        label2.setPreferredSize(tabSize);
        label3.setPreferredSize(tabSize);

        tabbedPane.setTabComponentAt(0, label1);
        tabbedPane.setTabComponentAt(1, label2);

        tabbedPane.setTabComponentAt(2, label3);

        // home selected
        tabbedPane.setSelectedIndex(0);
        
        this.add(tabbedPane);
    }
}
