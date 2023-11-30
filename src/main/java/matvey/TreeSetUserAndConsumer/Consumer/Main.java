package matvey.TreeSetUserAndConsumer.Consumer;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Group aforika = new Group();
        Group anatomy = new Group();
        Group ferdinand = new Group();
        Group grunge = new Group();
        User anatolii = new User();
        User aleksey = new User();
        User levin = new User();

        aforika.setName("Афорика");
        aforika.setDescription("Группа афоризмов, подписывайся и учи афоризмы");
        anatomy.setName("Анатомия");
        anatomy.setDescription("Группа анатомии, длина кишок, количество костей и т.д.");
        ferdinand.setName("Фердинанд");
        ferdinand.setDescription("Фан-группа посвящённая британскому коллективу Franz Ferdinand");
        grunge.setName("Гранж");
        grunge.setDescription("Группа посвящённая музыкальному направлению в рок музыке");

        SomeConsumer someConsumer = new SomeConsumer();

        anatolii.setUsername("Анатолий");
        anatolii.setAge(18);
        anatolii.setGroups(Arrays.asList(aforika, anatomy, grunge));
        aleksey.setUsername("Алексей");
        aleksey.setAge(27);
        aleksey.setGroups(Arrays.asList(grunge, ferdinand));
        levin.setUsername("Левин");
        levin.setAge(23);
        levin.setGroups(Arrays.asList(ferdinand, anatomy, grunge));

        Stream<User> integerStream = Stream.of(anatolii, aleksey, levin);

        System.out.println(someConsumer.consumeExample(integerStream));

    }
}
