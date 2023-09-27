package ru.procodehub.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Перечисление, представляющее роли пользователей в системе.
 * Роли определяют уровень доступа пользователей к функционалу платформы.
 * @author Антон
 */
public enum UserRole implements GrantedAuthority {
    /**
     * Роль "Администратор".
     * Администраторы обладают полным доступом ко всем функциям системы.
     */
    ADMIN,
    /**
     * Роль "Пользователь".
     * Пользователи имеют ограниченный доступ и могут использовать основной функционал системы.
     */
    USER,
    /**
     * Роль "Гость".
     * Гости могут иметь ограниченный доступ к некоторым функциям системы.
     */
    GUEST;

    /**
     * Получить наименование роли как ее авторитет (GrantedAuthority).
     * Этот метод требуется для интеграции с Spring Security.
     *
     * @return Наименование роли в виде авторитета.
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
