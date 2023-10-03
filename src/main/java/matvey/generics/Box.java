package matvey.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    //за каждой коробкой закрепляется вес
    private final float weight;

    private final ArrayList<T> fruits;

    public Box(float weight, ArrayList<T> fruits) {
        this.weight = weight;
        this.fruits = fruits;
    }

    //методы
    public boolean compare(float anotherBox) {
        return this.getWeight() == anotherBox;
    }

    //getter'ы, setter'ы
    public float getWeight() {
        float fruitsWeight = 0;
        for (T fruit : this.fruits) {
            fruitsWeight += fruit.getFruitWeight();
        }
        return this.weight + fruitsWeight;
    }

    public void fruitsReplace(Box<T> newBox) {
        //проверяем пуста ли хотя бы одна коробка
        //если одна из коробок пуста просто перекидываем фрукты
        this.fruits.clear();
        newBox.fruits.addAll(this.fruits);
    }

    @SafeVarargs
    public final void addFruits(T... stuff) {
        this.fruits.addAll(Arrays.asList(stuff));
    }
}
