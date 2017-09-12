


public class Rocket implements SpaceShip {

    int currentWeight;
    int cargoLimit;
    int rocketCost;

    /**
     * Can the rocket launch
     *
     * @return true or false
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Can the rocket land
     *
     * @return true or false
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Updates the current weight carried by the rocket
     *
     * @param item item being loaded
     * @return current weight being carried
     */
    @Override
    public int carry(Item item) {
        currentWeight = item.weight + currentWeight;
        return currentWeight;
    }

    @Override
    public boolean canCarry(Item item) {
        // if currentWeight < cargoLimit for the rocket, then return true else return false
        int testWeight = currentWeight + item.weight;
        return testWeight <= cargoLimit;

    }

}
