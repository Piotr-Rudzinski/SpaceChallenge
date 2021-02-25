public class Rocket implements SpaceShip {
// Rocket cost
    int  cost;
// Rocket weight
    int  weight;
// Max weight (with cargo)
    int  maxWeight;
// Cargo weight
    int  maxCargoWeight;

    public Rocket() {

    }

    /**
     * Method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
     *
     * @return
     */
    public boolean launch() {
       return true;
    }

    /**
     * Method that returns either true or false based on the success of the landing.
     *
     * @return boolean
     */
    public boolean land() {
        return true;
    }

    /**
     * Method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
     *
     * @param item - item to be load
     * @return boolean -
     */
    public boolean canCarry(Item item) {
        if (weight + item.getWeight() <= maxWeight) {
            return true;}
        else {
            return false;
        }
    }

    /**
     * Method that takes an Item object and updates the current weight of the rocket.
     *
     * @param item - item to be load
     * @return weight - weight of the rocket
     */
    public int carry(Item item) {
        weight = weight + item.getWeight();
        return weight;
    }

    public int getWeight() {
        return this.weight;
    }
}
