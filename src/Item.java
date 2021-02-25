public class Item {

    private String name;
    private int weight;

    public Item () {

    }

    public Item (String itemName, int itemWeightInt) {
    this.name = itemName;
    this.weight = itemWeightInt;
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int setWeight(int weight) {
        this.weight = weight;
        return weight;
    }

}
