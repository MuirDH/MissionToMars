import java.util.Random;

// Rocket number 1
public class U1 extends Rocket {


    public U1() {
        cargoLimit = 8000; // kgs (8 tonnes)
        rocketCost = 100000000; // $100 million
    }

    // Calculate the chance of exploding on landing
    @Override
    public boolean land() {
        double chanceOfLandingCrash = (currentWeight / cargoLimit);
        int number = getNumber();

        // if the chance of a landing crash is equal to or greater than the number, then we've crashed
        return !(number <= chanceOfLandingCrash);
    }

    // Calculate the chance of exploding on launch
    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 5 * (currentWeight / cargoLimit);
        int number = getNumber();

        // if the chance of a launch crash is equal to or greater than the number, then we've crashed
        return !(number <= chanceOfLaunchExplosion);
    }

    private int getNumber() {
        // Create a random number
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
