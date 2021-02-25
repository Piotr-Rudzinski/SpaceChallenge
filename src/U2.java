public class U2 extends Rocket {

    public U2 () {
        this.cost = 120;
        this.weight = 18;
        this.maxWeight = 29;
        this.maxCargoWeight = 11;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    /**
     * Method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
     * Chance of launch explosion = 5% * (cargo carried / cargo limit)
     *
     * @return - true = success, false = explosion
     */
    @Override
    public boolean launch() {
// Oblicza prawdopodobienstwo ekslozji zgodnie z zalacznym wzorem. Jesli wylosowana liczba znajdzie sie w przedziale
// prawdopodobienstwa explozji to zwraca false
        double randomNumber = Math.random() * 100;
        double launchExplosion = 4 * ((this.getMaxWeight() - this.getWeight() - this.getMaxCargoWeight()) / (this.getMaxWeight() - this.getWeight()));
        if (randomNumber <= launchExplosion) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method that returns either true or false indicating if the landing was successful or if the rocket has crashed.
     * Chance of landing crash = 1% * (cargo carried / cargo limit)
     *
     * @return - true = success, false = explosion
     */
    @Override
    public boolean land() {
// Oblicza prawdopodobienstwo eksplozji zgodnie z zalacznym wzorem. Jesli wylosowana liczba znajdzie sie w przedziale
// prawdopodobienstwa explozji to zwraca false
        double randomNumber = Math.random() *100;
        double landingExplosion = 8 * ((this.getMaxWeight() - this.getWeight() - this.getMaxCargoWeight()) / (this.getMaxWeight() - this.getWeight()));
        if (randomNumber <= landingExplosion) {
            return false;
        } else {
            return true;
        }
    }
}