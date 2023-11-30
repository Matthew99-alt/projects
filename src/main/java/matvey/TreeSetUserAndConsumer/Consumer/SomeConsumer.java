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
        return usersStream.filter(user -> user.getGroups().stream()
                        .anyMatch(group -> group.getName().startsWith("А")))
                .toList(); // а так уже в 17 java
    }

    public List<User> consumeExample(Stream<User> usersStream) {
        return usersStream
                .filter(this::containsGroupWithA)
                .collect(Collectors.toList()); // так было еще в 11 java
    }

    private boolean containsGroupWithA(User user) {
        List<Group> groups = user.getGroups();
        return !groups.isEmpty()
                && groups.stream().anyMatch(g -> g.getName().startsWith("А"));
    }
}
