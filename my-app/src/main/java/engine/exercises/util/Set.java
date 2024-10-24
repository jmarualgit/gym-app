package engine.exercises.util;

public class Set {
    private int numberOfReps;
    private Rep[] repList;

    public Set (int numberOfRepsInput, double repWeight) {
        this.numberOfReps = numberOfRepsInput;

        initialize(repWeight);
    }

    private void initialize(double repWeightInput) {
        this.repList = new Rep[this.numberOfReps];

        for (int i = 0; i < this.numberOfReps; i++) {
            repList[i] = new Rep(repWeightInput);
        }
    }

    public void setNumberOfReps(int numberOfRepsInput) {this.numberOfReps = numberOfRepsInput;}

    public void setWeightOfReps(double repWeightInput) {
        for (int i = 0; i < this.numberOfReps; i++) {
            repList[i].setRepWeight(repWeightInput);
        }
    }

    public int getNumberOfReps() {return this.numberOfReps;}
    public Rep getRep() {return repList[0];}
}
