package gui.Panels;

import java.awt.Color;

import javax.swing.JPanel;

public class Info extends JPanel {

    private Color backgroundColor = new Color(237, 237, 233);

    public Info () {
        initialize();
    }

    private void initialize() {
        this.setBackground(backgroundColor);
    }
}
