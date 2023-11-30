package matvey.TreeSetUserAndConsumer.TreeSet;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/*
Написать свой пример, класса и созданного
из него объектов, добавления в TreeSet<>
Имплементировать Comparable, реализовать CompareTo
*/
public class Main {
    public static void main(String[] args) {
        Guitars lespaul = new Guitars("Hammbacker", 6, "Gibson", "LesPaul", 150000);
        Guitars squire = new Guitars("Single", 6, "Fender", "Telecaster", 122000);
        Guitars kingV = new Guitars("Hammbacker", 6, "Jackson", "King V", 160000);
        Guitars prestige = new Guitars("Hammbacker", 7, "Ibanez", "Prestige", 160000);

        Set<Guitars> guitarShop = new TreeSet<>(Arrays.asList(lespaul, squire, kingV, prestige));
        System.out.println(guitarShop);
    }
}
