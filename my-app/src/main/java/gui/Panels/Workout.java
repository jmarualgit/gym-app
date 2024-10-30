package gui.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import engine.plans.Plan;
import engine.plans.Wendell531;

public class Workout extends JPanel implements ActionListener {

    private Color backgroundColor = new Color(237, 237, 233);
    private Dimension textAreaSize = new Dimension(300, 50);
    private Dimension dropdownSize = new Dimension(200, 30);
    private Dimension buttonSize = new Dimension(200, 50);

    private JButton button;
    private JTextArea bodyWeightInput = new JTextArea("Enter bodyweight in LBS");
    private JTextArea benchPressInput = new JTextArea("Enter bench press 1RM in LBS");
    private JTextArea squatInput = new JTextArea("Enter squat 1RM in LBS");
    private JTextArea deadliftInput = new JTextArea("Enter deadlift 1RM in LBS");
    private JTextArea pressInput = new JTextArea("Enter press 1RM in LBS");
    private JTextArea[] textAreaContainer = {bodyWeightInput, benchPressInput, squatInput, deadliftInput, pressInput};

    private JComboBox<String> workoutListDropDown;

    public Workout () {
        initialize();
    }

    private void initialize() {
        this.setBackground(backgroundColor);
        this.setLayout(new BorderLayout(0,75));
        createDropdown();
        addTextAreas();
        addButton();
    }
    
    private void createDropdown() {
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        String[] workoutLists = {"Choose a program!", "Wendell531", "Make your own!!"};

        workoutListDropDown = new JComboBox<>(workoutLists);
        workoutListDropDown.setPreferredSize(dropdownSize);
        workoutListDropDown.setMaximumSize(workoutListDropDown.getPreferredSize());
        workoutListDropDown.setSelectedIndex(0);

        ActionListener dropdownActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (workoutListDropDown.getSelectedItem() == "Wendell531") {
                    makeTextAreasEditable();
                }
            }
        };

        workoutListDropDown.addActionListener(dropdownActionListener);
        workoutListDropDown.addActionListener(this);
        dropdownPanel.add(workoutListDropDown);

        this.add(dropdownPanel, BorderLayout.PAGE_START);
    }

    private void addTextAreas() {
        JPanel textAreasPanel = new JPanel();
        textAreasPanel.setBorder(BorderFactory.createLineBorder(backgroundColor, 30));

        for (JTextArea textArea : textAreaContainer) {
            textArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true));
            textArea.setPreferredSize(textAreaSize);
            textArea.setEditable(false);
            textAreasPanel.add(textArea);
        }

        this.add(textAreasPanel, BorderLayout.CENTER);
    }

    private void addButton() {
        button = new JButton("Submit!");

        button.setPreferredSize(buttonSize);
        button.addActionListener(this);

        this.add(button, BorderLayout.SOUTH);
    }

    private void displayResults(Plan generatedPlan) {
        // take away the boxes
        for (JTextArea textArea : textAreaContainer) {textArea.setVisible(false);}

        JPanel resultsTextPanel = new JPanel();
        JTextPane week1 = new JTextPane();
        week1.setPreferredSize(new Dimension(300, 500));
        week1.setText("Week 1:\nDay 1:\n\tExercise 1:" + generatedPlan.getExercises(0, 0).get(0).getName() + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(0).getNumberOfReps(0) + " x " + generatedPlan.getExercises(0, 0).get(0).getWeight(0, 0) + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(0).getNumberOfReps(1) + " x " + generatedPlan.getExercises(0, 0).get(0).getWeight(1, 0) + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(0).getNumberOfReps(2) + " x " + generatedPlan.getExercises(0, 0).get(0).getWeight(2, 0) + "\n");
        week1.setText(week1.getText() + "\tExercise 2: " + generatedPlan.getExercises(0, 0).get(1).getName() + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(1).getNumberOfReps(0) + " x " + generatedPlan.getExercises(0, 0).get(1).getWeight(0, 0) + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(1).getNumberOfReps(1) + " x " + generatedPlan.getExercises(0, 0).get(1).getWeight(1, 0) + "\n");
        week1.setText(week1.getText() + generatedPlan.getExercises(0, 0).get(1).getNumberOfReps(2) + " x " + generatedPlan.getExercises(0, 0).get(1).getWeight(2, 0) + "\n");

        resultsTextPanel.add(week1);

        this.add(resultsTextPanel, BorderLayout.CENTER);
    }

    private boolean isNumeric() {
        for (JTextArea textArea : textAreaContainer) {
            for (int i = 0; i < textArea.getText().length(); i++) {

                char c = textArea.getText().charAt(i);

                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void makeTextAreasEditable() {
        for (JTextArea textArea : textAreaContainer) {
            textArea.setEditable(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("button pressed");
            switch ((String) workoutListDropDown.getSelectedItem()) {
                case "Wendell531":

                    if (isNumeric()) {

                        Wendell531 w531 = new Wendell531(Double.parseDouble(bodyWeightInput.getText()), Integer.parseInt(benchPressInput.getText()), Integer.parseInt(squatInput.getText()), Integer.parseInt(deadliftInput.getText()), Integer.parseInt(pressInput.getText()));
                        displayResults(w531);
                    }
                    System.out.println("531 selected");
            }
        }
    }
}