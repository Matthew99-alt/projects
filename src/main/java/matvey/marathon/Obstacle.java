package matvey.marathon;

public class Obstacle {

    //сложность препятствия
    private final int difficulty;

    private final String name;

    //конструктор класса obstacle (название препятсвия и его сложность)
    public Obstacle(String name, int difficulty) {
        this.difficulty = difficulty;
        this.name = name;
    }

    //getter используемые в программе для получения необходимых данных
    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
