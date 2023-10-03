package matvey.petClinic;

import java.util.List;

public class Dog extends Pet{
    public Dog(int idNumber, String nickname, int age, String ownerName, String breed, List<String> color) {
        super(idNumber, nickname, age, ownerName, breed, color);
    }
}
