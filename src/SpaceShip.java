

public interface SpaceShip {

    // Returns either true or false indicating if the launch was successful or if the rocket has crashed
    boolean launch();

    // Returns true or false based on the success of the landing
    boolean land();

    // Returns true if the rocket can carry the item or false if it will exceed the weight limit
    boolean canCarry(Item item);

    // Updates the current weight of the rocket
    int carry(Item item);

}
