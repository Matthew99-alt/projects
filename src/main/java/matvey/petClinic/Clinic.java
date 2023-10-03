package matvey.petClinic;

import java.util.HashSet;

public class Clinic {

    private final HashSet<Pet> animals;

    public Clinic(HashSet<Pet> animals) {
        this.animals = animals;
    }

    public boolean addAnimal(Pet pet) {
        animals.add(pet);
        return true;
    }

    public void printAnimals() {
        System.out.println("Всего животных на текущий момент в клинике: " + animals.size());
        System.out.println(animals);
    }
}
