package ru.procodehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.procodehub.models.User;

import java.util.Optional;

/**
 * Интерфейс репозитория для работы с данными пользователей.
 * Предоставляет методы для поиска и взаимодействия с пользователями в базе данных.
 * @author Антон
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Найти пользователя по имени пользователя (логину).
     *
     * @param username Имя пользователя (логин).
     * @return Optional, содержащий пользователя, если найден, или пустой, если пользователь не найден.
     */
    Optional<User> findByUsername(String username);
}
