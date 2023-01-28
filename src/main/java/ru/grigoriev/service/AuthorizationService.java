package ru.grigoriev.service;

import org.springframework.stereotype.Service;
import ru.grigoriev.exception.UnauthorizedUser;
import ru.grigoriev.model.Authorities;
import ru.grigoriev.model.User;
import ru.grigoriev.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
