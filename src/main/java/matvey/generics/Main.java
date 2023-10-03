package matvey.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        //создаём объекты для ящика
        Apple freshApp = new Apple(1.5f);
        Orange freshOr = new Orange(1.0f);

        //присваеваем ящикам их вес и загружаем фрукты
        Box<Apple> appleBox = new Box<>(2f, new ArrayList<>(Arrays.asList(freshApp, freshApp)));
        Box<Orange> orangeBox = new Box<>(2f, new ArrayList<>(Arrays.asList(freshOr, freshOr, freshOr)));

        //сверяем в первый раз
        System.out.println("orangeBox compare appleBox " + orangeBox.compare(appleBox.getWeight()));

        Box<Apple> anotherBox = new Box<>(2f, new ArrayList<>());

            appleBox.fruitsReplace(anotherBox);
            orangeBox.addFruits(freshOr, freshOr, freshOr);
            anotherBox.addFruits(freshApp, freshApp);


        //проверяем изменился ли вес у коробки из которой мы перекинули фрукты
        //и у остальных коробок
        System.out.println("orangeBox compare appleBox " + orangeBox.compare(appleBox.getWeight()));
        System.out.println("anotherBox compare orangeBox " + anotherBox.compare(orangeBox.getWeight()));
    }
}