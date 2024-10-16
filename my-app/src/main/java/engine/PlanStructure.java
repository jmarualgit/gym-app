package engine;

import engine.plans.Wendell531;

public class PlanStructure {
    private double bodyWeight;

    public PlanStructure () {}

    public void initialize(double bodyWeightInput, int benchMaxInput, int squatMaxInput, int deadliftMaxInput, int ohpMaxInput) {
        this.bodyWeight = bodyWeightInput;

        Wendell531 W531 = new Wendell531(this.bodyWeight, benchMaxInput, squatMaxInput, deadliftMaxInput, ohpMaxInput);

        System.out.println("week 1!");
        W531.getExercises(0, 0);

        System.out.println("week 2!");
        W531.getExercises(0, 1);

        System.out.println("week 3!");
        W531.getExercises(0, 2);
    }
}
