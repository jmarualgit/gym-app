package engine.plans;

import java.util.ArrayList;

import engine.exercises.Exercise;

public class Program {
    private int amountOfWeeks;
    private int trainingFrequency;          // amount of days a week to train
    private int trainingMaxPercentage;
    private ArrayList<Exercise> listOfExercises = new ArrayList<Exercise>();

    public void addExercise(Exercise exerciseToAdd, int numberOfSetsInput) {
        exerciseToAdd.setNumberOfSets(numberOfSetsInput);
        this.listOfExercises.add(exerciseToAdd);
    }

    public ArrayList<Exercise> getExercises() {return this.listOfExercises;}
    public int getAmountOfWeeks() {return this.amountOfWeeks;}
    public int getTrainingFrequency() {return this.trainingFrequency;}
    public int getTrainingMaxPercentage() {return this.trainingMaxPercentage;}

    public void addExercise(Exercise exerciseToAdd) {this.listOfExercises.add(exerciseToAdd);}
    public void setAmountOfWeeks(int amtOfWeeksInput) {this.amountOfWeeks = amtOfWeeksInput;}
    public void setTrainingFrequency(int trainingFreqInput) {this.trainingFrequency = trainingFreqInput;}
    public void setTrainingMaxPercentage(int trainingMaxPercentInput) {this.trainingMaxPercentage = trainingMaxPercentInput;}
}