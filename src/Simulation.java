import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for reading item data and filling up the rockets
 */
public class Simulation {

    private ArrayList<Item> loadingList;


    // TODO: create a loadItems method which loads all items from a text file and returns an ArrayList of Items. Each
    // line in the text file consists of the item name followed by '=' then the item's weight in kg. The method should
    // read the text file line by line and create an Item object for each and then add it to an ArrayList of items. The
    // method should then return that ArrayList.
    public void loadItems(Scanner scanner) throws FileNotFoundException{

        loadingList = new ArrayList<>();
            // while there are unread lines in the list
            while (scanner.hasNextLine()) {

                // split each line at the '='
                String lineString = scanner.nextLine();
                String[] listItems = lineString.split("=");
                Item item = new Item(listItems[0], Integer.parseInt(listItems[1]));
                loadingList.add(item);

            }
            scanner.close();

    }

    // create a loadU1 method which takes the ArrayList of items returned from loadItems and starts creating U1
    // rockets. It first tries to fill up 1 rocket with as many items as possible before created a new rocket object and
    // filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are
    // fully loaded.
    public void loadU1Fleet(Scanner scanner) {
        // create a new ArrayList of U1 rockets
        ArrayList<Rocket> rocketFleetU1 = new ArrayList<>();

        // create a new U1 rocket to go into the fleet
        Rocket u1 = createU1Rocket();

        // number of rockets in fleet
        int rocketNumber = 0;

        // go through the loadingList array
        for (Item aLoadingList : loadingList) {

            // if the rocket can't carry the item (because it has reached its cargo weight limit), we add the rocket to
            // the fleet array, create a new rocket, and start loading it.
            if (!u1.canCarry(aLoadingList)) {
                rocketFleetU1.add(u1);
                u1 = createU1Rocket();
                rocketNumber++;

            }
                u1.carry(aLoadingList);

        }

        rocketFleetU1.add(u1);
        rocketNumber++;

        // Launch U1 fleet
        System.out.println("Launching U1 Fleet with " + rocketNumber + " rockets");
        runSimulation(rocketFleetU1);

    }

    // create a loadU2 method which takes the ArrayList of Items and starts creating U2 rockets and filling them
    // with those items the same way as with U1 until all items are loaded. The method then returns the ArrayList of
    // those U2 rockets that are fully loaded
    public void loadU2Fleet(Scanner scanner){
        // create a new ArrayList of U2 rockets
        ArrayList<Rocket> rocketFleetU2 = new ArrayList<>();

        // create a new U2 rocket to go into the fleet
        Rocket u2 = createU2Rocket();

        // number of rockets in fleet
        int rocketNumber = 0;

        // go through the loadingList array
        for (Item aLoadingList : loadingList) {

            // if the rocket can't carry the item (because it has reached its cargo weight limit), we add the rocket to
            // the fleet array, create a new rocket, and start loading it.
            if (!u2.canCarry(aLoadingList)) {
                rocketFleetU2.add(u2);
                u2 = createU2Rocket();
                rocketNumber++;
            }
            u2.carry(aLoadingList);

        }
        // add the last rocket to the fleet
        rocketFleetU2.add(u2);
        rocketNumber++;

        // Launch U1 fleet
        System.out.println("Launching U2 Fleet with " + rocketNumber + " rockets");
        runSimulation(rocketFleetU2);

    }

    // create a runSimulation method which takes an ArrayList of Rockets and calls launch() and land() for each of
    // the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e. if launch() or land() return false)
    // it will have to send that rocket again. The total budget required to send each rocket safely to Mars should also
    // be kept track of here. The method then returns the total budget required to send all rockets (including the ones
    // that crashed).
    private int runSimulation(ArrayList<Rocket> rockets){
        int budget = 0;
        int rocketNumber = 0;

        // go through the array of rockets
        for (Rocket aRocket: rockets) {
            budget = budget + aRocket.rocketCost;
            System.out.println("Current budget is: " + budget);
            // if the rocket crashes when it launches or when it lands, send rocket again
            if (!aRocket.launch()){
                budget = budget + aRocket.rocketCost;
                System.out.println("Rocket launch " + rocketNumber + " failed." + " Current budget is: " + budget
                        + " Relaunching rocket.");
                aRocket.launch();
            }else if (!aRocket.land()){
                budget = budget + aRocket.rocketCost;
                System.out.println("Rocket " + rocketNumber + " crashed on landing." + " Current budget is: " + budget
                        + " Relaunching rocket.");
                aRocket.launch();
            }

            rocketNumber++;
            System.out.println("Rocket " + rocketNumber + " arrived safely");

        }

        System.out.println("Total fleet budget = " + budget);
        return budget;
    }

    @NotNull
    private Rocket createU2Rocket() {
        return new U2();
    }

    @NotNull
    private Rocket createU1Rocket(){
        return new U1();
    }
}
