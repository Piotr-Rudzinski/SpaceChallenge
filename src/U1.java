import java.util.ArrayList;

public class U1 extends Rocket{

    public U1 () {
        this.cost = 100;
        this.weight = 10;
        this.maxWeight = 18;
        this.maxCargoWeight = 8;
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
        double launchExplosion = 5 * ((this.getMaxWeight() - this.getWeight() - this.getMaxCargoWeight()) / (this.getMaxWeight() - this.getWeight()));
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
        double landingExplosion = 1 * ((this.getMaxWeight() - this.getWeight() - this.getMaxCargoWeight()) / (this.getMaxWeight() - this.getWeight()));
        if (randomNumber <= landingExplosion) {
            return false;
        } else {
            return true;
        }
    }
}
