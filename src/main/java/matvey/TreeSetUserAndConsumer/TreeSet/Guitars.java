package matvey.TreeSetUserAndConsumer.TreeSet;

import lombok.ToString;
import org.jetbrains.annotations.NotNull;

//класс электрогитар
@ToString
public class Guitars implements Comparable<Guitars> {
    //звукосниматели электрогитары
    String pickups;
    Integer strings;
    String developer;
    String model;
    Integer price;

    public Guitars(String pickups, Integer strings, String developer, String model, Integer price) {
        this.pickups = pickups;
        this.strings = strings;
        this.developer = developer;
        this.model = model;
        this.price = price;
    }

    @Override
    public int compareTo(@NotNull Guitars o) {
        //сравниваем цены
        int result = this.price.compareTo(o.price);
        //если цены одинаковые
        if (result == 0) {
            //сравниваем количество струн
            if (this.strings.compareTo(o.strings) == 0) {
                //Если количество струн одинаковое, то
                //сортируем в алфавитном порядке
                return this.model.compareTo(o.model);
            } else {
                return this.strings.compareTo(o.strings);
            }
        } else {
            return result;
        }
    }
}
