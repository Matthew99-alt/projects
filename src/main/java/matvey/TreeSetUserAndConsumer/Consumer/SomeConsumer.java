package matvey.TreeSetUserAndConsumer.Consumer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SomeConsumer {
/*
пользователь и группы, нужно вернуть список пользователей у которых есть
хотя бы 1 группа, имя которой начинается с большой буквы А
*/

    // Return list of users with any group starting with "A"
    public List<User> consume(Stream<User> usersStream) {
        return usersStream.filter(s -> s.getGroups().stream()
                        .anyMatch(g -> g.getName().startsWith("А")))
                .collect(Collectors.toList());
    }
}
