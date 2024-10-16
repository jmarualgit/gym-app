package engine.plans;

import java.util.ArrayList;
import java.util.List;

import engine.exercises.Exercise;

public interface Plan {

    // getters for general program
    public int getProgramTotalAmountOfWeeks();
    public int getWeeklyWorkoutFrequency();
    public int getWeeksLeft();

    // getters for maxes
    public double getTrainingMaxPercentage();
    public double getCurrentMax(String exercise, boolean isTrainingMax);

    // setters for maxes
    public void setTrainingMaxPercentage(int percent);
    public void setBenchMax(int benchMaxInput);
    public void setSquatMax(int squatMaxInput);
    public void setDeadliftMax(int deadliftMaxInput);

    // get the exercises of specific day
    public ArrayList<Exercise> getExercises(int dayNumber, int weekNumber);

    public Exercise initializeExercise(Exercise exercise, int weekNumber, int dayNumber, int trainingMax);

    // get list of exercises of assistance work depending on what body part
    public List<String> getAssistanceWorkExercises(String bodyCategory);
}
