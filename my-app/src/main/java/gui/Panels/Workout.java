package gui.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import engine.plans.Plan;
import engine.plans.Wendell531;

public class Workout extends JPanel {

    private Color backgroundColor = new Color(237, 237, 233);
    private Dimension textAreaSize = new Dimension(200, 50);
    private Dimension workoutPanelSize = new Dimension(800, 500);
    private Dimension workoutInnerTabSize = new Dimension(200, 50);

    private JButton button;
    public Workout () {
        initialize();
    }

    private void initialize() {
        this.setBackground(backgroundColor);
        this.setLayout(new BorderLayout(0,75));
        createPanes();
    }
    
    private void createPanes() {
        JTabbedPane workoutPanes = new JTabbedPane(JTabbedPane.LEFT);
        
        workoutPanes.addTab("Welcome!", new welcome());
        workoutPanes.addTab("Wendell 531!", new w531());

        JLabel welcomeLabel = new JLabel("Welcome!");
        JLabel w531Label = new JLabel("Wendell 531!!");

        welcomeLabel.setPreferredSize(workoutInnerTabSize);
        w531Label.setPreferredSize(workoutInnerTabSize);

        workoutPanes.setTabComponentAt(0, welcomeLabel);
        workoutPanes.setTabComponentAt(1, w531Label);

        this.add(workoutPanes, BorderLayout.LINE_START);
    }

    private class w531 extends JPanel implements ActionListener {
        private JTextArea bodyWeightInput = new JTextArea("Enter bodyweight in LBS");
        private JTextArea benchPressInput = new JTextArea("Enter bench press 1RM in LBS");
        private JTextArea squatInput = new JTextArea("Enter squat 1RM in LBS");
        private JTextArea deadliftInput = new JTextArea("Enter deadlift 1RM in LBS");
        private JTextArea pressInput = new JTextArea("Enter press 1RM in LBS");
        private JTextArea weekNumberInput = new JTextArea("Enter the week date!");
        private JTextArea[] textAreaContainer = {bodyWeightInput, benchPressInput, squatInput, deadliftInput, pressInput, weekNumberInput};
        private JTextArea resultArea;
        private JPanel resultsPanel;
        private Plan plan;

        public w531 () {
            this.setPreferredSize(workoutPanelSize);
            this.setLayout(new BorderLayout());
            //this.setBackground(new Color(0, 0, 0));
            
            addTextAreas();
            addResultsArea();
            makeTextAreasEditable();
            addButton();
        }

        private void addTextAreas() {
            JPanel textAreasPanel = new JPanel(new GridLayout(7, 1, 0, 30));
            textAreasPanel.setBorder(BorderFactory.createLineBorder(backgroundColor, 30));
            //textAreasPanel.setBackground(new Color(0, 0, 0));
    
            for (JTextArea textArea : textAreaContainer) {
                textArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true));
                textArea.setPreferredSize(textAreaSize);
                textArea.setEditable(false);
                textAreasPanel.add(textArea);
            }
    
            this.add(textAreasPanel, BorderLayout.LINE_START);
        }

        private void addResultsArea() {
            resultsPanel = new JPanel();
            //resultsPanel.setBackground(new Color(100, 100, 100));

            resultArea = new JTextArea("Results!\n");
            //resultsPanel.setBackground(new Color(0, 0, 0));
            resultsPanel.add(resultArea);

            this.add(resultsPanel, BorderLayout.CENTER);
        }

        private void makeTextAreasEditable() {
            for (JTextArea textArea : textAreaContainer) {
                textArea.setEditable(true);
            }
        }

        private void addButton() {
            button = new JButton("Submit!");
    
            button.addActionListener(this);
    
            this.add(button, BorderLayout.PAGE_END);
        }

        private void displayResults(int weekNumber) {
            String textToSet = "";

            for (int dayNumber = 0; dayNumber < this.plan.getWeeklyWorkoutFrequency(); dayNumber++) {
    
                textToSet = textToSet + ("Day " + (dayNumber + 1) + ":\n");

                for (int exerciseNumber = 0; exerciseNumber < this.plan.getExercises(dayNumber, weekNumber).size(); exerciseNumber++) {
                    String exerciseName = this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getName();
                    textToSet = textToSet + (exerciseName + "\n");

                    System.out.println("exerciseName " + this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getName());
                    System.out.println("text to set: " + textToSet);
                    
                    for (int setNumber = 0; setNumber < this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getNumberOfSets(); setNumber++) {
                        System.out.println("TEST: " + this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getNumberOfReps(setNumber));
                        textToSet = textToSet + (this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getNumberOfReps(setNumber) + " x " + this.plan.getExercises(dayNumber, weekNumber).get(exerciseNumber).getWeight(setNumber, 0)) + "\n";
                        System.out.println("text to set: " + textToSet);
                        //System.out.println("set#" + (setNumber + 1));
                    }
                }
            }

            resultArea.setText(resultArea.getText() + textToSet);
            resultArea.setEditable(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                for (JTextArea textArea : textAreaContainer) {textArea.setEditable(false);}
                this.plan = new Wendell531(Double.parseDouble(bodyWeightInput.getText()), Integer.parseInt(benchPressInput.getText()), Integer.parseInt(squatInput.getText()), Integer.parseInt(deadliftInput.getText()), Integer.parseInt(pressInput.getText()));
                System.out.println("button pressed");
                //resultArea.setText("sawehhiuefawsihuefasihuasefiuh");
                displayResults(Integer.parseInt(weekNumberInput.getText()) - 1);
            }
        }
    }

    private class welcome extends JPanel {
        public welcome () {
            this.setPreferredSize(workoutPanelSize);
            this.setBackground(new Color(0, 0, 0));
        }
    }
}