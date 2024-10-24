package engine.exercises;

import engine.exercises.util.Set;

public class Exercise {

    private Set[] setList;

    public void setNumberOfSets(int numOfSetsInput) {this.setList = new Set[numOfSetsInput];}

    public void initializeSets(int numOfRepsInput, double weightlbsInput) {
        for (int i = 0; i < this.setList.length; i++) {
            this.setList[i] = new Set(numOfRepsInput, 5 * Math.round(weightlbsInput / 5.0));
        }
    }

    public void initializeSet(int numOfRepsInput, double weightlbsInput, int setCount) {
        this.setList[setCount] = new Set(numOfRepsInput, 5 * Math.round(weightlbsInput / 5.0));
    }

    public void setNumberOfReps(int numOfRepsInput, int setCount) {this.setList[setCount].setNumberOfReps(numOfRepsInput);}

    public void setWeight(int setCount, double weightlbsInput) {
        this.setList[setCount].setWeightOfReps(5 * Math.round(weightlbsInput / 5.0));
    }

    public int getNumberOfSets() {return this.setList.length;}

    public int getNumberOfReps(int setCount) {return this.setList[setCount].getNumberOfReps();}

    public double getWeight(int setCount, int repCount) {return this.setList[setCount].getRep().getRepWeight();}

    public void printExercises() {
        for (int set = 0; set < this.setList.length; set++) {
            System.out.println(this.setList[set].getNumberOfReps() + " x " + (int) (this.getWeight(set, 0)));
        }
    };
}
