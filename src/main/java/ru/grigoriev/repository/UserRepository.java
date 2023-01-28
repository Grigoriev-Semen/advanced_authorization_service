package ru.grigoriev.repository;

import org.springframework.web.bind.annotation.RestController;
import ru.grigoriev.model.Authorities;
import ru.grigoriev.model.User;

import java.util.List;

@RestController
public class UserRepository {
    private final List<User> users = List.of(new User("Pety", "qwerty", List.of(Authorities.READ, Authorities.DELETE)),
            new User("Bob", "1234", List.of(Authorities.READ, Authorities.WRITE)),
            new User("Anna", "2010", List.of(Authorities.READ, Authorities.WRITE)));

    public List<Authorities> getUserAuthorities(String user, String password) {
        return users.stream()
                .filter(user1 -> user1.getUser().equals(user) && user1.getPassword().equals(password))
                .map(User::getAuthorities)
                .findFirst()
                .orElse(null);
    }
}
