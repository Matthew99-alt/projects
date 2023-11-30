package matvey.TreeSetUserAndConsumer.TreeSet;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

//класс электрогитар
@RequiredArgsConstructor
@ToString
public class Guitars implements Comparable<Guitars> {
    //звукосниматели электрогитары
    private final String pickups;
    private final Integer stringsCount;
    private final String developer;
    private final String model;
    private final Integer price;

    @Override
    public int compareTo(@NotNull Guitars comparableObject) {
        //сравниваем цены
        int result = this.price.compareTo(comparableObject.price);
        if (result != 0)
            return result;

        //сравниваем количество струн, если цены одинаковые
        int resultStringCount = this.stringsCount.compareTo(comparableObject.stringsCount);
        if (resultStringCount != 0)
            return resultStringCount;

        //сравниваем по алфавиту, если по струнам и цене не удалось сравнить
        return this.model.compareTo(comparableObject.model);
    }


//    @Override
    public int compareTo__(@NotNull Guitars comparableObject) {
        //сравниваем цены
        int result = this.price.compareTo(comparableObject.price);
        //если цены одинаковые
        if (result == 0) {
            //сравниваем количество струн
            int resultStringCount = this.stringsCount.compareTo(comparableObject.stringsCount);
            if (resultStringCount == 0) {
                //Если количество струн одинаковое, то
                //сортируем в алфавитном порядке
                return this.model.compareTo(comparableObject.model);
            } else {
                return resultStringCount;
            }
        } else {
            return result;
        }
    }
}
