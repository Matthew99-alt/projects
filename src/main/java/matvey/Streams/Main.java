package matvey.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student styopa = new Student("Стёпа", Arrays.asList("археология","музыка"));
        Student arkadii = new Student("Аркадий", Arrays.asList("экономика","археология","музыка"));
        Student genadii = new Student("Генадий", Collections.singletonList("психология"));
        Student evgenii = new Student("Евгений", Arrays.asList("программирование","археология","музыка","экономика"));
        Student sergay = new Student("Сергей", Collections.singletonList("музыка"));

        List<Student> Student = Arrays.asList(styopa,arkadii,genadii,evgenii,sergay);

        Streams strimchik = new Streams();
        strimchik.curiosStudents(Student);
    }
}
