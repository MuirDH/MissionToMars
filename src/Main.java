import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A program which simulates rocket testing. The goal is to figure out which of two rockets is best to use.
 * <p>
 * The "mission" consists of 2 phases.
 * <p>
 * Phase 1 sends building equipment and construction material to help build the colony.
 * <p>
 * Phase 2 sends the colony of humans along with some extra food resources.
 */

public class Main {

    public static void main(String[] args) {

        // Create a Simulation Object
        Simulation simulation = new Simulation();

        // scan Phase One Text
        Scanner phaseOne = null;
        try {
            phaseOne = new Scanner(new File("phase1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load item list for Phase One
        try {
            simulation.loadItems(phaseOne);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create and load U1 rockets for Phase 1
        System.out.println("U1 Phase One Launch");
        simulation.loadU1Fleet(phaseOne);

        // Create and load U2 rockets for Phase 1
        System.out.println("U2 Phase One Launch");
        simulation.loadU2Fleet(phaseOne);

       // Scan Phase Two text
         Scanner phaseTwo = null;
        try {
            phaseTwo = new Scanner(new File("phase2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load item list for Phase Two
        try {
            simulation.loadItems(phaseTwo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create and load U1 rockets for Phase 2
        System.out.println("U1 Phase Two Launch");
        simulation.loadU1Fleet(phaseTwo);

        // Create and load U2 rockets for Phase 2
        System.out.println("U2 Phase Two Launch");
        simulation.loadU2Fleet(phaseTwo);

        // TODO: (optional) Display which rocket would be better for Phase1 based on cost and for Phase2 based on
        // loss of life
    }
}
