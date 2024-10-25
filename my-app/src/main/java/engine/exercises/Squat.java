package engine.exercises;

public class Squat extends Exercise {
    public Squat () {
        initialize();
    }

    private void initialize() {
        this.musclesHit = new String[]{"Glutes", "Quads", "Hamstrings", "Abductors", "Calves", "Abs"};
        this.name = "Barbell Squat";
    }
}
