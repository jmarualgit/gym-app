package engine.exercises;

import java.util.Arrays;

public class Exercise  {

    private int[][] sets;

    public void setNumberOfSets(int numOfSetsInput) {this.sets = new int[numOfSetsInput][];}

    public void setNumberOfReps(int numOfRepsInput, int setCount) {
        this.sets[setCount] = new int[numOfRepsInput];
    }

    public void setWeight(int setCount, int weightlbsInput) {
        Arrays.fill(this.sets[setCount], (5 * Math.round(weightlbsInput / 5)));
    }

    public int getNumberOfSets() {return this.sets.length;}

    public int getNumberOfReps(int setCount) {return this.sets[setCount].length;}

    public int getWeight(int setCount, int repCount) {return this.sets[setCount][repCount];}

    public void printExercises() {
        for (int set = 0; set < this.sets.length; set++) {
            System.out.println(this.sets[set].length + " x " + this.getWeight(set, 0));
        }
    };
}
