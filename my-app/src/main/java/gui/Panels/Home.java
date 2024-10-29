package gui.Panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Home extends JPanel {

    private Color backgroundColor = new Color(237, 237, 233);

    public Home () {
        initialize();
    }

    private void initialize() {
        this.setBackground(backgroundColor);
        this.setPreferredSize(new Dimension(1920, 1080));
    }
}
