package ru.procodehub.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.procodehub.models.User;

import java.util.Collection;
import java.util.Collections;

/**
 * Класс `CustomUserDetails` представляет объект, содержащий информацию о пользователе,
 * необходимую для аутентификации и авторизации с использованием Spring Security.
 * Класс реализует интерфейс `UserDetails`, который определяет методы, предоставляющие информацию
 * о пользователе, его ролях и статусе аккаунта для Spring Security.
 * Каждый экземпляр `CustomUserDetails` связан с объектом класса `User`, который представляет
 * собой модель пользователя в системе.
 * Этот класс используется для предоставления информации о пользователе Spring Security и
 * его аутентификации, а также для управления разрешениями доступа.
 * @author Антон
 */

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }


    /**
     * Возвращает коллекцию ролей (полномочий) пользователя.
     *
     * @return Коллекция ролей пользователя.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().name()));
    }

    /**
     * Возвращает пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Возвращает имя пользователя (в данном случае, email).
     *
     * @return Имя пользователя (email).
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Проверяет, истек ли срок действия аккаунта пользователя.
     *
     * @return `true`, если срок действия аккаунта не истек, иначе `false`.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверяет, заблокирован ли аккаунт пользователя.
     *
     * @return `true`, если аккаунт не заблокирован, иначе `false`.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверяет, истекли ли учетные данные пользователя (например, пароль).
     *
     * @return `true`, если учетные данные не истекли, иначе `false`.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверяет, включен ли аккаунт пользователя.
     *
     * @return `true`, если аккаунт включен, иначе `false`.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
