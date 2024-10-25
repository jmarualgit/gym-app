package engine.exercises;

public class Press extends Exercise {
    public Press () {
        initialize();
    }

    private void initialize() {
        this.musclesHit = new String[]{"Delts", "Tricep", "Traps"};
        this.name = "Overhead Press";
    }
}
