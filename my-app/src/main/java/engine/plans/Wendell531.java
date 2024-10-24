package engine.plans;

import java.util.ArrayList;
import java.util.Arrays;

import engine.exercises.*;

public class Wendell531 implements Plan {
    private final int AMOUNT_OF_WEEKS = 4;
    private final int WEEKLY_WORKOUT_FREQUENCY = 3;

    private double trainingMaxPercentage = 0.9;
    private int bench1RM, benchTM, squat1RM, squatTM, deadlift1RM, deadliftTM, ohp1RM, ohpTM;
    private int currentWeek = 1;

    public Wendell531 (double bodyWeightInput, int benchInput1RM, int squatInput1RM, int deadliftInput1RM, int ohpInput1RM) {

        // initializing
        this.bench1RM = benchInput1RM;
        this.benchTM = (int) Math.round(benchInput1RM * trainingMaxPercentage);

        this.squat1RM = squatInput1RM;
        this.squatTM = (int) Math.round(squatInput1RM * trainingMaxPercentage);

        this.deadlift1RM = deadliftInput1RM;
        this.deadliftTM = (int) Math.round(deadliftInput1RM * trainingMaxPercentage);

        this.ohp1RM = ohpInput1RM;
        this.ohpTM = (int) Math.round(ohpInput1RM * trainingMaxPercentage);
    }

    @Override
    public int getProgramTotalAmountOfWeeks() {return AMOUNT_OF_WEEKS;}

    @Override
    public int getWeeklyWorkoutFrequency() {return WEEKLY_WORKOUT_FREQUENCY;}

    @Override
    public int getWeeksLeft() {return this.currentWeek;}

    @Override
    public double getTrainingMaxPercentage() {return this.trainingMaxPercentage;}

    @Override
    public double getCurrentMax(String exercise, boolean isTrainingMax) {
        switch (exercise) {
            case "bench":
                if (isTrainingMax) {
                    return this.benchTM;
                }
                return this.bench1RM;
            case "squat":
                if (isTrainingMax) {
                    return this.squat1RM;
                }
                return this.squatTM;
            case "deadlift":
                if (isTrainingMax) {
                    return this.deadlift1RM;
                }
                return this.deadliftTM;
            case "ohp":
                if (isTrainingMax) {
                    return this.ohp1RM;
                }
                return this.ohpTM;
            default:
                return -1.0;
        }
    }

    @Override
    public void setTrainingMaxPercentage(int percent) {this.trainingMaxPercentage = percent;}

    @Override
    public void setBenchMax(int benchMaxInput) {this.bench1RM = benchMaxInput;}

    @Override
    public void setSquatMax(int squatMaxInput) {this.squat1RM = squatMaxInput;}

    @Override
    public void setDeadliftMax(int deadliftMaxInput) {this.deadlift1RM = deadliftMaxInput;}

    @Override
    public ArrayList<Exercise> getExercises(int dayNumber, int weekNumber) {
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

        Squat squat = new Squat();
        Bench bench = new Bench();
        Deadlift deadlift = new Deadlift();
        Press press = new Press();

        squat.setNumberOfSets(3);
        bench.setNumberOfSets(3);
        deadlift.setNumberOfSets(3);
        press.setNumberOfSets(3);

        /**/
        switch (dayNumber) {
            case 0:
                exerciseList.add(initializeExercise(squat, weekNumber, dayNumber, squatTM));
                exerciseList.add(initializeExercise(bench, weekNumber, dayNumber, benchTM));

                System.out.println("day 1: squat and bench!");

                System.out.println("squat!");
                squat.printExercises();

                System.out.println("bench!");
                bench.printExercises();
                
                break;
            case 1:
                exerciseList.add(initializeExercise(deadlift, weekNumber, dayNumber, deadliftTM));
                exerciseList.add(initializeExercise(press, weekNumber, dayNumber, ohpTM));

                System.out.println("deadlift!");
                deadlift.printExercises();

                System.out.println("press!");
                bench.printExercises();
                break;
            case 2:

                exerciseList.add(initializeExercise(bench, weekNumber, dayNumber, benchTM));
                exerciseList.add(initializeExercise(squat, weekNumber, dayNumber, squatTM));

                System.out.println("deadlift!");
                bench.printExercises();

                System.out.println("squat!");
                squat.printExercises();
                break;
                
        } 

        return exerciseList;
    }

    public Exercise initializeExercise(Exercise exercise, int WeekNumber, int dayNumber, int trainingMax) {

        switch (WeekNumber) {
            case 0:
                exercise.initializeSet(5, (int) (trainingMax * 0.65), 0);
                exercise.initializeSet(5, (int) (trainingMax * 0.75), 1);
                exercise.initializeSet(5, (int) (trainingMax * 0.85), 2);
                break;
            case 1:
                exercise.initializeSet(3, (int) (trainingMax * 0.70), 0);
                exercise.initializeSet(3, (int) (trainingMax * 0.80), 1);
                exercise.initializeSet(3, (int) (trainingMax * 0.90), 2);
                break;
            case 2:
                exercise.initializeSet(5, (int) (trainingMax * 0.75), 0);
                exercise.initializeSet(3, (int) (trainingMax * 0.85), 1);
                exercise.initializeSet(1, (int) (trainingMax * 0.95), 2);
                break;
        }

        return exercise;
    };

    @Override
    public ArrayList<String> getAssistanceWorkExercises(String bodyCategory) {
        ArrayList<String> exerciseList = new ArrayList<String>(); 

        switch (bodyCategory) {
            case "Push":
                String[] pushAccessory = new String[] {"Dips", "Pushups", "Dumbbell Press", "Tricep Extensions/Pushdowns"};
                exerciseList.addAll(Arrays.asList(pushAccessory));
                break;
            case "Pull":
                String[] pullAccessory = new String[] {"Chin-Ups/Pull-Ups", "Rows", "Curls", "Lat Pulldowns", "Face Pulls", "Upright Row", "Shrugs"};
                exerciseList.addAll(Arrays.asList(pullAccessory));
                break; 
            case "Core":
            case "Leg":
                String[] coreLegAccessory = new String[] {"Glute Ham Raise", "Ab Work", "Single Leg Movements", "Farmer Walks", "Straight Leg Deadlift"};
                exerciseList.addAll(Arrays.asList(coreLegAccessory));
                break;
        }

        return exerciseList;
    }
}