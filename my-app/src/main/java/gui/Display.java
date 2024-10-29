package gui;

import java.awt.Dimension;
import javax.swing.JFrame;

import gui.Panels.Navbar;

public class Display extends JFrame {

    private Dimension windowSize = new Dimension(1920, 1080);

    public Display () {
        new JFrame("Java Gym App.");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowSize);

        initialize();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initialize() {
        this.add(new Navbar());
    }
}
