package matvey.generics;

abstract class Fruit {
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getFruitWeight() {
        return weight;
    }
}
