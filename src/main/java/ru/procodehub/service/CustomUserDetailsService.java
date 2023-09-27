package ru.procodehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.procodehub.models.User;
import ru.procodehub.repository.UserRepository;
import ru.procodehub.security.CustomUserDetails;

import java.util.Optional;

/**
 * Сервис, предоставляющий информацию о пользователе для Spring Security.
 * Реализует интерфейс UserDetailsService для аутентификации пользователей.
 * @author Антон
 */
@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Загружает информацию о пользователе по его имени пользователя (логину).
     *
     * @param username Имя пользователя (логин).
     * @return UserDetails объект, предоставляющий информацию о пользователе для аутентификации.
     * @throws UsernameNotFoundException если пользователь с указанным именем не найден.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw  new UsernameNotFoundException("Пользователь с таким именем не найден");
        }
        return new CustomUserDetails(user.get());
    }
}
