package engine.exercises;

public class Deadlift extends Exercise {
    public Deadlift () {
        initialize();
    }

    private void initialize() {
        this.musclesHit = new String[]{"Glutes", "Hamstrings", "Abs", "Lats", "Traps", "Forearms"};
        this.name = "Deadlift";
    }
}
