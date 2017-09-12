import java.util.Random;

// Rocket number 2
public class U2 extends Rocket {


    public U2() {
        cargoLimit = 11000; // 11000 kgs
        rocketCost = 120000000; // $120 million
    }

    // Calculate the chance of exploding on landing
    @Override
    public boolean land() {
        double chanceOfLandingCrash = 4 * (currentWeight / cargoLimit);
        int number = getNumber();

        // if the chance of a landing crash is equal to or greater than the number, then we've crashed
        return !(number <= chanceOfLandingCrash);
    }

    // Calculate the chance of exploding on launch
    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 8 * (currentWeight / cargoLimit);
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
