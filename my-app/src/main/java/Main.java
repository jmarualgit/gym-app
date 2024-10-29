import engine.exercises.Bench;
import engine.exercises.Deadlift;
import engine.exercises.Exercise;
import engine.exercises.Squat;
import engine.plans.Program;

public class Main {
    public static void main(String[] args) {
        Program myNewProgram = new Program();

        myNewProgram.addExercise(new Bench(), 3);
        myNewProgram.getExercises().get(0).initializeSets(5, 225);
        myNewProgram.addExercise(new Squat(), 3);
        myNewProgram.getExercises().get(1).initializeSets(5, 315);
        myNewProgram.addExercise(new Deadlift(), 4);
        myNewProgram.getExercises().get(2).initializeSets(5, 405);

        for (Exercise exercise : myNewProgram.getExercises()) {
            System.out.println(exercise.getName());
            exercise.printExercises();
        }
    }
}
