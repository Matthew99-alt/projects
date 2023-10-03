package matvey.petClinic;

import java.util.List;

public class Cat extends Pet {
    public Cat(int idNumber, String nickname, int age, String ownerName, String breed, List<String> color) {
        super(idNumber, nickname, age, ownerName, breed, color);
    }
}
