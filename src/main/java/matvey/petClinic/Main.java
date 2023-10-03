package matvey.petClinic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cat bars = new Cat(110999,"Барс", 7, "Степан", "Бенгальская", Arrays.asList("Белый", "Коричневый"));
        Cat masya = new Cat(222022,"Мася", 3, "Генадий", "Ориентальная", List.of("Серый"));
        Cat chernysh = new Cat(221100,"Черныш", 4, "Алексей", "Манчкин", Arrays.asList("Коричневый", "Белый"));

        Dog loshkin = new Dog(323578,"Лошкин", 4, "Григорий", "Доберман", Arrays.asList("Чёрный", "Коричневый"));
        Dog loshkin_1 = new Dog(678535,"Лошкин", 4, "Григорий", "Доберман", Arrays.asList("Чёрный", "Коричневый"));
        Dog rishik = new Dog(777832,"Рыжик", 1, "Эля", "Чау-чау", Arrays.asList("Золотистый", "Белый"));
        Dog manya = new Dog(674224,"Маня", 1, "Павел", "Корги", List.of("Чёрный"));
        Dog spike = new Dog(743384,"Спайк", 5, "Матвей", "Шарлей", Arrays.asList("Чёрный", "Коричневый", "Белый"));
        Dog doggie = new Dog(896435,"Догги", 5, "Сергей", "Гарлон", Arrays.asList("Камель", "Фиолетовый", "Серый"));
        Dog chensey = new Dog(743284,"Ченси", 1, "Анастасия", "Лала", Arrays.asList("Серый", "Бурый"));


        Clinic petClinic = new Clinic(new HashSet<>(Arrays.asList(bars,
                masya, chernysh, loshkin, rishik, manya, spike)));


        System.out.println(petClinic.addAnimal(spike));
        System.out.println(petClinic.addAnimal(doggie));
        System.out.println(petClinic.addAnimal(loshkin));
        System.out.println(petClinic.addAnimal(loshkin_1));
        System.out.println(petClinic.addAnimal(chensey));

        petClinic.printAnimals();
    }
}
