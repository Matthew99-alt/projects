package matvey.petClinic;

import java.util.List;
import java.util.Objects;

abstract class Pet {
    private final int idNumber;
    private final String nickname;
    private final int age;
    private final String ownerName;
    private final String breed;
    private final List<String> color;

    public Pet(int idNumber, String nickname, int age, String ownerName, String breed, List<String> color) {
        this.idNumber = idNumber;
        this.nickname = nickname;
        this.age = age;
        this.ownerName = ownerName;
        this.breed = breed;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Pet comparablePet = (Pet) obj;
        if(!Objects.equals(this.idNumber, comparablePet.idNumber))
            return false;

        if (!Objects.equals(this.nickname, comparablePet.nickname))
            return false;

        if (this.age != (comparablePet.age))
            return false;

        if (!Objects.equals(this.ownerName, comparablePet.ownerName))
            return false;

        if (!Objects.equals(this.breed, comparablePet.breed))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * this.idNumber + this.nickname.length() +
                this.age + this.ownerName.length()
                + this.breed.length()
                ;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                ", breed='" + breed + '\'' +
                ", color=" + color +
                '}';
    }
}
