package matvey.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Words {

    private final ArrayList<String> words = new ArrayList<>(Arrays.asList("fragile", "reptile",
            "only", "copy", "sunspots", "fragile", "reptile", "only", "copy", "sunspots", "fragile",
            "reptile", "fragile", "reptile", "fragile", "hurt", "mr.self-distruct", "closer",
            "piggy", "heresy"));

    public void massCheckSet() {
        HashSet<String> uniqWords = new HashSet<>(words);
        //выводим их
        for (String uniqWord : uniqWords) {
            System.out.println(uniqWord);
        }

        //считаем количество повторений
        for (String uniqWord : uniqWords) {
            System.out.println("Слово " + uniqWord + " встречается " +
                    Collections.frequency(words, uniqWord) + " раз.");
        }
    }
}
